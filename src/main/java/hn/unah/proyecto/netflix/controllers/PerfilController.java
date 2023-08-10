package hn.unah.proyecto.netflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.proyecto.netflix.models.Perfil;
import hn.unah.proyecto.netflix.services.impl.PerfilImpl;

@RestController
@RequestMapping("/api/perfil")
public class PerfilController {
    
    @Autowired
    private PerfilImpl perfilImplementacion;

    @GetMapping("/perfiles/{idUsuario}")
    public List<Perfil> retornarPerfiles(@PathVariable int idUsuario){
        return perfilImplementacion.retornarPerfiles(idUsuario);
    }
}
