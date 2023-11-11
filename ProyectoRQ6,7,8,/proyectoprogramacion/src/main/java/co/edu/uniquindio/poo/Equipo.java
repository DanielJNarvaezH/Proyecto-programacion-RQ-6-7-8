/**
 * Clase que representa un Equipo en un torneo
 * @author Área de programación UQ
 * @since 2023-09
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Optional;
import java.util.function.Predicate;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class Equipo {

    private String nombre;
    private boolean isGanado;
    private boolean isPerdido;
    private boolean isEmpatado;
    private Persona representante;
    private Collection<Jugador> jugadores;
    private Collection<Enfrentamiento> enfrentamientos;
    private Estadistica estadistica;

    public Equipo(String nombre, Persona representante, Estadistica estadistica) {
        ASSERTION.assertion(nombre != null && !nombre.isBlank(), "El nombre es requerido");
        ASSERTION.assertion(representante != null, "El representante es requerido");

        this.nombre = nombre;
        this.isGanado = false;
        this.isPerdido = false;
        this.isEmpatado = false;
        this.representante = representante;
        this.estadistica = estadistica;
        this.jugadores = new LinkedList<>();
        this.enfrentamientos = new LinkedList<>();

    }

    public String nombre() {
        return nombre;
    }

    public boolean isGanado() {
        return isGanado;
    }

    public boolean isPerdido() {
        return isPerdido;
    }

    public boolean isEmpatado() {
        return isEmpatado;
    }

    public Persona representante() {
        return representante;
    }

    public Estadistica getEstadistica() {
        return estadistica;
    }

    public Collection<Jugador> jugadores() {
        return Collections.unmodifiableCollection(jugadores);
    }

    public Collection<Enfrentamiento> enfrentamientos() {
        return Collections.unmodifiableCollection(enfrentamientos);
    }

    /**
     * Registra un jugador en el equipo.
     * 
     * @param jugador Jugador a registrar.
     */
    public void registrarJugador(Jugador jugador) {
        validarJugadorExiste(jugador);
        jugadores.add(jugador);
    }

    /**
     * Busca un jugador en la lista de jugadores del equipo.
     * 
     * @param jugador Jugador a buscar.
     * @return Un Optional que contiene el jugador si es encontrado, o un Optional vacío si no se encuentra.
     */
    public Optional<Jugador> buscarJugador(Jugador jugador) {
        Predicate<Jugador> nombreIgual = j -> j.getNombre().equals(jugador.getNombre());
        Predicate<Jugador> apellidoIgual = j -> j.getApellido().equals(jugador.getApellido());
        return jugadores.stream().filter(nombreIgual.and(apellidoIgual)).findAny();
    }

    /**
     * Valida que el jugador no esté ya registrado en el equipo.
     * 
     * @param jugador Jugador a validar.
     */
    private void validarJugadorExiste(Jugador jugador) {
        boolean existeJugador = buscarJugador(jugador).isPresent();
        ASSERTION.assertion(!existeJugador, "El jugador ya esta registrado");
    }

    /**
     * Actualiza el estado del enfrentamiento del equipo.
     * 
     * @param isGanado Indica si el equipo ganó el partido.
     * @param isEmpatado Indica si el partido terminó en empate.
     * @param isPerdido Indica si el equipo perdió el partido.
     */
    public void actualizarEstadoEnfrentamiento(boolean isGanado, boolean isEmpatado, boolean isPerdido) {
        if (isGanado) {
            this.isGanado = true;
            this.isEmpatado = false;
            this.isPerdido = false;
        } else if (isEmpatado) {
            this.isEmpatado = true;
            this.isGanado = false;
            this.isPerdido = false;
        } else if (isPerdido) {
            this.isPerdido = true;
            this.isGanado = false;
            this.isEmpatado = false;
        }
    }

    /**
     * Obtiene la lista de enfrentamientos en los que participa el equipo por nombre del equipo.
     * 
     * @param nombre Nombre del equipo.
     * @return Lista de enfrentamientos del equipo.
     */
    public Collection<Enfrentamiento> obtenerListaEnfrentamientosEquipoPorNombre(String nombre) {
        Predicate<Enfrentamiento> condicion1 = enfrentamiento -> enfrentamiento.getVisitante().nombre.equals(nombre);
        Predicate<Enfrentamiento> condicion2 = enfrentamiento -> enfrentamiento.getLocal().nombre.equals(nombre);
        return enfrentamientos.stream().filter(condicion1.or(condicion2)).toList();
    }

}
