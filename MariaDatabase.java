/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pertemuankeempat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author Intelligent System
 */
public class MariaDatabase {

    /**
     * @param args the command line arguments
     */
    Connection conn;
    Statement stmt;
    PreparedStatement pstmt = null;

    String driver = "org.postgresql.Driver";
    String koneksi = "jdbc:postgresql://localhost:5432/TOKOBUKU2";
    String user = "postgres";
    String password = "189066";
    InputStreamReader inputStreamReader = new InputStreamReader(System.in);
    BufferedReader input = new BufferedReader(inputStreamReader);

    public void tambah() {
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            conn.setAutoCommit(false); // Nonaktifkan otomatis commit

            String sql = "INSERT INTO petugas VALUES(?,?,?,?)";
            pstmt = conn.prepareStatement(sql);

            boolean selesai = false;
            while (!selesai) {
                System.out.println("MASUKKAN DATA PETUGAS ");
                System.out.print("ID Petugas : ");
                String id_petugas = input.readLine().trim();
                System.out.print("Nama : ");
                String nama = input.readLine().trim();
                System.out.print("Gender : ");
                String gender = input.readLine().trim();
                System.out.print("Umur : ");
                String umur = input.readLine().trim();

                pstmt.setLong(1, Long.parseLong(id_petugas));
                pstmt.setString(2, nama);
                pstmt.setString(3, gender);
                pstmt.setLong(4, Long.parseLong(umur));
                pstmt.executeUpdate();

                System.out.print("Apakah Anda ingin memasukkan data petugas lainnya? (iya/tidak): ");
                String pilihan = input.readLine().trim();
                if (!pilihan.equalsIgnoreCase("iya")) {
                    selesai = true; // Ubah ke true agar loop berhenti jika tidak ingin memasukkan data lagi
                }
            }

            conn.commit(); // Commit transaksi setelah sejumlah operasi-insert berhasil
            pstmt.close();
            conn.close();
            System.out.println("Sukses dalam satu transaksi.");
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            System.out.println("Terjadi kesalahan saat melakukan operasi insert dalam loop.");
            ex.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback(); // Batalkan transaksi jika terjadi kesalahan
                }
            } catch (SQLException e) {
                System.out.println("Gagal melakukan rollback transaksi.");
                e.printStackTrace();
            }
        }
    }

    public void tampil() {
        try {
            // TODO code application logi
            Class.forName(driver);
            String sql = "SELECT * FROM petugas";
            conn = DriverManager.getConnection(koneksi, user, password);
            stmt = conn.createStatement();

            while (!conn.isClosed()) {
                ResultSet rs;
                rs = stmt.executeQuery(sql);
                while (rs.next()) {
                    System.out.println(String.valueOf(rs.getObject(1)) + " " + String.valueOf(rs.getObject(2)) + " " + String.valueOf(rs.getObject(3)) + " " + String.valueOf(rs.getObject(4)));
                }
                conn.close();
            }

            stmt.close();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(MariaDatabase.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(MariaDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void hapus() {
         try {
            Class.forName(driver);
            conn = DriverManager.getConnection(koneksi, user, password);
            conn.setAutoCommit(false); 
            int k = 0;

            String sql = "DELETE FROM petugas WHERE id_petugas = ?";
            pstmt = conn.prepareStatement(sql);
            
            boolean selesai = false;
            while (!selesai) {
           
            System.out.print("Masukkan id petugas yang akan dihapus : ");
            String dogtagToDelete = input.readLine().trim();

            // Delete the record from the database
            String deleteSql = "DELETE FROM petugas WHERE id_petugas = ?";
            pstmt = conn.prepareStatement(deleteSql);
            pstmt.setString(1, dogtagToDelete);
             int n = pstmt.executeUpdate();
                k = k + n;


             System.out.print("Apakah Anda ingin menghapus data petugas lainnya? (iya/tidak): ");
                String pilihan = input.readLine().trim();
                if (!pilihan.equalsIgnoreCase("iya")) {
                    selesai = true; 
                }
            }

            conn.commit(); 
            pstmt.close();
            conn.close();
            System.out.println(k + " data petugas berhasil dihapus.");
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            System.out.println("Terjadi kesalahan saat melakukan operasi delete dalam loop.");
            ex.printStackTrace();
            try {
                if (conn != null) {
                    conn.rollback(); 
                }
            } catch (SQLException e) {
                System.out.println("Gagal melakukan rollback transaksi.");
                e.printStackTrace();
            }
        }
    }

    public void update() {
        try {
            Class.forName(driver);
            String sql = "UPDATE petugas SET nama_petugas = ?, gender =?, umur = ? WHERE id_petugas = ?";
            conn = DriverManager.getConnection(koneksi, user, password);
            pstmt = conn.prepareStatement(sql);

            System.out.print("Masukkan ID Petugas yang akan diupdate: ");
            String idPetugas = input.readLine().trim();
            System.out.print("Nama Petugas baru: ");
            String namaPetugasBaru = input.readLine().trim();
            System.out.print("Gender baru: ");
            String genderBaru = input.readLine().trim();
            System.out.print("Umur baru: ");
            String umurBaru = input.readLine().trim();

            pstmt.setString(1, namaPetugasBaru);
            pstmt.setString(2, genderBaru);
            pstmt.setLong(3, Long.parseLong(umurBaru));
            pstmt.setLong(4, Long.parseLong(idPetugas));

            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Data berhasil diupdate.");
            } else {
                System.out.println("Data tidak ditemukan.");
            }

            pstmt.close();
            conn.close();
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            Logger.getLogger(MariaDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void menu() {
        System.out.println("\n========= MENU UTAMA =========");
        System.out.println("1. Input Data");
        System.out.println("2. Tampil Data");
        System.out.println("3. Hapus Data");
        System.out.println("4. Update Data");
        System.out.println("0. keluar");
        System.out.print("PILIHAN> ");

        try {
            int pilihan = Integer.parseInt(input.readLine());
            switch (pilihan) {
                case 0:
                    System.exit(0);
                    break;
                case 1:
                    tambah();
                    break;
                case 2:
                    tampil();
                    break;
                case 3:
                    hapus();
                    break;
                case 4:
                    update();
                    break;
                default:
                    System.out.println("Pilihan salah!");
            }
        } catch (IOException ex) {
            Logger.getLogger(MariaDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        new MariaDatabase().menu();
    }

}
