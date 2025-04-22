package reader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Transaction;

/**
 * Clase para leer un archivo CSV y convertirlo en una lista de transacciones.
 */

public class CSVReader {

    /**
     * Método para leer el archivo CSV y retorna una lista de objetos Transaction.
     * @param fileName nombre del archivo (data.csv)
     */
    public static List<Transaction> leerCSV(String fileName) {

        // Creación de lista vacía donde se guardarán las transacciones
        List<Transaction> transactions = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String linea;
            boolean esPrimeraLinea = true;

            while ((linea = br.readLine()) != null) {
                if (esPrimeraLinea) {
                    esPrimeraLinea = false; // omitir encabezado
                    continue;
                }

                // Divide la línea usando la coma como separador, lo que genera un arreglo con los 3 valores esperados: id, tipo y monto.
                String[] fila = linea.split(",");

                if (fila.length != 3) continue; // línea inválida

                try {
                    int id = Integer.parseInt(fila[0].trim());          // en un entero (id)
                    String tipo = fila[1].trim();                       // en un string (tipo)
                    double monto = Double.parseDouble(fila[2].trim());  // en un número decimal (monto)

                    // Crea un objeto Transaction con los datos leídos y lo agrega a la lista.
                    Transaction t = new Transaction(id, tipo, monto);   
                    transactions.add(t);

                } catch (Exception e) {
                    System.err.println("Línea inválida: " + linea + " → " + e.getMessage());
                    // Continúa con la siguiente línea
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return transactions;
    }

}
