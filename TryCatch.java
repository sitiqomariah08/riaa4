/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pertemuankeempat;

import java.util.Scanner;

/**
 *
 * @author IT GRC
 */
public class TryCatch {

     // Metode dengan try-catch untuk menangani NumberFormatException
    public void prosesDataDenganTryCatch() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan angka (Try-Catch): ");
        
        try {
            String input = scanner.nextLine(); // Membaca input dari pengguna
            int angka = Integer.parseInt(input); // Mencoba konversi input ke angka
            System.out.println("Angka yang dimasukkan (Try-Catch): " + angka);
        } catch (NumberFormatException e) {
            // Menangani NumberFormatException jika input bukan angka yang valid
            System.out.println("Error di metode Try-Catch: Input tidak bisa dikonversi menjadi angka!");
        }
    }

    public static void main(String[] args) {
        TryCatch contoh = new TryCatch();
        
contoh.prosesDataDenganTryCatch(); // Memanggil metode dengan try-catch
    }
}
