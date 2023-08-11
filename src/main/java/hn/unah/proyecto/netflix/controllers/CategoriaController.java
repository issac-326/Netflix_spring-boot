package hn.unah.proyecto.netflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hn.unah.proyecto.netflix.models.Categoria;
import hn.unah.proyecto.netflix.services.impl.CategoriaImpl;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController {
    
    @Autowired
    private CategoriaImpl categoriaImplementacion;

    @GetMapping("/todas")
    public List<Categoria> obtenerCategorias(){
        return categoriaImplementacion.obtenerCategorias();
    }
}
