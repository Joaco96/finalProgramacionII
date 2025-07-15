package finalprogramacionii;

/**
 *
 * @author joaco
 */

public class Moto extends Vehiculo implements Conducible {
    private String patente;
    private int cilindrada;

    public Moto(String id, String marca, String modelo, int anio, String patente, int cilindrada) {
        super(id, marca, modelo, anio);
        this.patente = patente;
        this.cilindrada = cilindrada;
    }

    @Override
    public void encender() {
        System.out.println("La moto esta encendida.");
    }

    @Override
    public void apagar() {
        System.out.println("La moto esta apagada.");
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

    public int getCilindrada() {
        return cilindrada;
    }

    public void setCilindrada(int cilindrada) {
        this.cilindrada = cilindrada;
    }
    
}
