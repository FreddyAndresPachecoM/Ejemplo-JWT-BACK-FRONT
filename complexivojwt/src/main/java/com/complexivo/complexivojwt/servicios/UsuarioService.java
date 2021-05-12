package com.complexivo.complexivojwt.servicios;

import java.util.List;

import com.complexivo.complexivojwt.modelos.Usuario;

public interface UsuarioService {

    Usuario agregarUsuario(Usuario usuario);
    List<Usuario> recuperarUsuarios();
    Usuario buscarPorUsername(String username);
    Usuario iniciarSesion(String username, String contrasena);
    
    Usuario updateUsuario(Usuario usuario, Long id);
    
    String deleteUsuario(Long id);
}
