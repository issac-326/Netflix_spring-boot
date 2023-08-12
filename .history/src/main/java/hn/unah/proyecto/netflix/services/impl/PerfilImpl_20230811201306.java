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
public class PerfilImpl implements PerfilService {

    @Autowired
    private UsuarioRepository usuarioRepositorio;

    @Autowired
    private PerfilRepository perfilRepositorio;

    // al ingresar a un perfil cambia el estado a activo
    @Override
    public Optional<Perfil> ingresarAlPerfil(int idPerfil) {

        Optional<Perfil> perfilBuscar = perfilRepositorio.findById(idPerfil);

        Perfil perfil = perfilBuscar.get();

        if (perfil.getEstado() == true) {
            // El perfil ya esta en uso
            return Optional.empty();
        } else {
            perfil.setEstado(true);
        }

        perfilRepositorio.save(perfil);
        return perfilBuscar;
    }

    @Override
    public List<Perfil> retornarPerfiles(int idUsuario) {

        Optional<Usuario> usuario = usuarioRepositorio.findById(idUsuario);

        return usuario.get().getPerfiles();
    }

    @Override
    public Perfil crearPerfil(Perfil perfil, int idUsuario) {
        Optional<Usuario> usuario = usuarioRepositorio.findById(idUsuario);
        perfil.setUsuarioP(usuario.get());
        return perfilRepositorio.save(perfil);
    }

    @Override
    public Optional<Perfil> actualizarPerfil(Perfil perfilModificado, int idUsuario) {
        Optional<Usuario> usuario = usuarioRepositorio.findById(idUsuario);

        if (!usuario.isPresent()) {
            return Optional.empty();
        }

        Optional<Perfil> perfil = perfilRepositorio.findByUsuarioP(usuario.get());

        if (perfil == null) {
            return Optional.empty();
        }

        if (perfilModificado.getContrasena() != null) {
            perfil.setContrasena(perfilModificado.getContrasena());
        }
        if (perfilModificado.getImagen() != null) {
            perfil.setImagen(perfilModificado.getImagen());
        }
        if (perfilModificado.getNombre() != null) {
            perfil.setNombre(perfilModificado.getNombre());
        }

        perfilRepositorio.save(perfil);
        return Optional.of(perfil);
    }
}
