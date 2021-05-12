package com.complexivo.complexivojwt.repositorios;

import com.complexivo.complexivojwt.modelos.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
    
    Usuario findByUsername(String username);
    Usuario findByContrasena(String contrasena);
    Usuario findByUsernameAndContrasena(String username,String contrasena);
    
    Usuario findByUserId(Long id);
}
