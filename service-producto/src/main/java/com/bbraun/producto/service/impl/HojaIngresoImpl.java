package com.bbraun.producto.service.impl;

import com.bbraun.producto.models.dto.DetalleHojaDto;
import com.bbraun.producto.models.dto.HojaIngresoDto;
import com.bbraun.producto.models.entity.DetalleHoja;
import com.bbraun.producto.models.entity.HojaIngreso;
import com.bbraun.producto.repository.DetalleHojaRepository;
import com.bbraun.producto.repository.HojaIngresoRepository;
import com.bbraun.producto.service.IHojaService;
import com.bbraun.producto.util.DetalleHojaConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HojaIngresoImpl implements IHojaService {

    @Autowired
    private HojaIngresoRepository hojaIngresoRepository;


    @Autowired
    private DetalleHojaRepository detalleHojaRepository;

    @Autowired
    private DetalleHojaConverter detalleHojaConverter;

    @Override
    public List<HojaIngreso> findAll() {
        return hojaIngresoRepository.findAll();
    }

    @Override
    public HojaIngreso findByIdhoja(String idhoja) {
        return hojaIngresoRepository.findByIdhoja(idhoja);
    }

    @Override
    public List<HojaIngresoDto> findAllHojaWithDetails() {
        List<HojaIngreso> hojas = hojaIngresoRepository.findAll();
        List<HojaIngresoDto> hojaIngresoDtos = new ArrayList<>();
        for(HojaIngreso hoja : hojas){
            List<DetalleHoja> detalles = detalleHojaRepository.findAllByIdhoja(hoja.getIdhoja());
            List<DetalleHojaDto> detalleHojaDtos = new ArrayList<>();
            for (DetalleHoja detalle : detalles){
                DetalleHojaDto detalleHojaDto = DetalleHojaDto.builder()
                        .idproducto(detalle.getIdproducto())
                        .cantidad(detalle.getCantidad())
                        .build();
                detalleHojaDtos.add(detalleHojaDto);
            }
            HojaIngresoDto hojaIngresoDto = HojaIngresoDto.builder()
                    .idhoja(hoja.getIdhoja())
                    .idempleado(hoja.getIdempleado())
                    .fechaingreso(hoja.getFechaingreso())
                    .detalles(detalleHojaDtos)
                   .build();

            hojaIngresoDtos.add(hojaIngresoDto);
        }
        return hojaIngresoDtos;
    }

    @Override
    public HojaIngreso saveHojaIngresoWithDetails(HojaIngresoDto dto) {
        LocalDate today = LocalDate.now();
        LocalDate fechaIngresoDto = LocalDate.ofInstant(dto.getFechaingreso().toInstant(), ZoneId.systemDefault());

        // Obtener el último código de hoja de ingreso
        String last_code = hojaIngresoRepository.getLastCodeHoja().get(0);

        // Verificar si la hoja de ingreso es para hoy
        if (fechaIngresoDto.equals(today)) { // Cuando es una hoja de ingreso del mismo día
            // Obtener la hoja de ingreso existente para hoy
            HojaIngreso hojaIngresoExistente = hojaIngresoRepository.findByFechaingreso(Date.from(today.atStartOfDay(ZoneId.systemDefault()).toInstant()));

            if (hojaIngresoExistente != null) {
                // Actualizar los detalles de la hoja de ingreso existente
                dto.setIdhoja(last_code);
                DetalleHoja detalleHoja = detalleHojaRepository.save(detalleHojaConverter.convertToEntityDetails(dto));
                return hojaIngresoExistente;
            } else {
                // Crear una nueva hoja de ingreso para hoy
                String code = getCodeHoja(last_code); // Nuevo código para la hoja
                dto.setIdhoja(code); // Asignar el nuevo código
                HojaIngreso hojaIngreso = detalleHojaConverter.convertToEntity(dto);
                HojaIngreso hojaSaved = hojaIngresoRepository.save(hojaIngreso);
                DetalleHoja detalleHoja = detalleHojaRepository.save(detalleHojaConverter.convertToEntityDetails(dto));
                return hojaSaved;
            }
        } else { // Cuando es una hoja de ingreso para un día diferente
            // Crear una nueva hoja de ingreso con un nuevo código
            String code = getCodeHoja(last_code); // Nuevo código para la hoja
            dto.setIdhoja(code); // Asignar el nuevo código
            HojaIngreso hojaIngreso = detalleHojaConverter.convertToEntity(dto);
            HojaIngreso hojaSaved = hojaIngresoRepository.save(hojaIngreso);
            DetalleHoja detalleHoja = detalleHojaRepository.save(detalleHojaConverter.convertToEntityDetails(dto));
            return hojaSaved;
        }
    }

    @Override
    public List<HojaIngresoDto> findWithDetails() {
        List<Object[]> results = hojaIngresoRepository.findAllWithDetails();
        List<HojaIngresoDto> hojasConDetalles = new ArrayList<>();

        for (Object[] row : results) {
            String idHoja = (String) row[0];
            Date fechaIngreso = (Date) row[1];

            // Create HojaIngresoDto if it doesn't exist in the list
            HojaIngresoDto hojaIngresoDto = hojasConDetalles.stream()
                    .filter(h -> h.getIdhoja().equals(idHoja))
                    .findFirst()
                    .orElseGet(() -> {
                        HojaIngresoDto newHoja = new HojaIngresoDto();
                        newHoja.setIdhoja(idHoja);
                        newHoja.setFechaingreso(fechaIngreso);
                        newHoja.setDetalles(new ArrayList<>());
                        hojasConDetalles.add(newHoja);
                        return newHoja;
                    });

            // Add DetalleHojaDto to HojaIngresoDto
            DetalleHojaDto detalleHojaDto = DetalleHojaDto.builder()
                    .idproducto((String) row[2])
                    .cantidad((Integer) row[3])
                    .nombreProducto((String) row[4])
                    .build();

            hojaIngresoDto.getDetalles().add(detalleHojaDto);
        }

        return hojasConDetalles;
    }

    public String getCodeHoja(String last_code){
        String code = "";
        if(last_code.charAt(3) == '0' && last_code.charAt(4) == '0'){
            code = "HO-00" +(Integer.parseInt(last_code.substring(3)) + 1);
        }else if(last_code.charAt(3) == '0' && last_code.charAt(4) != '0'){
            code = "HO-0" +(Integer.parseInt(last_code.substring(3)) + 1);

        }else if (last_code.charAt(3) != '0' && last_code.charAt(4) != '0'){
            code = "HO-" +(Integer.parseInt(last_code.substring(3)) + 1);
        }

        return code;
    }
}
