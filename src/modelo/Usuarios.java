package modelo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Usuarios {
    private int id;
    private String nombre;
    private String apellidos;
    private String dirrecion;
    private String localidad;

}
