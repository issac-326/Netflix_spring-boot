package hn.unah.proyecto.netflix.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.proyecto.netflix.dto.UsuarioTarjeta;
import hn.unah.proyecto.netflix.models.Usuario;
import hn.unah.proyecto.netflix.services.impl.UsuarioImpl;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    
    @Autowired
    private UsuarioImpl usuarioImplementacion;

        
    @GetMapping("/usuario/{idUsuario}")
    public Optional<Usuario> obtenerUsuario(@PathVariable int idUsuario){
        return usuarioImplementacion.obtenerUsuario(idUsuario);
    }

    @GetMapping("/usuario")
    public Optional<Usuario> login(@RequestBody Usuario usuario){
        return usuarioImplementacion.login(usuario);
    }

    @PostMapping("/usuario/crear")
    public Optional<Usuario> registro(@RequestBody UsuarioTarjeta usuarioTarjeta){
        return usuarioImplementacion.registro(usuarioTarjeta);
    }

}
