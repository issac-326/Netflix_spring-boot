package hn.unah.proyecto.netflix.services.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.proyecto.netflix.models.Usuario;
import hn.unah.proyecto.netflix.repositorys.UsuarioRepository;
import hn.unah.proyecto.netflix.services.UsuarioService;

@Service
public class UsuarioImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepositorio;

    @Override
    public Usuario login(Usuario usuario) {
        
        Optional<Usuario> Encontradousuario = usuarioRepositorio.findByCorreo(usuario.getCorreo());

        if(Encontradousuario.isEmpty()){
            System.out.println("en efecto no hau usuario");
        }else{
            if(Encontradousuario.get().getContrasena() == usuario.getContrasena()){
                System.out.println("inicia secion");
            }
        }
        return Encontradousuario.get();
    }
    
}
