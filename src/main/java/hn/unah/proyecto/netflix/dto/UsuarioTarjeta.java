package hn.unah.proyecto.netflix.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UsuarioTarjeta {
    
    private String correo;
    private String contrasena;
    private String nombre;
    private String apellido;
    private int idPlan;
    private int numeroTarjeta;
    private int cvv;
    private Date fechaVencimiento;
    private String tipoTarjeta;
}
