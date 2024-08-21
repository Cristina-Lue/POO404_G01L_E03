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

        // Determinar si el año es bisiesto
        int anioNacimiento = obtenerAnio(fechaNacimiento);
        if (esBisiesto(anioNacimiento)) {
            System.out.println("El año " + anioNacimiento + " es bisiesto.");
        } else {
            System.out.println("El año " + anioNacimiento + " no es bisiesto.");
        }

        // Mostrar el día de la semana de nacimiento
        try {
            mostrarDiaDeLaSemana(fechaNacimiento);
        } catch (ParseException e) {
            System.out.println("Error al procesar la fecha para obtener el día de la semana.");
        }

        scanner.close();
    }

    // Método para validar el formato y los días del mes en la fecha
    public static boolean validarFecha(String fecha) {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        formatoFecha.setLenient(false); // Desactivar modo permisivo para validar fechas estrictamente

        try {
            Date fechaParseada = formatoFecha.parse(fecha);
            Calendar calendario = Calendar.getInstance();
            calendario.setTime(fechaParseada);

            // Verificar días específicos de cada mes, incluyendo años bisiestos
            int dia = calendario.get(Calendar.DAY_OF_MONTH);
            int mes = calendario.get(Calendar.MONTH) + 1; // Enero es 0, diciembre es 11
            int anio = calendario.get(Calendar.YEAR);

            // Validar febrero para años bisiestos
            if (mes == 2) {
                if (esBisiesto(anio) && dia <= 29) {
                    return true;
                } else if (!esBisiesto(anio) && dia <= 28) {
                    return true;
                }
            } else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia <= 30) {
                return true; // Meses con 30 días
            } else if (dia <= 31) {
                return true; // Meses con 31 días
            }

        } catch (ParseException e) {
            return false;
        }
        return false;
    }

    // Método para calcular la edad y saludar
    public static void saludarYCalcularEdad(String nombreCompleto, String sexo, String fechaNacimiento) throws ParseException {
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
        Date fechaNac = formatoFecha.parse(fechaNacimiento);

        Calendar calendario = Calendar.getInstance();
        calendario.setTime(fechaNac);

        int anioNacimiento = calendario.get(Calendar.YEAR);
        int anioActual = Calendar.getInstance().get(Calendar.YEAR);
        int edad = anioActual - anioNacimiento;

        String[] nombreDividido = nombreCompleto.split(" ");
        String nombre = nombreDividido[0];
        String apellido = nombreDividido.length > 1 ? nombreDividido[1] : "";

        if (edad > 30) {
            if (sexo.equalsIgnoreCase("Masculino")) {
                System.out.println("Buenos días Mr. " + apellido);
            } else if (sexo.equalsIgnoreCase("Femenino")) {
                System.out.println("Buenos días Ms. " + apellido);
            }
        } else {
            if (sexo.equalsIgnoreCase("Masculino")) {
                System.out.println("Hola amigo " + nombre);
            } else if (sexo.equalsIgnoreCase("Femenino")) {
                System.out.println("Hola amiga " + nombre);
            }
        }

        System.out.println("Tienes " + edad + " años.");
    }
}