package hn.unah.proyecto.netflix.services.impl;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import hn.unah.proyecto.netflix.dto.UsuarioTarjeta;
import hn.unah.proyecto.netflix.models.Factura;
import hn.unah.proyecto.netflix.models.Plan;
import hn.unah.proyecto.netflix.models.Tarjeta;
import hn.unah.proyecto.netflix.models.Usuario;
import hn.unah.proyecto.netflix.repositorys.FacturaRepository;
import hn.unah.proyecto.netflix.repositorys.PerfilRepository;
import hn.unah.proyecto.netflix.repositorys.PlanRepository;
import hn.unah.proyecto.netflix.repositorys.TarjetaRepository;
import hn.unah.proyecto.netflix.repositorys.UsuarioRepository;
import hn.unah.proyecto.netflix.services.UsuarioService;

@Service
public class UsuarioImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepositorio;

    @Autowired
    private TarjetaRepository tarjetaRepositorio;

    @Autowired
    private PlanRepository planRepositorio;

    @Autowired
    private FacturaRepository facturaRepositorio;

    @Autowired
    private PerfilRepository perfilRepositorio;

    @Override
    public Optional<Usuario> login(Usuario usuario) {
        // Se envia el correo y contraseña
        // busca el correo
        Optional<Usuario> Encontradousuario = usuarioRepositorio.findByCorreo(usuario.getCorreo());
        // verifica si encontro un usuario con ese correo
        if (Encontradousuario.isEmpty()) {
            // no lo encontro xd
            return Encontradousuario;
        } else {
            // si lo hizo y verifica si la contraseña es la misma
            if (Encontradousuario.get().getContrasena().equals(usuario.getContrasena())) {
                // envia el usuario
                return Encontradousuario;
            }
        }
        // la contraseña era incorrecta
        return Optional.empty();
    }

    @Override
    public Optional<Usuario> registro(UsuarioTarjeta usuarioTarjeta) {
        System.out.println(usuarioTarjeta);
                System.out.println(1);

        /*
         * String correo;
         * String contrasena;
         * String nombre;
         * String apellido;
         * int idPlan;
         * int numeroTarjeta;
         * int cvv;
         * Date fechaVencimiento;
         * String tipoTarjeta;
         */

        // para verificar si la tarjeta ya existe
        Optional<Tarjeta> tarjetaVerificar = tarjetaRepositorio.findById(usuarioTarjeta.getNumeroTarjeta());
        // para verificar si el correo ya esta en uso
        Optional<Usuario> usuarioCorreo = usuarioRepositorio.findByCorreo(usuarioTarjeta.getCorreo());
        Optional<Plan> plan = planRepositorio.findById(usuarioTarjeta.getIdPlan());
        Usuario usuario = new Usuario();
        Date fechaActual = new Date();

        // factura crear
        Factura factura = new Factura();
        factura.setDescripcion("factura");
        factura.setFechaEmision(fechaActual);
        factura.setMontoTotal(plan.get().getCostoMensual());

        usuario.setCorreo(usuarioTarjeta.getCorreo());
        usuario.setContrasena(usuarioTarjeta.getContrasena());
        usuario.setApellido(usuarioTarjeta.getApellido());
        usuario.setNombre(usuarioTarjeta.getNombre());
        usuario.setFechaRegistro(fechaActual);

        // si la tarjeta no existe si la podemos crear y si el correo no esta en uso
        if (tarjetaVerificar.isEmpty() && usuarioCorreo.isEmpty()) {
            if (usuarioTarjeta.getFechaVencimiento().after(usuario.getFechaRegistro())) {
                // Si entra es por que aun no a expirado
                Tarjeta tarjeta = new Tarjeta();
                tarjeta.setNumeroTarjeta(usuarioTarjeta.getNumeroTarjeta());
                tarjeta.setCvv(usuarioTarjeta.getCvv());
                tarjeta.setFechaVencimiento(usuarioTarjeta.getFechaVencimiento());
/*                 tarjeta.setTipoTarjeta(usuarioTarjeta.getTipoTarjeta());
 */                // se le asigna la tarjeta al usuario
                usuario.setTarjeta(tarjeta);
                usuario.setPlan(plan.get());
                usuarioRepositorio.save(usuario);
                factura.setUsuarioF(usuario);
                Optional<Usuario> nuevoUsuario = usuarioRepositorio.findByCorreo(usuarioTarjeta.getCorreo());
                factura.setUsuarioF(nuevoUsuario.get());
                facturaRepositorio.save(factura);
            } else {
                // si la tarjeta expiro
                return Optional.empty();
            }
        } else {
            // si la tarjeta ya tiene dueño o si el correo esta en uso
            return Optional.empty();
        }

        Optional<Usuario> nueUsuario = usuarioRepositorio.findByCorreo(usuarioTarjeta.getCorreo());
        return nueUsuario;
    }

    @Override
    public Optional<Usuario> obtenerUsuario(int idUsuario) {
        return usuarioRepositorio.findById(idUsuario);
    }

    @Override
    public Usuario actualizarUsuario(Usuario usuario) {
        Optional<Usuario> usuarioActualizar = usuarioRepositorio.findById(usuario.getIdUsuario());

        usuarioActualizar.get().setApellido(usuario.getApellido());
        usuarioActualizar.get().setNombre(usuario.getNombre());
        usuarioActualizar.get().setCorreo(usuario.getCorreo());
        usuarioActualizar.get().setContrasena(usuario.getContrasena());
        usuarioActualizar.get().setPerfiles(usuarioActualizar.get().getPerfiles());

        return usuarioRepositorio.save(usuarioActualizar.get());
    }

    @Override
    public Usuario actualizarTarjeta(int idUsuario, Tarjeta tarjeta) {
        Optional<Usuario> usuarioActualizar = usuarioRepositorio.findById(idUsuario);

        usuarioActualizar.get().setTarjeta(tarjeta);
        return usuarioRepositorio.save(usuarioActualizar.get());
    }

    @Override
    public Usuario actualizarPlan(int idUsuario, int idPlan) {
        Optional<Usuario> usuarioActualizar = usuarioRepositorio.findById(idUsuario);
        Optional<Plan> plan = planRepositorio.findById(idPlan);

        usuarioActualizar.get().setPlan(plan.get());
        return usuarioRepositorio.save(usuarioActualizar.get());
    }

}