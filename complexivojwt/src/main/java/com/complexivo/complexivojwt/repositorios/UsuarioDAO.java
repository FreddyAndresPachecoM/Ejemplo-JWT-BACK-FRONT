package com.complexivo.complexivojwt.repositorios;

import java.util.List;

import com.complexivo.complexivojwt.modelos.Usuario;



public interface UsuarioDAO {

    Usuario createUsuario(Usuario usuario);

    Usuario recuperarPorUsername(String username);

    List<Usuario> getUsuarios();

    Usuario iniciarSesion(String username, String contrasena);

    Usuario updateUsuario(Usuario usuario, Long id);
    
    String deleteUsuario(Long id);
}


