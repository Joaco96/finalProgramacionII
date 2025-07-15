package finalprogramacionii;

/**
 *
 * @author joaco
 */

public class Auto extends Vehiculo implements Conducible {
    private String patente;
    private int cantidadPuertas;

    public Auto(String id, String marca, String modelo, int anio, String patente, int cantidadPuertas) {
        super(id, marca, modelo, anio);
        this.patente = patente;
        this.cantidadPuertas = cantidadPuertas;
    }

    @Override
    public void encender() {
        System.out.println("El auto esta encendido.");
    }

    @Override
    public void apagar() {
        System.out.println("El auto esta apagado.");
    }

    @Override
    public boolean esConducible() {
        return true;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public int getCantidadPuertas() {
        return cantidadPuertas;
    }

    public void setCantidadPuertas(int cantidadPuertas) {
        this.cantidadPuertas = cantidadPuertas;
    }
    
}
