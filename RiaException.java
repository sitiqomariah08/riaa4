/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankeempat;

/**
 *
 * @author Careen Emilza
 */
public class RiaException extends Exception {
    
    // Konstruktor custom exception
    public RiaException(String message) {
        super(message);
    }

    // Metode untuk memvalidasi apakah angka positif
    public static void validasiAngka(int angka) throws RiaException {
        if (angka < 0) {
            // Jika angka negatif, lemparkan custom exception
            throw new RiaException("Angka tidak boleh negatif!");
        }
        System.out.println("Angka valid: " + angka);
    }

    public static void main(String[] args) {
        int angka = -5; // Angka negatif

        try {
            // Mencoba memvalidasi angka
            validasiAngka(angka);
        } catch (RiaException e) {
            // Menangani custom exception
            System.out.println("Error: " + e.getMessage());
        }
    }
}
