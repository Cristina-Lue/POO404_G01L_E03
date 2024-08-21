package com.saludo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class SaludoPersonalizado {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Solicitar nombre, sexo, y fecha de nacimiento
        System.out.print("Ingrese su nombre y apellido: ");
        String nombreCompleto = scanner.nextLine();

        System.out.print("Ingrese su sexo (Masculino/Femenino): ");
        String sexo = scanner.nextLine();

        String fechaNacimiento = "";
        while (true) {
            System.out.print("Ingrese su fecha de nacimiento (dd-mm-aaaa): ");
            fechaNacimiento = scanner.nextLine();
            if (validarFecha(fechaNacimiento)) {
                break;
            } else {
                System.out.println("Fecha inválida, por favor intente nuevamente.");
            }
        }

        // Calcular edad y saludar
        try {
            saludarYCalcularEdad(nombreCompleto, sexo, fechaNacimiento);
        } catch (ParseException e) {
            System.out.println("Error al procesar la fecha de nacimiento.");
        }

    }
}