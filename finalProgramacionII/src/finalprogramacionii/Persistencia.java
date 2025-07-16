package finalprogramacionii;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author joaco
 */

public interface Persistencia<T> {
    // Metodos de Persistencia de los datos
    void guardarEnArchivo(List<T> objetos, String ruta);
    List<Vehiculo> leerDesdeArchivo(String ruta);
    // El Predicate permite pasar un test como filtro para la exportación
    void exportarFiltrado(List<T> objetos, Predicate<T> filtro, String ruta);
}
