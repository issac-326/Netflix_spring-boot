package hn.unah.proyecto.netflix.repositorys;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import hn.unah.proyecto.netflix.models.Perfil;
import hn.unah.proyecto.netflix.models.Usuario;

public interface PerfilRepository extends CrudRepository<Perfil, Integer> {

    Optional<Perfil> findByUsuarioP(Optional<Usuario> usuario);
}
