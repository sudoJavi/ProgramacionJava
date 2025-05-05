/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author javiervilgal
 */
public class funciones {

    /**
     * Crea una carpeta con el nombre especificado
     *
     * @param folderName Nombre de la carpeta a crear
     */
    public void createFolder(String folderName) {
        File folder = new File(folderName);
        if (!folder.exists()) {
            folder.mkdirs();
        }
    }

    /**
     * Crea un archivo con el contenido especificado en la ruta indicada
     *
     * @param path Ruta donde se creará el archivo
     * @param fileName Nombre del archivo
     * @param content Contenido a escribir en el archivo
     */
    public void createFile(String path, String fileName, String content) {
        try {
            File file = new File(path + "\\" + fileName);
            file.getParentFile().mkdirs();
            FileWriter fw = new FileWriter(file, true);
            fw.write(content);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Muestra la lista de archivos en un directorio
     *
     * @param path Ruta del directorio a listar
     * @return Array de Strings con los nombres de los archivos
     */
    public String[] showListFiles(String path) {
        File folder = new File(path);
        if (folder.exists() && folder.isDirectory()) {
            return folder.list();
        } else {
            return new String[0];
        }
    }

    /**
     * Muestra el contenido de un archivo
     *
     * @param path Ruta del archivo
     * @param fileName Nombre del archivo
     * @return Contenido del archivo como String
     * @throws FileNotFoundException Si el archivo no existe
     */
    public String showFile(String path, String fileName) throws FileNotFoundException, IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(path + "\\" + fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        return content.toString();
    }

    /**
     * Sobrescribe el contenido de un archivo
     *
     * @param path Ruta del archivo
     * @param fileName Nombre del archivo
     * @param newContent Nuevo contenido a escribir
     * @return true si se pudo sobrescribir, false si el archivo no existe
     */
    public boolean overWriteFile(String path, String fileName, String newContent) {
        File file = new File(path + "\\" + fileName);
        if (!file.exists()) {
            return false;
        }

        try (FileWriter fw = new FileWriter(file)) {
            fw.write(newContent);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina un archivo
     *
     * @param path Ruta del archivo
     * @param fileName Nombre del archivo a eliminar
     */
    public void deleteFile(String path, String fileName) {
        File file = new File(path + "\\" + fileName);
        if (file.exists()) {
            file.delete();
        }
    }

    /**
     * Cuenta los caracteres de un archivo
     *
     * @param path Ruta del archivo
     * @param fileName Nombre del archivo
     * @return Número de caracteres del archivo
     * @throws IOException Si hay error al leer el archivo
     */
    public int countChars(String path, String fileName) throws IOException {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path + "\\" + fileName))) {
            while (br.read() != -1) {
                count++;
            }
        }
        return count;
    }

    /**
     * Cuenta las palabras de un archivo
     *
     * @param path Ruta del archivo
     * @param fileName Nombre del archivo
     * @return Número de palabras del archivo
     * @throws IOException Si hay error al leer el archivo
     */
    public int countWords(String path, String fileName) throws IOException {
        int count = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path + "\\" + fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                count += words.length;
            }
        }
        return count;
    }

    /**
     * Reemplaza palabras en un archivo
     *
     * @param path Ruta del archivo
     * @param fileName Nombre del archivo
     * @param oldWord Palabra a reemplazar
     * @param newWord Nueva palabra
     * @return Nuevo contenido del archivo después del reemplazo
     * @throws IOException Si hay error al leer/escribir el archivo
     */
    public String swapWords(String path, String fileName, String oldWord, String newWord) throws IOException {
        String content = showFile(path, fileName);
        String newContent = content.replaceAll(oldWord, newWord);
        overWriteFile(path, fileName, newContent);
        return newContent;
    }

    /**
     * Crea un PDF con el contenido de un archivo
     *
     * @param path Ruta del archivo
     * @param fileName Nombre del archivo
     * @throws IOException Si hay error al leer el archivo o crear el PDF
     */
    /**
     * Crea un PDF con el contenido de un archivo de texto
     *
     * @param path Ruta del archivo de origen
     * @param fileName Nombre del archivo de origen
     * @throws IOException Si hay error al leer el archivo o crear el PDF
     * IMPORTANTE: Está creada con chat porque no sabía como hacerlo, y ni funciona
     */
//    public void printPDF(String path, String fileName) throws IOException {
//        String content = showFile(path, fileName);
//
//        // Obtener el servicio de impresión
//        PrinterJob job = PrinterJob.getPrinterJob();
//
//        if (job.printDialog()) {
//            job.setPrintable((graphics, pageFormat, pageIndex) -> {
//                if (pageIndex > 0) {
//                    return Printable.NO_SUCH_PAGE;
//                }
//
//                Graphics2D g2d = (Graphics2D) graphics;
//                g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
//
//                // Imprimir el contenido
//                String[] lines = content.split("\n");
//                int y = 15;
//                for (String line : lines) {
//                    g2d.drawString(line, 50, y);
//                    y += 15;
//                }
//
//                return Printable.PAGE_EXISTS;
//            });
//
//            try {
//                job.print();
//            } catch (PrinterException e) {
//                throw new IOException("Error al imprimir", e);
//            }
//        }
//    }
}
