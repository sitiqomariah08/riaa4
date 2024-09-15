/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankeempat;

/**
 *
 * @author Careen Emilza
 */
public class Throws {

    // Method yang melemparkan pengecualian NumberFormatException
    public static void konversiStringKeAngka() throws NumberFormatException {
        String angkaString = "abc"; // String ini tidak bisa dikonversi menjadi angka
        int angka = Integer.parseInt(angkaString); // Akan memunculkan NumberFormatException
    }

    public static void main(String[] args) {
        try {
            // Mencoba memanggil metode yang bisa menyebabkan pengecualian
            konversiStringKeAngka();
        } catch (NumberFormatException e) {
            // Menangkap pengecualian NumberFormatException dan menampilkan pesan
            System.out.println("Error: Tidak bisa mengonversi string ke angka!");
        }
    }
}
