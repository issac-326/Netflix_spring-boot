package hn.unah.proyecto.netflix.services;

import java.util.Optional;

import hn.unah.proyecto.netflix.dto.UsuarioTarjeta;
import hn.unah.proyecto.netflix.models.Usuario;

public interface UsuarioService {
    
    public Optional<Usuario> login(Usuario usuario);

    public Optional<Usuario> registro(UsuarioTarjeta usuarioTarjeta);

    public Optional<Usuario> obtenerUsuario(int idUsuario);

}
