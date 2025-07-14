package finalprogramacionii;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author joaco
 */

public interface Persistencia {
    void guardarEnArchivo(List<Vehiculo> vehiculos, String ruta);
    List<Vehiculo> leerDesdeArchivo(String ruta);
    // El Predicate<Vehiculo> nos permite pasar una condición lambda como filtro para la exportación
    void exportarFiltrado(List<Vehiculo> vehiculos, Predicate<Vehiculo> filtro, String ruta);
}
