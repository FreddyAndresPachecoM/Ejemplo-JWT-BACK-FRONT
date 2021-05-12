package com.complexivo.complexivojwt.controladores;

import java.util.List;

import com.complexivo.complexivojwt.auth.GenerarToken;
import com.complexivo.complexivojwt.modelos.Usuario;
import com.complexivo.complexivojwt.servicios.UsuarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @GetMapping("/listar-usuarios")
    public List<Usuario> getUsuarios(){

        return usuarioService.recuperarUsuarios();
        
    }


    @GetMapping("/crear-prueba")
    public Usuario crearUsuarioManual(){
        Usuario usuario = new Usuario();
        usuario.setUsername("usuario");
        usuario.setContrasena("1234");
        usuario.setNombreCompleto("Usuario de Prueba");
        return usuarioService.agregarUsuario(usuario);

    }

    @GetMapping("/login")
    public Usuario login(@RequestParam("username") String username,@RequestParam("contrasena") String contrasena){

        Usuario usuario = usuarioService.iniciarSesion(username, contrasena);

        if(usuario != null){

            usuario.setToken(GenerarToken.getJwtToken(username));
            return usuario;
            //generar mi token

        }
            

    return new Usuario();
        
    }
    
    @GetMapping("/login/{username}/{contrasena}")
    public Usuario loginUsuario(@PathVariable String username, @PathVariable String contrasena) {
    	Usuario usuario = usuarioService.iniciarSesion(username, contrasena);

        if(usuario != null){

            usuario.setToken(GenerarToken.getJwtToken(username));
            return usuario;
            //generar mi token

        }
            

        return new Usuario();
    }
    
    
    @PostMapping(path = "/crear", consumes = "application/json", produces = "application/json")
    public Usuario crear(@RequestBody Usuario usuario) {
    	return usuarioService.agregarUsuario(usuario);
    }
    
    @PutMapping("/actualizar/{id}")
    public Usuario updateUsuario(@RequestBody Usuario usuario, @PathVariable Long id) {
    		return usuarioService.updateUsuario(usuario, id);
    }
    
    @DeleteMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
    	return usuarioService.deleteUsuario(id);
    }
    
    
}
