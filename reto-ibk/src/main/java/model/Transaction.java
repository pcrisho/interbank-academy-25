package model;

public class Transaction {

    private int id;
    private String type;
    private double amount;

    /**
     * Constructor para crear una nueva transacción.
     * @param id Identificador único de la transacción.
     * @param type Tipo de transacción: "Crédito" o "Débito".
     * @param amount Monto de la transacción, debe ser positivo.
     */

    public Transaction(int id, String type, double amount) {
        // Restricción en caso el tipo de transacción sea inválido
        if (!type.equalsIgnoreCase("Crédito") && !type.equalsIgnoreCase("Débito")) {
            throw new IllegalArgumentException("Tipo de transacción inválido: " + type + "!");
        }
        // Restricción en caso el monto sea inválido
        if (amount < 0) {
            throw new IllegalArgumentException("El monto no puede ser negativo");
        }
        this.id = id;
        this.type = type;
        this.amount = amount;
    }

     // Métodos getters
    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}
