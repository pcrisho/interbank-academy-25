package model;

/**
 * Clase para representar una transacción bancaria con id, tipo y monto.
 */

public class Transaction {

    private int id;
    private String tipo;
    private double monto;

    /**
     * Constructor para crear una nueva transacción.
     * @param id Identificador único de la transacción.
     * @param tipo Tipo de transacción: "Crédito" o "Débito".
     * @param monto Monto de la transacción, debe ser positivo.
     */

    public Transaction(int id, String tipo, double amount) {
        // Restricción en caso el tipo de transacción sea inválido
        if (!tipo.equalsIgnoreCase("Crédito") && !tipo.equalsIgnoreCase("Débito")) {
            throw new IllegalArgumentException("Tipo de transacción inválido: " + tipo + "!");
        }
        // Restricción en caso el monto sea inválido
        if (amount < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        }
        this.id = id;
        this.tipo = tipo;
        this.monto = amount;
    }

     // Métodos getters
    public int getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }

    public double getMonto() {
        return monto;
    }
}
