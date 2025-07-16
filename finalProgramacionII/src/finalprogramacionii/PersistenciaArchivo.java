package finalprogramacionii;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author joaco
 */

public class PersistenciaArchivo implements Persistencia<Vehiculo> {
    @Override
    public void guardarEnArchivo(List<Vehiculo> vehiculos, String ruta) {
        // Intentamos abrir un PrintWriter con FileWriter para escribir en el archivo de texto
        try (PrintWriter writer = new PrintWriter(new FileWriter(ruta))) {
            // Recorremos la lista de vehículos
            for (Vehiculo v : vehiculos) {
                String linea = "";
                // Si el vehículo es un Auto, lo formateamos con sus atributos
                if (v instanceof Auto a) {
                    linea = String.format("Auto;%s;%s;%s;%d;%s;%d",
                            a.getId(), a.marca, a.modelo, a.anio, a.getPatente(), a.getCantidadPuertas());
                  // Si es una Moto, formateamos con sus atributos
                } else if (v instanceof Moto m) {
                    linea = String.format("Moto;%s;%s;%s;%d;%s;%d",
                            m.getId(), m.marca, m.modelo, m.anio, m.getPatente(), m.getCilindrada());
                  // Si es un Barco, lo guardamos con su nombre y si es de carga
                } else if (v instanceof Barco b) {
                    linea = String.format("Barco;%s;%s;%s;%d;%s;%b",
                            b.getId(), b.marca, b.modelo, b.anio, b.getNombre(), b.isEsDeCarga());
                }
                // Escribimos la línea generada en el archivo
                writer.println(linea);
            }

            System.out.println("Vehiculos guardados en archivo txt");
        } catch (IOException e) {
            System.out.println("Error al guardar archivo txt: " + e.getMessage());
        }
    }

    @Override
    public List<Vehiculo> leerDesdeArchivo(String ruta) {
        // Creamos una lista vacía para guardar los vehículos leídos
        List<Vehiculo> lista = new ArrayList<>();   
        // Usamos BufferedReader para leer el archivo línea por línea
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            // Leemos el archivo mientras haya líneas disponibles
            while ((linea = reader.readLine()) != null) {
                // Dividimos la línea por ";" para separar los campos
                String[] partes = linea.split(";");
                // Obtenemos los campos comunes a todos los vehículos
                String tipo = partes[0];
                String id = partes[1];
                String marca = partes[2];
                String modelo = partes[3];
                int anio = Integer.parseInt(partes[4]);
                // Determinamos el tipo de vehículo y creamos el objeto correspondiente
                switch (tipo.toLowerCase()) {
                    case "auto":
                        String patenteA = partes[5];
                        int puertas = Integer.parseInt(partes[6]);
                        lista.add(new Auto(id, marca, modelo, anio, patenteA, puertas));
                        break;
                    case "moto":
                        String patenteM = partes[5];
                        int cilindrada = Integer.parseInt(partes[6]);
                        lista.add(new Moto(id, marca, modelo, anio, patenteM, cilindrada));
                        break;
                    case "barco":
                        String nombre = partes[5];
                        boolean esDeCarga = Boolean.parseBoolean(partes[6]);
                        lista.add(new Barco(id, marca, modelo, anio, nombre, esDeCarga));
                        break;
                    default:
                        // Si el tipo no se reconoce, lo informamos
                        System.out.println("Tipo desconocido: " + tipo);
                }
            }

            System.out.println("Vehiculos cargados desde txt");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer archivo txt: " + e.getMessage());
        }
        // Devolvemos la lista de vehículos construida
        return lista;
    }

    @Override
    public void exportarFiltrado(List<Vehiculo> vehiculos, Predicate<Vehiculo> filtro, String ruta) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ruta))) {
            // Encabezado del archivo
            writer.println("Listado filtrado de vehículos:");
            writer.println("--------------------------------");
            // Convertimos la lista de vehículos a un stream para aplicar operaciones funcionales
            vehiculos.stream()
                     // Aplicamos un filtro para seleccionar solo los vehículos que cumplan cierta condición
                     .filter(filtro)
                     // Por cada vehículo que pasó el filtro, lo imprimimos en el archivo de texto con writer
                     .forEach(v -> writer.println(v.toString()));

            System.out.println("Exportacion filtrada completada");
        } catch (IOException e) {
            System.out.println("Error al exportar archivo: " + e.getMessage());
        }
    }
}
