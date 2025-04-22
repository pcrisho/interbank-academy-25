# 🏦 Reto IBK: Procesador de Transacciones en Java

Este proyecto Java permite leer un archivo CSV con transacciones bancarias, contar cuántas son de tipo **Crédito** y **Débito**, y generar un pequeño reporte por consola.

---

## 📁 Estructura del proyecto

```
reto-ibk/
├── src/
│   └── main/
│       ├── java/
│       │   ├── com/
│       │   │   └── mycompany/
│       │   │          ├── Main.java
│       │   ├── model/
│       │   │   └── Transaction.java
│       │   ├── reader/
│       │   │   └── CSVReader.java
│       │   └─── service/
│       │       └── TransactionService.java
│       └── resources/
│           └── data.csv
├── README.md
└── pom.xml
```

---

## 🧠 ¿Qué hace el programa?

1. Lee el archivo `data.csv` desde `src/main/resources/`.
2. Procesa las transacciones con los campos:
   - `id`: identificador numérico
   - `tipo`: `"Crédito"` o `"Débito"`
   - `monto`: cantidad en formato decimal
3. Cuenta cuántas transacciones hay de cada tipo.
4. Muestra los resultados por consola.

---

## 💻 Ejemplo de uso

Archivo `data.csv`:

```
id,tipo,monto
1,Crédito,500.00
2,Débito,200.00
3,Crédito,300.00
```

Salida esperada en consola:

```
Reporte de Transacciones
---------------------------------------------
Balance Final: 600
Transacción de Mayor Monto: ID 3 - 300.00
Conteo de Transacciones: Crédito: 2 Débito: 1
```

---

## ⚙️ Tecnologías utilizadas

- Java 11+
- Maven
- VS Code (u otro IDE)

---

## 🚀 Cómo ejecutar el proyecto

1. Clona el repositorio:

```bash
git clone https://github.com/pcrisho/interbank-academy-25.git

cd interbank-academy-25
```

2. Compila el proyecto:

```bash
mvn clean compile
```

3. Ejecuta el proyecto:

```bash
mvn exec:java -Dexec.mainClass="com.mycompany.Main"
```

> Asegúrate de que el archivo `data.csv` exista.

---

## 📌 Notas adicionales

- El código omite líneas inválidas del CSV y muestra errores por consola.
- Se puede adaptar fácilmente para procesar otros tipos de datos financieros.

---

##  Puntos por mejorar

- Pueden aplicarse validaciones más estrictas
- Se puede adaptar fácilmente para procesar otros tipos de datos financieros.

---

## ✍️ Autor

Proyecto desarrollado como parte del programa **INTERBANK ACADEMY 2025**.
