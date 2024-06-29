package com.bbraun.empleado.serviceempleado.repository;

import com.bbraun.empleado.serviceempleado.models.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, String>
{
    Optional<Usuario> findByEmail(String email);
}
