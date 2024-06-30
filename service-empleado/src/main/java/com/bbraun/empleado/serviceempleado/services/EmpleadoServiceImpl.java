package com.bbraun.empleado.serviceempleado.services;

import com.bbraun.empleado.serviceempleado.models.dto.EmpleadoDto;
import com.bbraun.empleado.serviceempleado.models.entity.Empleado;
import com.bbraun.empleado.serviceempleado.models.entity.Usuario;
import com.bbraun.empleado.serviceempleado.repository.EmpleadoRepository;
import com.bbraun.empleado.serviceempleado.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EmpleadoServiceImpl implements IEmpleadoService{

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public EmpleadoDto findEmpleadoByEmail(String email) {

        Usuario usuario = usuarioRepository.findByEmail(email).orElse(null);
        Empleado empleado = empleadoRepository.findByCuenta(usuario);

        EmpleadoDto empleadoDto = EmpleadoDto.builder()
                .idempleado(empleado.getIdempleado())
                .nombre(empleado.getNombre())
                .apellido(empleado.getApellido())
                .telefono(empleado.getTelefono())
                .dni(empleado.getDni())
                .direccion(empleado.getDireccion())
                .fechaNacimiento( empleado.getFechanacimiento())
                .genero(empleado.getGenero())
                .cargo(empleado.getCargo())
                .build();

        return empleadoDto;
    }

    @Override
    public List<Empleado> findAll() {
        return empleadoRepository.findAll();
    }
}
