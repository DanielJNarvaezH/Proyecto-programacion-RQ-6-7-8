/**
 * Clase que representa las estadísticas de un equipo en un torneo
 * @author Área de programación UQ - Daniel Narvaez, Diego Flores, Esteban Maya
 * @since 2023-09
 * 
 * Licencia GNU/GPL V3.0 (https://raw.githubusercontent.com/grid-uq/poo/main/LICENSE) 
 */
package co.edu.uniquindio.poo;

//import static co.edu.uniquindio.poo.util.AssertionUtil.ASSERTION;

public class Estadistica {
    private int ganado;
    private int perdido;
    private int empatado;
    private int puntaje;
    //private final String nombre;

    public Estadistica() {

       // ASSERTION.assertion(nombre != null && !nombre.isBlank(), "El nombre es requerido");
        ganado = 0;
        perdido = 0;
        empatado = 0;
        puntaje = 0;
        //this.nombre = nombre;

    }

   /* public String getNombre() {
        return nombre;
    }*/

    public int getGanado() {
        return ganado;
    }

    public void setGanado(int ganado) {
        this.ganado = ganado;
    }

    public int getPerdido() {
        return perdido;
    }

    public void setPerdido(int perdido) {
        this.perdido = perdido;
    }

    public int getEmpatado() {
        return empatado;
    }

    public void setEmpatado(int empatado) {
        this.empatado = empatado;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public void setPuntaje(int puntaje) {
        this.puntaje = puntaje;
    }

    /**
     * Actualiza las estadísticas del equipo después de un partido.
     * 
     * @param isGanado Indica si el equipo ganó el partido.
     * @param isEmpatado Indica si el partido terminó en empate.
     * @param isPerdido Indica si el equipo perdió el partido.
     */
    public void actualizarEstadisticas(boolean isGanado, boolean isEmpatado, boolean isPerdido) {
        if (isGanado) {
            ganado++;
        } else if (isEmpatado) {
            empatado++;
        } else if (isPerdido) {
            perdido++;
        }

        puntaje = ganado * 3 + empatado * 2 + perdido;
    }

    /**
     * Devuelve una representación en cadena de la estadística.
     * 
     * @return Cadena que representa la estadística.
     */
    @Override
    public String toString() {
        return "\nEl puntaje del equipo es: " + puntaje + "." + "\nSus victorias fueron: " + ganado + "."
                + "\nSus empates fueron: " + empatado + "." + "\nSus derrotas fueron: " + perdido + ".\n";
    }

}
