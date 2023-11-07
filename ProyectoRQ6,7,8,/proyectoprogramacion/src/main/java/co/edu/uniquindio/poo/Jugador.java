/**
 * Clase que agrupa los datos de un Jugador
 * @author Área de programación UQ
 * @since 2023-09
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.Period;
import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class Jugador extends Persona {
    private final LocalDate fechaNacimiento;
    private final TipoGenero tipoGenero;


    public Jugador(String nombre, String apellido, String email, String celular, LocalDate fechaNacimiento, TipoGenero tipoGenero) {
        super(nombre, apellido, email, celular);
        ASSERTION.assertion( fechaNacimiento != null , "La fecha de nacimiento es requerida");
        this.fechaNacimiento = fechaNacimiento;
        this.tipoGenero = tipoGenero;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }
    
    public TipoGenero getTipoGenero() {
        return tipoGenero;
    }
    /**
     * Permite calcula la edad que tiene un jugador en una fecha dada.
     * @param fecha Fecha contra la cual se desea calcular la edad del jugador.
     * @return La edad que tiene en años en la fecha dada.
     */
    public byte calcularEdad(LocalDate fecha){
        return (byte) Period.between(fechaNacimiento, fecha).getYears();
    }
}
