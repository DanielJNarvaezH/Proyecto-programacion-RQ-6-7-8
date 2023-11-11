package co.edu.uniquindio.poo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

public class EnfrentamientoTest {


    private static final Logger LOG = Logger.getLogger(EquipoTest.class.getName());
    

    @Test
    public void llevarACaboEnfrentamiento() {
        LOG.info("Inicio de prueba llevarACaboEnfrentamiento...");
    
        var representante = new Persona("Robinson", "Pulgarin", "rpulgarin@email.com", "6067359300");

        var estadistica = new Estadistica();

        var lugar = new Lugar("granada", "Avenida alamos");

        var visitante = new Equipo("Uniquindio", representante,estadistica);
        var local = new Equipo("Uniquindio", representante,estadistica);

        Enfrentamiento enfrentamiento1 = new Enfrentamiento(LocalDate.of(2023, 11, 8), LocalTime.of(15, 49), lugar, visitante, local);

        enfrentamiento1.setPuntosVisitanteLocalEnfrentamiento(13, 8);
        enfrentamiento1.llevarACaboEnfrentamiento();
        //System.out.println(enfrentamiento1.getResultadoEnfrentamiento());
        //System.out.println(enfrentamiento1.getEstadoEnfrentamiento());

        System.out.println(LocalTime horaActual = LocalTime.now());



        /*assertTrue(torneo.getEquipos().contains(equipo));
        assertEquals(1, torneo.getEquipos().size());
        LOG.info("Fin de prueba llevarACaboEnfrentamiento...");*/
    }
    
}
