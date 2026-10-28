# Ejercicio Práctico: Árboles Binarios de Búsqueda (BST) Aplicados a una Base de Clientes

**Universidad Santiago de Cali — Estructuras de Datos 2026B**  
**Autor:** Felipe Jurado  
**Lenguaje:** Java  

---

## 📁 Estructura del Proyecto

```text
BST_Clientes/
├── .vscode/
│   ├── settings.json       # Configuración de compilación para VS Code
│   └── launch.json         # Configuración de depuración y ejecución
├── src/
│   ├── Cliente.java          # Entidad Cliente (documento, nombre, edad, total compras)
│   ├── Node.java             # Nodo genérico para el BST
│   ├── BinarySearchTree.java # Implementación del BST con búsquedas, inserción y recorridos
│   └── Main.java             # Programa principal con pruebas de requerimientos R1 - R5
├── entregables.txt         # Tabla de la Parte B, análisis de Partes C y D, y reflexión previa
├── README.md               # Este archivo de documentación
└── .gitignore              # Ignora binarios .class y directorio bin/
```

---

## 🚀 Compilación y Ejecución

### Desde Visual Studio Code
1. Abre la carpeta `BST_Clientes` en VS Code:
   ```sh
   code "C:\USC Tareas\Estructura de Datos\BST_Clientes"
   ```
2. Abre `src/Main.java` y presiona **F5** o haz clic en **Run Java**.

### Desde la Terminal (CLI)
```sh
# Compilar todas las clases dentro de src hacia una carpeta bin
javac -d bin src/*.java

# Ejecutar Main
java -cp bin Main
```

---

## 📋 Resumen de Requerimientos Implementados

| Id | Requerimiento | Estructura | Recorrido / Método |
|---|---|---|---|
| **R1** | Listado de todos los clientes de menor a mayor compras | `arbolCompras` | `In-Orden` ascendente (`clientesAscendente`) |
| **R2** | Los 3 clientes con mayor total de compras | `arbolCompras` | `In-Orden Inverso` con detención temprana (`mayoresN(3)`) |
| **R3** | Clientes con edad entre 25 y 35 años (inclusive) | `arbolEdad` | `In-Orden` con poda de ramas (`clientesEnRango(25, 35)`) |
| **R4** | Búsqueda exacta de cliente por total de compras | `arbolCompras` | Búsqueda recursiva en BST (`buscarNodo(990000, root)`) |
| **R5** | Cliente más joven y cliente de mayor edad | `arbolEdad` | Descenso a extremo izquierdo (`minimo`) y derecho (`maximo`) |
| **R6** | Manejo de claves duplicadas (mismas edades) | `arbolEdad` | Claves iguales desviadas a la rama derecha en `insertRecursive` |

---

## 📄 Entregables y Respuestas
Consulta el archivo [`entregables.txt`](./entregables.txt) para ver:
- La **Reflexión previa** sobre los errores del código base.
- La **Tabla de la Parte B** diligenciada con justificaciones y criterios de poda.
- El análisis detallado de **claves duplicadas (Parte C)**.
- El análisis de **forma del árbol y complejidad computacional (Parte D)**.
