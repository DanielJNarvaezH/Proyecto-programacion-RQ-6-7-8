package co.edu.uniquindio.poo;


public class Estadistica {
    private int ganado;
    private int perdido;
    private int empatado;
    private int puntaje;
    private final Equipo equipo;

    public Estadistica(Equipo equipo) {
        ganado = 0;
        perdido = 0;
        empatado = 0;
        puntaje = 0;
        this.equipo = equipo;
    }

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

    public Equipo getEquipo() {
        return equipo;
    }

    public void actualizarEstadisticas(boolean isGanado, boolean isEmpatado, boolean isPerdido) {
        if (isGanado) {
            ganado++;
        } else if (isEmpatado) {
            empatado++;
        } else if (isPerdido) {
            perdido++;
        }

        puntaje = ganado * 3 + empatado * 2 + perdido * 1; 
    }

    @Override
    public String toString() {
        return "\nEl puntaje del equipo es: " + puntaje + "." + "\nSus victorias fueron: " + ganado + "." + "\nSus empates fueron: " + empatado + "." + "\nSus derrotas fueron: " + perdido + ".\n";
    }

    

}
