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
    public void crear(Vehiculo nuevoVehiculo) {
        boolean idExiste = false;
        // Verifica si el ID nuevo ya existe
        for (Vehiculo v : vehiculos) {
            if (v.getId().equals(nuevoVehiculo.getId())) {
                System.out.println("Ya existe un vehiculo con ID: " + nuevoVehiculo.getId());
                idExiste = true;
            }
        }
        // Si no encontro ninguna coincidencia de ID se crea el nuevo vehiculo
        if(!idExiste){
            vehiculos.add(nuevoVehiculo);
        }
    }

    @Override
    public List<Vehiculo> leerTodos() {
        return new ArrayList<>(vehiculos);
    }

    @Override
    public boolean actualizar(String id, Vehiculo nuevoVehiculo) {
        // Verifica si el ID nuevo ya existe en otro objeto antes de actualizar por si existe en un lugar posterior al de la actualizacion
        for (Vehiculo v : vehiculos) {
            if (v.getId().equals(nuevoVehiculo.getId()) && !v.getId().equals(id)) {
                System.out.println("Ya existe un vehiculo con ID: " + nuevoVehiculo.getId());
                return false;
            }
        }
        // Reemplaza si se encuentra el ID original
        for (int i = 0; i < vehiculos.size(); i++) {
            if (vehiculos.get(i).getId().equals(id)) {
                vehiculos.set(i, nuevoVehiculo);
                System.out.println("Vehiculo actualizado exitosamente");
                return true;
            }
        }
        // Si llega hasta este punto quiere decir que no se encontro el ID
        System.out.println("No se encontro el Id del vehiculo");
        return false;
    }

    @Override
    public boolean eliminar(String id) {
        // Elimina todos los vehiculos que cumplen con la condicion de ID
        boolean eliminado = vehiculos.removeIf(v -> v.getId().equals(id));
        // El metodo devuelve un booleano de exito, si no encontro ID 
        if(eliminado){
            System.out.println("Vehiculo eliminado con ID: " + id);
        } else {
            System.out.println("No se pudo eliminar el vehiculo");
        }
        return eliminado;
    }

    @Override
    public List<Vehiculo> buscarPorMarca(String marca) {
        List<Vehiculo> resultado = new ArrayList<>();
        // Buscamos la coincidencia de marca en la lista de vehiculos y lo agregamos a nuestra nueva lista resultado
        for (Vehiculo v : vehiculos) {
            if (v.toString().toLowerCase().contains(marca.toLowerCase())) {
                resultado.add(v);
            }
        }
        // Retornamos el resultado aunque no haya coincidencia, en ese caso sera una lista vacia
        return resultado;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
