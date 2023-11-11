/**
 * Clase que representa un Enfrentamiento entre dos equipos en un Torneo
 * @author Área de programación UQ
 * @since 2023-09
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
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
    private String resultadoEnfrentamiento;
    private Lugar lugar;
    private EstadoEnfrentamiento estadoEnfrentamiento;
    private final Collection<Juez> jueces;
    private final Equipo visitante;
    private final Equipo local;
    private int puntosVisitanteEnfrentamiento;
    private int puntosLocalEnfrentamiento;

    public Enfrentamiento(LocalDate fecha, LocalTime hora, Lugar lugar, Equipo visitante,
            Equipo local) {
        this.fecha = fecha;
        this.hora = hora;
        this.lugar = lugar;
        this.visitante = visitante;
        this.local = local;
        this.jueces = new LinkedList<>();


    }

    public LocalDate getFecha() {
        return fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public Equipo getVisitante() {
        return visitante;
    }

    public Equipo getLocal() {
        return local;
    }

    public void setFechaHora(LocalDate fecha, LocalTime hora) {
        LocalDate fechaActual = LocalDate.now();
        ASSERTION.assertion(fecha.isAfter(fechaActual));
        this.fecha = fecha;
        this.hora = hora;
        
    }

    public void aplazarEnfrentamiento(LocalDate fecha, LocalTime hora) {
        ASSERTION.assertion(fecha.isAfter(this.fecha));
        this.fecha = fecha;
        this.hora = hora;
        estadoEnfrentamiento = EstadoEnfrentamiento.APLAZADO;
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

    /**
     * Determina el estado actual del enfrentamiento basado en la fecha y hora actual.
     *
    public void determinarEstadoEnfrentamiento() {
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();

        if ((fechaActual.isBefore(fecha) && horaActual.isBefore(hora))) {
            estadoEnfrentamiento = EstadoEnfrentamiento.PENDIENTE;

        } else if (fechaActual.equals(fecha) && horaActual.equals(hora)) {
            estadoEnfrentamiento = EstadoEnfrentamiento.EN_JUEGO;
        }
    }/

    /**
     * Establece los puntos obtenidos por cada equipo en el enfrentamiento.
     * 
     * @param puntosEquipo1Enfrentamiento Puntos obtenidos por el primer equipo.
     * @param puntosEquipo2Enfrentamiento Puntos obtenidos por el segundo equipo.
     */
    public void setPuntosVisitanteLocalEnfrentamiento(int puntosVisitanteEnfrentamiento, int puntosLocalEnfrentamiento) {
        this.puntosVisitanteEnfrentamiento = puntosVisitanteEnfrentamiento;
        this.puntosLocalEnfrentamiento = puntosLocalEnfrentamiento;
    }

    /**
     * Lleva a cabo el enfrentamiento actualizando el estado de los equipos y su estadística.
     */
    public void llevarACaboEnfrentamiento() {
        
        LocalDate fechaActual = LocalDate.now();
        LocalTime horaActual = LocalTime.now();
        //esta en la fecha de ´programación 
        //2 iniciarlo
        //finalizarlo
        //asignar puntos
        //determinar ganador y perdedor ó empatado
        //reportar estadisticas

        if(fechaActual.equals(fecha) && horaActual.equals(hora)){

            estadoEnfrentamiento = EstadoEnfrentamiento.EN_JUEGO;
            resultadoEnfrentamiento = "El resultado es: "; 
            estadoEnfrentamiento = EstadoEnfrentamiento.FINALIZADO;
            if (puntosVisitanteEnfrentamiento > puntosLocalEnfrentamiento) {
                visitante.actualizarEstadoEnfrentamiento(true, false, false);
                local.actualizarEstadoEnfrentamiento(false, false, true);
                visitante.getEstadistica().actualizarEstadisticas(true, false, false);
                local.getEstadistica().actualizarEstadisticas(false, false, true);
                resultadoEnfrentamiento += "El equipo 1 ganó con " + puntosVisitanteEnfrentamiento + " puntos y el equipo 2 perdió con "+ puntosLocalEnfrentamiento + " puntos";
               
            } else if (puntosVisitanteEnfrentamiento < puntosLocalEnfrentamiento) {
                visitante.actualizarEstadoEnfrentamiento(false, false, true);
                local.actualizarEstadoEnfrentamiento(true, false, false);
                visitante.getEstadistica().actualizarEstadisticas(false, false, true);
                local.getEstadistica().actualizarEstadisticas(true, false, false);
                resultadoEnfrentamiento += "El equipo 1 perdió con " + puntosVisitanteEnfrentamiento + " puntos y el equipo 2 perdió con "+ puntosLocalEnfrentamiento + " puntos";
            
            } else if (puntosVisitanteEnfrentamiento == puntosLocalEnfrentamiento) {
                visitante.actualizarEstadoEnfrentamiento(false, true, false);
                local.actualizarEstadoEnfrentamiento(false, true, false);
                visitante.getEstadistica().actualizarEstadisticas(false, true, false);
                local.getEstadistica().actualizarEstadisticas(false, true, false);
                resultadoEnfrentamiento += "El equipo 1 ganó con " + puntosVisitanteEnfrentamiento + " puntos y el equipo 2 perdió con "+ puntosLocalEnfrentamiento + " puntos";
               
            } 
        }else{
                estadoEnfrentamiento = EstadoEnfrentamiento.PENDIENTE;
        }   
        
    }
}

// Tener en cuenta q no puede haber un mismo arbitro en 2 enfrentamientos
// diferentes q se juegan a la misma hora
// Pensar en una manera de agregar una duracion del partido 
