package finalprogramacionii;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 *
 * @author joaco
 */

public class PersistenciaArchivo implements Persistencia {
    @Override
    public void guardarEnArchivo(List<Vehiculo> vehiculos, String ruta) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ruta))) {
            for (Vehiculo v : vehiculos) {
                String linea = "";
                if (v instanceof Auto a) {
                    linea = String.format("Auto;%s;%s;%s;%d;%s;%d",
                            a.getId(), a.marca, a.modelo, a.anio, a.getPatente(), a.getCantidadPuertas());
                } else if (v instanceof Moto m) {
                    linea = String.format("Moto;%s;%s;%s;%d;%s;%d",
                            m.getId(), m.marca, m.modelo, m.anio, m.getPatente(), m.getCilindrada());
                } else if (v instanceof Barco b) {
                    linea = String.format("Barco;%s;%s;%s;%d;%s;%b",
                            b.getId(), b.marca, b.modelo, b.anio, b.getNombre(), b.isEsDeCarga());
                }
                writer.println(linea);
            }

            System.out.println("Vehiculos guardados en archivo TXT.");
        } catch (IOException e) {
            System.out.println("Error al guardar archivo TXT: " + e.getMessage());
        }
    }

    @Override
    public List<Vehiculo> leerDesdeArchivo(String ruta) {
        List<Vehiculo> lista = new ArrayList<>();     
        try (BufferedReader reader = new BufferedReader(new FileReader(ruta))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split(";");
                String tipo = partes[0];
                String id = partes[1];
                String marca = partes[2];
                String modelo = partes[3];
                int anio = Integer.parseInt(partes[4]);

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
                        System.out.println("Tipo desconocido: " + tipo);
                }
            }

            System.out.println("Vehiculos cargados desde TXT.");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error al leer archivo TXT: " + e.getMessage());
        }
        return lista;
    }

    @Override
    public void exportarFiltrado(List<Vehiculo> vehiculos, Predicate<Vehiculo> filtro, String ruta) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(ruta))) {
            writer.println("Listado filtrado de vehículos:");
            writer.println("--------------------------------");

            vehiculos.stream()
                     .filter(filtro)
                     .forEach(v -> writer.println(v.toString()));

            System.out.println("Exportacion filtrada completada.");
        } catch (IOException e) {
            System.out.println("Error al exportar archivo: " + e.getMessage());
        }
    }
}
