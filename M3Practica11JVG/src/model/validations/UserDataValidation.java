/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model.validations;

import exceptions.ExceptionDNI;
import exceptions.ExceptionName;

/**
 *
 * @author javiervilgal
 */
public class UserDataValidation {

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAlphabetic(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isLetter(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean checkPostalCode(String zip) {
        return zip.length() == 5 && isNumeric(zip);
    }

    public static boolean checkFormatDate(String date) {
        String[] partes = date.split("/");
        if (partes.length != 3) {
            return false;
        }

        try {
            int dia = Integer.parseInt(partes[0]);
            int mes = Integer.parseInt(partes[1]);
            int anio = Integer.parseInt(partes[2]);

            if (mes < 1 || mes > 12 || dia < 1 || dia > 31 || anio < 0) {
                return false;
            }

            if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia > 30) {
                return false;
            }

            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int calculateAge(String birthDate) {
        if (!checkFormatDate(birthDate)) {
            return -1;
        }

        String[] partes = birthDate.split("/");
        int diaNac = Integer.parseInt(partes[0]);
        int mesNac = Integer.parseInt(partes[1]);
        int anioNac = Integer.parseInt(partes[2]);

        java.time.LocalDate ahora = java.time.LocalDate.now();
        int diaActual = ahora.getDayOfMonth();
        int mesActual = ahora.getMonthValue();
        int anioActual = ahora.getYear();

        int edad = anioActual - anioNac;
        if (mesActual < mesNac || (mesActual == mesNac && diaActual < diaNac)) {
            edad--;
        }

        return edad;
    }

    public static boolean checkId(int typeDoc, String id) throws ExceptionDNI {
        if (typeDoc != 1 || id.length() != 9) {
            throw new ExceptionDNI("Needs 9 characters");
        }

        String numeros = id.substring(0, 8);
        char letra = id.charAt(8);

        if (!isNumeric(numeros)) {
            throw new ExceptionDNI("First 8 characters have to be numbers");
        }

        String NIF = "TRWAGMYFPDXBNJZSQVHLCKE";
        int resto = Integer.parseInt(numeros) % 23;
        return NIF.charAt(resto) == letra;
    }

    public static boolean checkEmail(String email) {
        String regex = "^[A-Za-z0-9+_.-]+@(.+)$";
        return email.matches(regex) && email.contains("@") && (email.endsWith(".com") || email.endsWith(".es"));
    }

    public static boolean checkName(String name) throws ExceptionName {
        if (name.length() < 2 || name.length() > 50) {
            throw new ExceptionName("Needs between 2 - 50 characters");
        }

        if (!isAlphabetic(name)) {
            throw new ExceptionName("Only alphabetics characters");
        }

        return true;
    }

}
