package finalprogramacionii;

/**
 *
 * @author joaco
 */

public class Barco extends Vehiculo implements Conducible {
    private String nombre;
    private boolean esDeCarga;

    public Barco(String id, String marca, String modelo, int anio, String nombre, boolean esDeCarga) {
        super(id, marca, modelo, anio);
        this.nombre = nombre;
        this.esDeCarga = esDeCarga;
    }

    @Override
    public void encender() {
        System.out.println("El barco esta encendido.");
    }

    @Override
    public void apagar() {
        System.out.println("El barco esta apagado.");
    }

    @Override
    public boolean esConducible() {
        return false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isEsDeCarga() {
        return esDeCarga;
    }

    public void setEsDeCarga(boolean esDeCarga) {
        this.esDeCarga = esDeCarga;
    }
    
    
}
