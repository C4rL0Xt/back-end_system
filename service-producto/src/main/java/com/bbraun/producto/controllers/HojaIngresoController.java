package com.bbraun.producto.controllers;

import com.bbraun.producto.exception.InvalidDataException;
import com.bbraun.producto.exception.ResourceNotFoundException;
import com.bbraun.producto.models.dto.HojaIngresoDto;
import com.bbraun.producto.models.entity.DetalleHoja;
import com.bbraun.producto.models.entity.HojaIngreso;
import com.bbraun.producto.models.entity.Producto;
import com.bbraun.producto.service.IDetallHoja;
import com.bbraun.producto.service.IHojaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/hoja")
public class HojaIngresoController {

    @Autowired
    private IHojaService hojaService;

    @Autowired
    private IDetallHoja detalleHoja;

    @GetMapping("/listar")
    public List<HojaIngreso> findAll() {
        return hojaService.findAll();
    }

    @GetMapping("/detalles")
    public List<DetalleHoja> findAllDetalles() {
        return detalleHoja.findAll();
    }

    @GetMapping("/all")
    public List<HojaIngresoDto> findAllHojaWithDetails() {
        return hojaService.findAllHojaWithDetails();
    }

    @GetMapping("/buscar-id/{idhoja}")
    public HojaIngreso findByIdhoja(@PathVariable("idhoja") String idhoja){
        return hojaService.findByIdhoja(idhoja);
    }

    @PostMapping("/save")
    public ResponseEntity<HojaIngreso> saveHojaIngresoWithDetails(@RequestBody HojaIngresoDto dto) {
        try{
            HojaIngreso hojaIngreso = hojaService.saveHojaIngresoWithDetails(dto);
            URI location = ServletUriComponentsBuilder
                    .fromCurrentContextPath()
                    .path("/buscar-id/{idproducto}")
                    .buildAndExpand(hojaIngreso.getIdhoja())
                    .toUri();
            return ResponseEntity.created(location).body(hojaIngreso);
        }catch (ResourceNotFoundException e){
            return ResponseEntity.notFound().build();
        }catch (InvalidDataException e){
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping("/data")
    public List<HojaIngresoDto> getWithDetails(){
        return hojaService.findWithDetails();
    }
}
