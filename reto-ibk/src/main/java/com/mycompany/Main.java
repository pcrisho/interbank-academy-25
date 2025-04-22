package com.mycompany;

import model.Transaction;
import service.TransactionService;
import reader.CSVReader;

import java.util.List;

/**
 * Clase principal del programa: ejecuta el flujo de carga y reporte.
 */
public class Main {
    public static void main(String[] args) {
        String nombreArchivo = "data.csv";

        // Leer transacciones desde el archivo CSV
        List<Transaction> transacciones = CSVReader.leerCSV(nombreArchivo);

        if (transacciones.isEmpty()) {
            System.out.println("No se encontraron transacciones válidas.");
            return;
        }

        // Procesar con TransactionService
        TransactionService servicio = new TransactionService(transacciones);

        double balance = servicio.calcularBalanceFinal();
        Transaction mayor = servicio.obtenerTransaccionMayorMonto();
        int[] conteo = servicio.contarTransaccionesTipo();

        // Mostrar reporte
        System.out.println("Reporte de Transacciones");
        System.out.println("---------------------------------------------");
        System.out.printf("Balance Final: %.2f\n", balance);
        System.out.printf("Transacción de Mayor Monto: ID %d - %.2f\n", mayor.getId(), mayor.getMonto());
        System.out.printf("Conteo de Transacciones: Crédito: %d Débito: %d\n", conteo[0], conteo[1]);
    }
}