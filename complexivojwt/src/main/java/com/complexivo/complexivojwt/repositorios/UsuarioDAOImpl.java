package com.complexivo.complexivojwt.repositorios;

import java.util.List;

import com.complexivo.complexivojwt.modelos.Usuario;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UsuarioDAOImpl implements UsuarioDAO{

    @Autowired
    UsuarioRepository usuarioRepository;

    @Override
    public Usuario createUsuario(Usuario usuario) {
        // TODO Auto-generated method stub
        Usuario usuarioCreado = usuarioRepository.save(usuario);

        return usuarioCreado;
    }

    @Override
    public Usuario recuperarPorUsername(String username) {
        // TODO Auto-generated method stub
        Usuario usuario = usuarioRepository.findByUsername(username);
        return usuario;
    }

    @Override
    public List<Usuario> getUsuarios() {
        // TODO Auto-generated method stub

        return usuarioRepository.findAll();
    }

    @Override
    public Usuario iniciarSesion(String username, String contrasena) {
        // TODO Auto-generated method stub
        return usuarioRepository.findByUsernameAndContrasena(username, contrasena);
    }

	@Override
	public Usuario  updateUsuario(Usuario usuario, Long id) {
		// TODO Auto-generated method stub
		if (usuarioRepository.findByUserId(id) != null) {
			usuario.setUserId(id);
			return usuarioRepository.save(usuario);
		}else {
			return null;
		}
	}

	@Override
	public String deleteUsuario(Long id) {
		// TODO Auto-generated method stub
		if (usuarioRepository.findByUserId(id) != null) {
			usuarioRepository.deleteById(id);
			return "Usuario Eliminado";
		}
		return "Usuario no existente";
	}
    
}
