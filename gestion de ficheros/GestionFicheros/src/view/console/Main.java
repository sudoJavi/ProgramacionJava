/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.console;

import model.funciones;
import java.util.Scanner;
import java.io.IOException;
/**
 *
 * @author javiervilgal
 */

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static funciones funciones = new funciones();

    public static void main(String[] args) {
        boolean salir = false;
        
        while (!salir) {
            mostrarMenu();
            int opcion = obtenerOpcion();
            
            try {
                switch (opcion) {
                    case 1:
                        crearCarpeta();
                        break;
                    case 2:
                        crearArchivo();
                        break;
                    case 3:
                        listarArchivos();
                        break;
                    case 4:
                        mostrarContenidoArchivo();
                        break;
                    case 5:
                        sobrescribirArchivo();
                        break;
                    case 6:
                        eliminarArchivo();
                        break;
                    case 7:
                        contarCaracteres();
                        break;
                    case 8:
                        contarPalabras();
                        break;
                    case 9:
                        reemplazarPalabras();
                        break;
                    case 10:
                        System.out.println("Función de PDF desactivada en esta versión");
                        break;
                    case 0:
                        salir = true;
                        System.out.println("Saliendo del programa...");
                        break;
                    default:
                        System.out.println("Opción no válida. Intente nuevamente.");
                }
            } catch (IOException e) {
                System.out.println("Error de E/S: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
            }
            
            if (!salir) {
                System.out.println("\nPresione Enter para continuar...");
                scanner.nextLine();
            }
        }
        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== MENÚ GESTIÓN DE ARCHIVOS ===");
        System.out.println("1. Crear carpeta");
        System.out.println("2. Crear archivo");
        System.out.println("3. Listar archivos en directorio");
        System.out.println("4. Mostrar contenido de archivo");
        System.out.println("5. Sobrescribir archivo");
        System.out.println("6. Eliminar archivo");
        System.out.println("7. Contar caracteres en archivo");
        System.out.println("8. Contar palabras en archivo");
        System.out.println("9. Reemplazar palabras en archivo");
        System.out.println("10. Crear PDF (no disponible)");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int obtenerOpcion() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("Entrada no válida. Ingrese un número: ");
            }
        }
    }

    private static void crearCarpeta() {
        System.out.print("Ingrese el nombre de la carpeta: ");
        String nombreCarpeta = scanner.nextLine();
        funciones.createFolder(nombreCarpeta);
        System.out.println("Carpeta '" + nombreCarpeta + "' creada/verificada.");
    }

    private static void crearArchivo() throws IOException {
        System.out.print("Ingrese la ruta donde crear el archivo: ");
        String ruta = scanner.nextLine();
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = scanner.nextLine();
        System.out.print("Ingrese el contenido del archivo: ");
        String contenido = scanner.nextLine();
        
        funciones.createFile(ruta, nombreArchivo, contenido);
        System.out.println("Archivo creado exitosamente.");
    }

    private static void listarArchivos() {
        System.out.print("Ingrese la ruta a listar: ");
        String ruta = scanner.nextLine();
        
        String[] archivos = funciones.showListFiles(ruta);
        if (archivos.length == 0) {
            System.out.println("No se encontraron archivos en la ruta especificada.");
        } else {
            System.out.println("Archivos encontrados:");
            for (String archivo : archivos) {
                System.out.println("- " + archivo);
            }
        }
    }

    private static void mostrarContenidoArchivo() throws IOException {
        System.out.print("Ingrese la ruta del archivo: ");
        String ruta = scanner.nextLine();
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = scanner.nextLine();
        
        String contenido = funciones.showFile(ruta, nombreArchivo);
        System.out.println("\nContenido del archivo:");
        System.out.println(contenido);
    }

    private static void sobrescribirArchivo() throws IOException {
        System.out.print("Ingrese la ruta del archivo: ");
        String ruta = scanner.nextLine();
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = scanner.nextLine();
        System.out.print("Ingrese el nuevo contenido: ");
        String nuevoContenido = scanner.nextLine();
        
        boolean exito = funciones.overWriteFile(ruta, nombreArchivo, nuevoContenido);
        if (exito) {
            System.out.println("Archivo sobrescrito exitosamente.");
        } else {
            System.out.println("El archivo no existe y no pudo ser sobrescrito.");
        }
    }

    private static void eliminarArchivo() {
        System.out.print("Ingrese la ruta del archivo: ");
        String ruta = scanner.nextLine();
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = scanner.nextLine();
        
        funciones.deleteFile(ruta, nombreArchivo);
        System.out.println("Archivo eliminado (si existía).");
    }

    private static void contarCaracteres() throws IOException {
        System.out.print("Ingrese la ruta del archivo: ");
        String ruta = scanner.nextLine();
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = scanner.nextLine();
        
        int cantidad = funciones.countChars(ruta, nombreArchivo);
        System.out.println("El archivo contiene " + cantidad + " caracteres.");
    }

    private static void contarPalabras() throws IOException {
        System.out.print("Ingrese la ruta del archivo: ");
        String ruta = scanner.nextLine();
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = scanner.nextLine();
        
        int cantidad = funciones.countWords(ruta, nombreArchivo);
        System.out.println("El archivo contiene " + cantidad + " palabras.");
    }

    private static void reemplazarPalabras() throws IOException {
        System.out.print("Ingrese la ruta del archivo: ");
        String ruta = scanner.nextLine();
        System.out.print("Ingrese el nombre del archivo: ");
        String nombreArchivo = scanner.nextLine();
        System.out.print("Ingrese la palabra a reemplazar: ");
        String palabraVieja = scanner.nextLine();
        System.out.print("Ingrese la nueva palabra: ");
        String palabraNueva = scanner.nextLine();
        
        String nuevoContenido = funciones.swapWords(ruta, nombreArchivo, palabraVieja, palabraNueva);
        System.out.println("\nContenido actualizado:");
        System.out.println(nuevoContenido);
    }
}