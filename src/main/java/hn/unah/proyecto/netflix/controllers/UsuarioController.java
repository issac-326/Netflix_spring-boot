package hn.unah.proyecto.netflix.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.proyecto.netflix.models.Usuario;
import hn.unah.proyecto.netflix.services.impl.UsuarioImpl;

@RestController
@RequestMapping("/api")
public class UsuarioController {
    
    @Autowired
    private UsuarioImpl usuarioImplementacion;

    @GetMapping("/usuario")
    public Usuario login(@RequestBody Usuario usuario){
        return usuarioImplementacion.login(usuario);
    }

}
