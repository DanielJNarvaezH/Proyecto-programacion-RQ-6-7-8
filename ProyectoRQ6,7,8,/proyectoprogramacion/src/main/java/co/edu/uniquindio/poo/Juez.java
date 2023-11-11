/**
 * Clase que representa un Juez, hereda atributos y métodos de la clase Persona
 * @author Área de programación UQ - Daniel Narvaez, Diego Flores, Esteban Maya
 * @since 2023-09
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

public class Juez extends Persona {

    private String licenciaJuez;
    private final Collection<Enfrentamiento> enfrentamientos;

    public Juez(String nombre, String apellido, String email, String celular, String licenciaJuez) {

        super(nombre, apellido, email, celular);
        ASSERTION.assertion(licenciaJuez != null, "La licencia del juez es requerida");
        this.licenciaJuez = licenciaJuez;
        this.enfrentamientos = new LinkedList<>();
    }

    public String getLicenciaJuez() {
        return licenciaJuez;
    }

    public Collection<Enfrentamiento> getEnfrentamientos() {
        return Collections.unmodifiableCollection(enfrentamientos);
    }

    /**
     * Método que devuelve una colección de enfrentamientos en los que participa un equipo
     * con una licencia dada.
     * 
     * @param licencia La licencia del equipo.
     * @return Una colección de enfrentamientos en los que participa el equipo.
     */
    public Collection<Enfrentamiento> obtenerListaEnfrentamientosEquipoPorLicencia(String licencia) {
        return enfrentamientos.stream()
                .filter(enfrentamiento -> enfrentamiento.getJueces().stream()
                        .anyMatch(juez -> juez.getLicenciaJuez().equals(licencia)))
                .toList();
    }

}