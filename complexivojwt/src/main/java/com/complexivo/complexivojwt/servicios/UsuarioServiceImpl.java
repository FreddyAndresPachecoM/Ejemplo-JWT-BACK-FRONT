package com.complexivo.complexivojwt.servicios;

import java.util.List;

import com.complexivo.complexivojwt.modelos.Usuario;
import com.complexivo.complexivojwt.repositorios.UsuarioDAO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServiceImpl implements UsuarioService{

    @Autowired
    private UsuarioDAO usuarioDAO;
    
    @Override
    public Usuario agregarUsuario(Usuario usuario) {
        // TODO Auto-generated method stub
        if(usuarioDAO.recuperarPorUsername(usuario.getUsername())==null){
            
            return usuarioDAO.createUsuario(usuario);
        }
        return null;
    }

    @Override
    public List<Usuario> recuperarUsuarios() {
        // TODO Auto-generated method stub
        return usuarioDAO.getUsuarios();
    }

    @Override
    public Usuario buscarPorUsername(String username) {
        // TODO Auto-generated method stub
        return usuarioDAO.recuperarPorUsername(username);
    }

    @Override
    public Usuario iniciarSesion(String username, String contrasena) {
        // TODO Auto-generated method stub
        return usuarioDAO.iniciarSesion(username, contrasena);
    }
    
	@Override
	public Usuario updateUsuario(Usuario usuario, Long id) {
		// TODO Auto-generated method stub
		return usuarioDAO.updateUsuario(usuario, id);
	}

	@Override
	public String deleteUsuario(Long id) {
		// TODO Auto-generated method stub
		return usuarioDAO.deleteUsuario(id);
	}

	
    
}
