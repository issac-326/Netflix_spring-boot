package hn.unah.proyecto.netflix.services;

import java.util.List;
import java.util.Optional;

import hn.unah.proyecto.netflix.models.Perfil;

public interface PerfilService {
    
    public Optional<Perfil> cambiarEstado(Perfil perfil);

    public List<Perfil> retornarPerfiles(int idUsuario);
}
