package finalprogramacionii;
import java.util.function.Predicate;
/**
 *
 * @author joaco
 */
public class FinalProgramacionII {
    
    public static void main(String[] args) {
        System.out.println("-- Iniciando proyecto final Programacion II --");
        System.out.println("-------------");
        
        // Crear persistencia y gestor
        Persistencia persistencia = new PersistenciaArchivo();
        GestionVehiculos sistema = new GestionVehiculos(persistencia);

        System.out.println("-------------");
        // Crear vehículos
//      Vehiculo auto = new Auto("A1", "Toyota", "Corolla", 2020, "ABC123", 4);
        Vehiculo moto = new Moto("M1", "Yamaha", "R3", 2021, "XYZ789", 300);
//      Vehiculo barco = new Barco("B1", "Yamaha", "WaveRunner", 2018, "Poseidón", false);

        System.out.println("-- Crear vehiculo --");
        // Agregar al sistema
//      sistema.crear(auto);
        sistema.crear(moto);
//      sistema.crear(barco);
        System.out.println("-------------");

        System.out.println("-- Todos los vehiculos --");
        System.out.println(sistema.leerTodos());
        System.out.println("-------------");
        
        // Realizar la busqueda por marca de vehiculo
        System.out.println("-- Buscar vehiculos por marca TOYOTA --");
        System.out.println(sistema.buscarPorMarca("Toyota"));
        System.out.println("-------------");
        
        // Actualiza un vehiculo
        System.out.println("-- Actualizar vehiculo --");
        Vehiculo nuevoVehiculo = new Auto("A4", "Toyota", "Etios", 2024, "XYZ787", 4);        
        sistema.actualizar(nuevoVehiculo);
        System.out.println(sistema.leerTodos());
        System.out.println("-------------");
        
        // Elimina un vehiculo si encuentra el id
        System.out.println("-- Eliminar vehiculo --");
        sistema.eliminar("A2");
        System.out.println(sistema.leerTodos());
        System.out.println("-------------");
        
        System.out.println("-- Exportaciones --");        
        // Exportar todos los vehículos a un txt
        String rutaGeneral = "data/vehiculos_todos.txt";
        sistema.guardarTodo(rutaGeneral);
        
        // Exportar solo los que son instancias de AUTO por ejemplo a un txt filtrando con el test del Predicate
        Predicate<Vehiculo> filtroAutos = v -> v instanceof Auto;
        String rutaFiltrada = "data/vehiculos_filtrados.txt";
        sistema.exportarFiltrado(filtroAutos, rutaFiltrada);

        System.out.println("-------------");
        System.out.println("-- Finalizando proyecto --");
    }       
}
