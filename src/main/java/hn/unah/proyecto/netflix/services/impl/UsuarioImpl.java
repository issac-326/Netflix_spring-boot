package hn.unah.proyecto.netflix.services.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.proyecto.netflix.dto.UsuarioTarjeta;
import hn.unah.proyecto.netflix.models.Usuario;
import hn.unah.proyecto.netflix.repositorys.UsuarioRepository;
import hn.unah.proyecto.netflix.services.UsuarioService;

@Service
public class UsuarioImpl implements UsuarioService{

    @Autowired
    private UsuarioRepository usuarioRepositorio;

    @Override
    public Optional<Usuario> login(Usuario usuario) {
        //Se envia el correo y contraseña
        //busca el correo
        Optional<Usuario> Encontradousuario = usuarioRepositorio.findByCorreo(usuario.getCorreo());
        //verifica si encontro un usuario con ese correo
        if(Encontradousuario.isEmpty()){
            //no lo encontro xd
            return Encontradousuario;
        }else{
            //si lo hizo y verifica si la contraseña es la misma
            if(Encontradousuario.get().getContrasena().equals(usuario.getContrasena())){
                //envia el usuario
                return Encontradousuario;
            }
        }
        //la contraseña era incorrecta
        return Optional.empty();
    }

    @Override
    public Optional<Usuario> registro(UsuarioTarjeta usuarioTarjeta) {
        /* String correo;
         String contrasena;
         String nombre;
         String apellido;
         int idPlan;
         int numeroTarjeta;
         int cvv;
         String tipoTarjeta;  */

         Usuario usuario = new Usuario();
         Date fechaActual = new Date();

         usuario.setCorreo(usuarioTarjeta.getCorreo());
         usuario.setContrasena(usuarioTarjeta.getContrasena());
         usuario.setApellido(usuarioTarjeta.getApellido());
         usuario.setNombre(usuarioTarjeta.getNombre());
         usuario.setFechaRegistro(fechaActual);
    }
    
}
