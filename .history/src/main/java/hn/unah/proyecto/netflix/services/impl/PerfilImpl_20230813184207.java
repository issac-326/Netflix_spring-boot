package hn.unah.proyecto.netflix.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.proyecto.netflix.models.Pelicula;
import hn.unah.proyecto.netflix.models.Perfil;
import hn.unah.proyecto.netflix.models.Usuario;
import hn.unah.proyecto.netflix.repositorys.PeliculaRepository;
import hn.unah.proyecto.netflix.repositorys.PerfilRepository;
import hn.unah.proyecto.netflix.repositorys.UsuarioRepository;
import hn.unah.proyecto.netflix.services.PerfilService;

@Service
public class PerfilImpl implements PerfilService {

    @Autowired
    private UsuarioRepository usuarioRepositorio;

    @Autowired
    private PerfilRepository perfilRepositorio;

    @Autowired
    private PeliculaRepository peliculaRepositorio;

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
    public Optional<Perfil> obtenerPerfil(int id) {
        return perfilRepositorio.findById(id);
    }

    @Override
    public Perfil actualizaPerfil(Perfil perfil) {

        Optional<Perfil> perfilActualizar = perfilRepositorio.findById(perfil.getIdPerfil());

        perfilActualizar.get().setContraseniaperfil(perfil.getContraseniaperfil());
        perfilActualizar.get().setImagen(perfil.getImagen());
        perfilActualizar.get().setNombre(perfil.getNombre());

        return perfilRepositorio.save(perfilActualizar.get());
    }

    @Override
    public String eliminarPerfil(int idPerfil) {

        Optional<Perfil> perfil = perfilRepositorio.findById(idPerfil);

        perfilRepositorio.delete(perfil.get());

        return "se elimino perfil";
    }

    @Override
    public Optional<Perfil> contadorActivo(int idPerfil, int idUsuario) {

        Optional<Perfil> perfilBuscar = perfilRepositorio.findById(idPerfil);
        Optional<Usuario> usuarioBuscar = usuarioRepositorio.findById(idUsuario);
        if (usuarioBuscar.get().getUsuarioActivos() >= usuarioBuscar.get().getPlan().getCantidadPerfiles()) {
            return Optional.empty();
        }

        Usuario usuario = usuarioBuscar.get();

        usuario.setUsuarioActivos(usuario.getUsuarioActivos() + 1);
        usuarioRepositorio.save(usuario);
        return perfilBuscar;
    }

    @Override
    public List<Pelicula> seguirViendo(int idPerfil) {
        Optional<Perfil> perfil = perfilRepositorio.findById(idPerfil);
        return perfil.get().getSeguirViendo();
    }

    @Override
    public List<Pelicula> verMasTarde(int idPerfil) {
        Optional<Perfil> perfil = perfilRepositorio.findById(idPerfil);
        return perfil.get().getVerMasTarde();
    }

    @Override
    public String guardarSeguirViendo(int idPerfil, int idPelicula) {
        Optional<Perfil> perfil = perfilRepositorio.findById(idPerfil);
        Optional<Pelicula> pelicula = peliculaRepositorio.findById(idPelicula);
        if (perfil.isEmpty()) {
            // no lo encontro xd
            return "No se encontro perfil";

        if (pelicula.isEmpty()) {
            // no lo encontro xd
            return "No se encontro perfil";
            
        perfil.get().getSeguirViendo().add(pelicula.get());
        perfilRepositorio.save(perfil.get());
        return "se agrego la pelicula a la lista de seguir viendo";
    }

    @Override
    public String guardarVerMasTarde(int idPerfil, int idPelicula) {
        Optional<Perfil> perfil = perfilRepositorio.findById(idPerfil);
        Optional<Pelicula> pelicula = peliculaRepositorio.findById(idPelicula);
        perfil.get().getVerMasTarde().add(pelicula.get());
        perfilRepositorio.save(perfil.get());
        return "se agrego la pelicula a la lista de ver mas tarde";
    }

    @Override
    public String eliminarSeguirViendo(int idPerfil, int idPelicula) {
        Optional<Perfil> perfil = perfilRepositorio.findById(idPerfil);
        Optional<Pelicula> pelicula = peliculaRepositorio.findById(idPelicula);
        perfil.get().getSeguirViendo().remove(pelicula.get());
        perfilRepositorio.save(perfil.get());
        return "se elimin la pelicula a la lista de seguir viendo";
    }

    @Override
    public String eliminarVerMasTarde(int idPerfil, int idPelicula) {
        Optional<Perfil> perfil = perfilRepositorio.findById(idPerfil);
        Optional<Pelicula> pelicula = peliculaRepositorio.findById(idPelicula);
        perfil.get().getVerMasTarde().remove(pelicula.get());
        perfilRepositorio.save(perfil.get());
        return "se elimino la pelicula a la lista de vermas tarde";
    }
}
