package finalprogramacionii;
import java.util.List;

/**
 *
 * @author joaco
 */
public interface RepositorioCrud<T> {
    void crear(T objeto);
    List<T> leerTodos();
    boolean actualizar(String id, T nuevoObjeto);
    boolean eliminar(String id);
    List<T> buscarPorMarca(String marca);
}
