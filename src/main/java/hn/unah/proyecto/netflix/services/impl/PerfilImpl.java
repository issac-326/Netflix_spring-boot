package hn.unah.proyecto.netflix.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.proyecto.netflix.models.Perfil;
import hn.unah.proyecto.netflix.models.Usuario;
import hn.unah.proyecto.netflix.repositorys.PerfilRepository;
import hn.unah.proyecto.netflix.repositorys.UsuarioRepository;
import hn.unah.proyecto.netflix.services.PerfilService;

@Service
public class PerfilImpl implements PerfilService{

    @Autowired
    private UsuarioRepository usuarioRepositorio;

    @Autowired
    private PerfilRepository perfilRepositorio;

    //al ingresar a un perfil cambia el estado a activo
    @Override
    public Perfil cambiarEstado(int idPerfil) {

        Optional<Perfil> perfilBuscar = perfilRepositorio.findById(idPerfil);

        Perfil perfil = perfilBuscar.get();

        if(perfil.getEstado() == true){
            perfil.setEstado(false);
        }else{
            perfil.setEstado(true);
        }
        perfilRepositorio.save(perfil);
        return perfil;
    }

    @Override
    public List<Perfil> retornarPerfiles(int idUsuario) {
        
        Optional<Usuario> usuario = usuarioRepositorio.findById(idUsuario);

        return usuario.get().getPerfiles();
    }
    
}
