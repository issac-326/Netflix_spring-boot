package hn.unah.proyecto.netflix.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.proyecto.netflix.models.Categoria;
import hn.unah.proyecto.netflix.repositorys.CategoriaRepository;
import hn.unah.proyecto.netflix.services.CategoriaService;

@Service
public class CategoriaImpl implements CategoriaService{

    @Autowired
    private CategoriaRepository categoriaRepositorio;

    @Override
    public List<Categoria> obtenerCategorias() {
        Iterable<Categoria> categorias = categoriaRepositorio.findAll();

        List<Categoria> listaCategorias = new ArrayList<>();

        categorias.forEach(listaCategorias::add);

        return listaCategorias;
    }
    
}
