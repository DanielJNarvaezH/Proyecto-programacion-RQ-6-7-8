package co.edu.uniquindio.poo;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

import java.time.LocalDate;
import java.time.LocalTime;

public class Enfrentamiento {

    private LocalDate fecha;
    private LocalTime hora;
    private final String resultadoEnfrentamiento;
    private final Lugar lugar;
    private EstadoEnfrentamiento estadoEnfrentamiento;
    private final Collection<Juez> jueces;
    private final Equipo equipo1;
    private final Equipo equipo2;
    private int puntosEquipo1Enfrentamiento;
    private int puntosEquipo2Enfrentamiento;

    public Enfrentamiento(LocalDate fecha, LocalTime hora, String resultadoEnfrentamiento, Lugar lugar, Equipo equipo1,
            Equipo equipo2) {
        this.fecha = fecha;
        this.hora = hora;
        this.resultadoEnfrentamiento = resultadoEnfrentamiento;
        this.lugar = lugar;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.jueces = new LinkedList<>();

    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }
    

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public void setFechayHora(LocalDate fecha, LocalTime hora) {
        ASSERTION.assertion(fecha.isAfter(fecha));
        this.fecha = fecha;
        this.hora = hora;
        estadoEnfrentamiento = estadoEnfrentamiento.APLAZADO;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public EstadoEnfrentamiento getEstadoEnfrentamiento() {
        return estadoEnfrentamiento;
    }

    public String getResultadoEnfrentamiento() {
        return resultadoEnfrentamiento;
    }

    public Collection<Juez> getJueces() {
        return Collections.unmodifiableCollection(jueces);
    }

    public void determinarEstadoEnfrentamiento() {
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();

        if ((fechaActual.isBefore(fecha) && horaActual.isBefore(hora))) {

            estadoEnfrentamiento = estadoEnfrentamiento.PENDIENTE;

        } else if (fechaActual.equals(fecha) && horaActual.equals(hora)) {
            estadoEnfrentamiento = estadoEnfrentamiento.EN_JUEGO;
        }
    }

    public void setPuntosEquipo1y2Enfrentamiento(int puntosEquipo1Enfrentamiento, int puntosEquipo2Enfrentamiento) {
        this.puntosEquipo1Enfrentamiento = puntosEquipo1Enfrentamiento;
        this.puntosEquipo2Enfrentamiento = puntosEquipo2Enfrentamiento;
    }
    

    public void llevarACaboEnfrentamiento() {
        if (puntosEquipo1Enfrentamiento > puntosEquipo2Enfrentamiento) {
            equipo1.actualizarEstadoEnfrentamiento(true, false, false);
            equipo2.actualizarEstadoEnfrentamiento(false, false, true);
            equipo1.getEstadistica().actualizarEstadisticas(true, false, false);
            equipo2.getEstadistica().actualizarEstadisticas(false, false, true);
        } else if (puntosEquipo1Enfrentamiento < puntosEquipo2Enfrentamiento) {
            equipo1.actualizarEstadoEnfrentamiento(false, false, true);
            equipo2.actualizarEstadoEnfrentamiento(true, false, false);
            equipo1.getEstadistica().actualizarEstadisticas(false, false, true);
            equipo2.getEstadistica().actualizarEstadisticas(true, false, false);
        } else if (puntosEquipo1Enfrentamiento == puntosEquipo2Enfrentamiento) {
            equipo1.actualizarEstadoEnfrentamiento(false, true, false);
            equipo2.actualizarEstadoEnfrentamiento(false, true, false);
            equipo1.getEstadistica().actualizarEstadisticas(false, true, false);
            equipo2.getEstadistica().actualizarEstadisticas(false, true, false);
        }
        estadoEnfrentamiento = estadoEnfrentamiento.FINALIZADO;
    }

}

// Tener en cuenta q no puede haber un mismo arbitro en 2 enfrentamientos
// diferentes q se juegan a la misma hora
// Pensar en una manera de agregar una duracion del partido Sapo
