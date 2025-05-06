/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view.console;

import exceptions.ExceptionDNI;
import exceptions.ExceptionName;
import model.validations.UserDataValidation;

/**
 *
 * @author javiervilgal
 */
import java.util.Scanner;

public class Main {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        String option;
        do {
            System.out.println("1 - Tester CheckId");
            System.out.println("2 - Tester CheckFormatDate");
            System.out.println("3 - Tester CalculateAge");
            System.out.println("4 - Tester CheckPostalCode");
            System.out.println("5 - Tester IsNumeric");
            System.out.println("6 - Tester IsAlphabetic");
            System.out.println("7 - Tester CheckEmail");
            System.out.println("8 - Tester CheckName");
            System.out.println("z - Salir");
            option = sc.nextLine(); 

            switch (option) {
                case "1" ->
                    testCheckId();
                case "2" ->
                    testCheckFormatDate();
                case "3" ->
                    testCalculateAge();
                case "4" ->
                    testCheckPostalCode();
                case "5" ->
                    testIsNumeric();
                case "6" ->
                    testIsAlphabetic();
                case "7" ->
                    testCheckEmail();
                case "8" ->
                    testCheckName();
                default -> {
                }
            }
        } while (!option.equals("z"));

        System.out.println("¡Gracias por usar el programa!");
    }

    static void testCheckId() {
    System.out.println("Introduce tu id:");
    String id = sc.next();

    try {
        boolean result = UserDataValidation.checkId(1, id);
        if (result) {
            System.out.println("Id correcto");
        }
    } catch (ExceptionDNI ex) {
        System.out.println("El id no es correcto: " + ex.getMessage());
    }
}


    static void testCheckFormatDate() {
        System.out.println("Introduce una fecha (dd/mm/aaaa)");
        String fecha = sc.next();
        boolean result = UserDataValidation.checkFormatDate(fecha);
        System.out.println("Fecha válida: " + result);
    }

    static void testCalculateAge() {
        System.out.println("Introduce tu fecha de nacimiento (dd/mm/aaaa)");
        String fecha = sc.next();
        int edad = UserDataValidation.calculateAge(fecha);
        if (edad == -1) {
            System.out.println("Fecha inválida");
        } else {
            System.out.println("Tu edad es: " + edad);
        }
    }

    static void testCheckPostalCode() {
        System.out.println("Introduce tu código postal");
        String codigo = sc.next();
        boolean result = UserDataValidation.checkPostalCode(codigo);
        System.out.println("Código postal válido: " + result);
    }

    static void testIsNumeric() {
        System.out.println("Introduce un valor numérico");
        String valor = sc.next();
        boolean result = UserDataValidation.isNumeric(valor);
        System.out.println("Es numérico: " + result);
    }

    static void testIsAlphabetic() {
        System.out.println("Introduce un valor alfabético");
        String valor = sc.next();
        boolean result = UserDataValidation.isAlphabetic(valor);
        System.out.println("Es alfabético: " + result);
    }

    static void testCheckEmail() {
        System.out.println("Introduce tu correo electrónico");
        String email = sc.next();
        boolean result = UserDataValidation.checkEmail(email);
        System.out.println("Correo válido: " + result);
    }

    static void testCheckName() {
    System.out.println("Introduce tu nombre:");
    String nombre = sc.next();

    try {
        boolean result = UserDataValidation.checkName(nombre);
        System.out.println("Nombre válido: " + result);
    } catch (ExceptionName ex) {
        System.out.println("Nombre inválido: " + ex.getMessage());
    }
}

}
