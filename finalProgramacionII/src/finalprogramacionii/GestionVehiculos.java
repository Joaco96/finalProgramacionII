
package finalprogramacionii;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author joaco
 */

public class GestionVehiculos implements RepositorioCrud<Vehiculo> {
    private List<Vehiculo> vehiculos;
    private Persistencia persistencia;  // asociación con la interfaz

    public GestionVehiculos(Persistencia persistencia) {
        this.persistencia = persistencia;
        List<Vehiculo> vehiculosIniciales = persistencia.leerDesdeArchivo("data/vehiculos_todos.txt");        
        this.vehiculos = vehiculosIniciales;
    }
    
    @Override
    public void crear(Vehiculo vehiculo) {
        vehiculos.add(vehiculo);
    }

    @Override
    public List<Vehiculo> leerTodos() {
        return new ArrayList<>(vehiculos);
    }

    @Override
    public boolean actualizar(String id, Vehiculo nuevoVehiculo) {
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getId().equals(id)) {
                vehiculos.set(i, nuevoVehiculo);
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean eliminar(String id) {
        return vehiculos.removeIf(v -> v.getId().equals(id));
    }

    @Override
    public List<Vehiculo> buscarPorMarca(String marca) {
        List<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo v : vehiculos) {
            if (v.toString().toLowerCase().contains(marca.toLowerCase())) {
                resultado.add(v);
            }
        }
        return resultado;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
