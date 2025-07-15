package finalprogramacionii;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author joaco
 */

public interface Persistencia {
    // Metodos de Persistencia de los datos
    void guardarEnArchivo(List<Vehiculo> vehiculos, String ruta);
    List<Vehiculo> leerDesdeArchivo(String ruta);
    // El Predicate permite pasar un test como filtro para la exportación
    void exportarFiltrado(List<Vehiculo> vehiculos, Predicate<Vehiculo> filtro, String ruta);
}
