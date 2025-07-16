package finalprogramacionii;
import java.io.Serializable;

/**
 *
 * @author joaco
 */

// Implementamos la interfaz Serializable para decirle al compilador que esto se puede convertir en bytes y guardar en un archivo.
public abstract class Vehiculo implements Serializable {
    // Usamos protected para que las subclases puedan acceder a esos atributos
    protected String id;
    protected String marca;
    protected String modelo;
    protected int anio;

    public Vehiculo(String id, String marca, String modelo, int anio) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    public abstract void encender();

    public abstract void apagar();

    @Override
    public String toString() {
        return "ID: " + id + " - " + marca + " " + modelo + " (" + anio + ")";
    }

    public String getId() {
        return id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }
    
}
