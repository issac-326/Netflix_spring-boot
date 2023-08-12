package hn.unah.proyecto.netflix.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    public List<Perfil> retornarPerfiles(@PathVariable int idUsuario) {
        return perfilImplementacion.retornarPerfiles(idUsuario);
    }

    @GetMapping("/cambiar/estado/{idPerfil}")
    public Optional<Perfil> ingresarAlPerfil(@PathVariable int idPerfil) {
        return perfilImplementacion.ingresarAlPerfil(idPerfil);
    }

    // crea un perfil
    @PostMapping("/crear/{idUsuario}")
    public Perfil crearPerfil(@RequestBody Perfil perfil, @PathVariable int idUsuario) {
        return perfilImplementacion.crearPerfil(perfil, idUsuario);
    }

    // perfilModificado va la informacion que se desea modificar y idUsuario es para
    // saber a que Usuario le pertenece
    @PostMapping("/modificarPerfil/{idPerfil}")
    public Perfil modificarPerfil(@RequestBody Perfil perfilModificado, @PathVariable int idPerfil) {
        return perfilImplementacion.actualizarPerfil(perfilModificado, idPerfil);
    }

    @GetMapping("/eliminar/{idPerfil}")
    public String eliminarPerfil(@PathVariable int idPerfil){
        return perfilImplementacion.eliminarPerfil(idPerfil);
    }
}
