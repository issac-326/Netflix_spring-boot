package hn.unah.proyecto.netflix.repositorys;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import hn.unah.proyecto.netflix.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    Optional<Usuario> findByCorreo(String correo);

}
