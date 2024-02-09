/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.primeraactividadpsp;

import java.io.FileInputStream;
import java.io.IOException;

/**
 *
 * @author manuelmsni
 */
public class Ej5 {
    public static void detectorUTF8(String path) {

        try{
            FileInputStream fis = new FileInputStream(path);
            int valorDelByte;
            boolean esUTF8 = false;
            boolean noEsUTF8 = false;

            while ((valorDelByte = fis.read()) != -1) {
                if ((valorDelByte & 0x80) == 0) {
                    /**
                     * Comprueba si el byte más significativo es 0
                     * Caracter de 7 bits (0xxxxxxx)
                     * & => and lógico
                     * 0&80 => 10000000 en binario
                     * Con el and lógico de (byte & 0&80) se conserva solo el bit más significativo, si este es cero significa que el byte comienza con un cero
                     */
                } else if ((valorDelByte & 0xE0) == 0xC0) {
                    /**
                     * Verifica una secuencia de 2 bytes
                     * Inicio de secuencia de 2 bytes (110xxxxx)
                     * 0xE0 => (11100000) en binario
                     * 0xC0 => (11000000) en binario
                     * Con el and lógico de (byte & 0xE0) se conservan solo los tres bits más significativos, si son (0xC0 o 11000000), indica el inicio de una secuencia de dos bytes
                     */   
                    int byte2 = fis.read(); // Se procede a leer el otro byte
                    if ((byte2 & 0xC0) == 0x80) {
                        /**
                        * Verifica si el segundo byte de una secuencia de 2 bytes comienza con '10xxxxxx'.
                        * 0xC0 => (11000000) en binario
                        * 0x80 => (10000000) en binario
                        * Con el and lógico de (byte2 & 0xC0) se asegura que el segundo byte cumple con el formato esperado.
                        */
                        esUTF8 = true;
                    } else {
                        noEsUTF8 = true;
                    }
                } else if ((valorDelByte & 0xF0) == 0xE0) {
                    /**
                     * Verifica una secuencia de 3 bytes
                     * Inicio de secuencia de 3 bytes (1110xxxx)
                     * 0xF0 => (11110000) en binario
                     * 0xE0 => (11100000) en binario
                     * Con el and lógico de (byte & 0xF0) se conservan solo los cuatro bits más significativos, si son (0xE0 o 11100000), indica el inicio de una secuencia de 3 bytes
                     */
                    int byte2 = fis.read(); // Se procede a leer el otro byte
                    int byte3 = fis.read(); // Se procede a leer el otro byte
                    if ((byte2 & 0xC0) == 0x80 && (byte3 & 0xC0) == 0x80) {
                        /**
                         * Verifica si el segundo y tercer byte de una secuencia de 3 bytes comienzan con '10xxxxxx'.
                         * 0xC0 => (11000000) en binario
                         * 0x80 => (10000000) en binario
                         * Con el and lógico de (byte2 & 0xC0) y (byte3 & 0xC0) se asegura que los bytes segundo y tercero cumplen con el formato esperado.
                         */
                        esUTF8 = true;
                    } else {
                        noEsUTF8 = true;
                    }
                } else if ((valorDelByte & 0x80) == 0x80) {
                    /**
                     * Verifica si el bit más significativo es igual a uno
                     * Caracter de 8 bits (1xxxxxxx)
                     * 0&80 => (10000000) en binario
                     * Con el and lógico de (byte & 0x80) se conserva el bit más significativo, si este es uno significa que el byte comienza con un uno
                     */
                    noEsUTF8 = true;
                }
            }

            if (noEsUTF8) {
                System.out.println("No es UTF-8");
            } else if (esUTF8) {
                System.out.println("Es UTF-8");
            } else {
                System.out.println("Es ANSI");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
