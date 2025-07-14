package finalprogramacionii;
import java.util.function.Predicate;
/**
 *
 * @author joaco
 */
public class FinalProgramacionII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("--Iniciando proyecto--");
        
        // Crear persistencia y gestor
        Persistencia persistencia = new PersistenciaArchivo();
        GestionVehiculos sistema = new GestionVehiculos(persistencia);

//        // Crear vehículos
//        Vehiculo auto = new Auto("A1", "Toyota", "Corolla", 2020, "ABC123", 4);
//        Vehiculo moto = new Moto("M1", "Yamaha", "R3", 2021, "XYZ789", 300);
//        Vehiculo barco = new Barco("B1", "Yamaha", "WaveRunner", 2018, "Poseidón", false);
//        //
//        // Agregar al sistema
//        sistema.crear(auto);
//        sistema.crear(moto);
//        sistema.crear(barco);
//
//
//        // Exportar todos los vehículos a un TXT
//        String rutaGeneral = "data/vehiculos_todos.txt";
//        persistencia.guardarEnArchivo(sistema.getVehiculos(), rutaGeneral);
        
        System.out.println(sistema.leerTodos());

        // Exportar solo los que son instancias de Auto a un TXT legible
        Predicate<Vehiculo> filtroAutos = v -> v instanceof Auto;
        String rutaFiltrada = "data/vehiculos_filtrados.txt";
        persistencia.exportarFiltrado(sistema.leerTodos(), filtroAutos, rutaFiltrada);

        System.out.println("Exportaciones e importaciones completas. Revisa los archivos .txt");
    }       
}
