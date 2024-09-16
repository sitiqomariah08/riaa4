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
public class Throws {

    // Metode dengan throws untuk NumberFormatException
    public void prosesDataDenganThrows() throws NumberFormatException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan angka (Throws): ");
        
        String input = scanner.nextLine(); // Membaca input dari pengguna
        int angka = Integer.parseInt(input); // Mencoba konversi input ke angka, bisa memunculkan NumberFormatException
        System.out.println("Angka yang dimasukkan (Throws): " + angka);
    }

    public static void main(String[] args) {
        Throws contoh = new Throws;
        
        try {
            contoh.prosesDataDenganThrows(); // Memanggil metode yang melempar pengecualian
        } catch (NumberFormatException e) {
            // Menangani pengecualian dari metode dengan throws
            System.out.println("Error di metode Throws: Input tidak bisa dikonversi menjadi angka!");
        }
    }
}
