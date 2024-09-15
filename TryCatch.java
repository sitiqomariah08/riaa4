/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankeempat;

/**
 *
 * @author Careen Emilza
 */
public class TryCatch {

    public static void main(String[] args) {
        int[] angka = {1, 2, 3};

        try {
            // Mencoba mengakses elemen array yang berada di luar batas
            int nilai = angka[5];  // Indeks 5 di luar batas (array hanya punya 3 elemen)
            System.out.println("Nilai elemen: " + nilai);
        } catch (ArrayIndexOutOfBoundsException e) {
            // Menangani pengecualian jika indeks di luar batas
            System.out.println("Error: Indeks array di luar batas.");
        }

        System.out.println("Program selesai.");
    }
}