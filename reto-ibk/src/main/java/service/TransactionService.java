package service;
import model.Transaction;
import java.util.List;

/**
 * Clase para la lógica del negocio.
 */

public class TransactionService {

    /**
     * @param transactions lista con los datos de transacción: id, tipo, monto.
     */

    private List<Transaction> transactions;

    /**
     * Constructor para recibir como parámetro una lista de objetos @param transactions .
     */

    public TransactionService(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    /**
     * Método para calcular el balance final: suma de Créditos - suma de Débitos.
     */

     public double calcularBalanceFinal() {
        // Variables de conteo de montos
        double credito = 0.0;
        double debito = 0.0;

        for (Transaction t : transactions) {
            if (t.getTipo().equalsIgnoreCase("Crédito")) {
                credito += t.getMonto();
            } else if (t.getTipo().equalsIgnoreCase("Débito")) {
                debito += t.getMonto();
            }
        }

        return credito - debito;
    }

    /**
     * Método para retornar la transacción con el monto más alto.
     */

     public Transaction obtenerTransaccionMayorMonto() {
        // Variable que guardará la transacción más alta
        Transaction mayor = null;

        for (Transaction t : transactions) {
            if (mayor == null || t.getMonto() > mayor.getMonto()) {
                mayor = t;
            }
        }

        return mayor;
    }

    /**
     * Método para contar la cantidad total de transacciones por tipo.
     * @return Arreglo con [créditos, débitos]
     */
    public int[] contarTransaccionesTipo() {
        // Variables que guardarán el conteo de transacciones por tipo
        int credito = 0;
        int debito = 0;

        for (Transaction t : transactions) {
            if (t.getTipo().equalsIgnoreCase("Crédito")) {
                credito++;
            } else if (t.getTipo().equalsIgnoreCase("Débito")) {
                debito++;
            }
        }

        // Se retorna un arreglo con los contadores
        return new int[]{credito, debito};
    }

}
