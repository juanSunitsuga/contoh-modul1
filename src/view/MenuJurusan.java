package view;

import java.util.Scanner;

import controller.JurusanController;
import model.Jurusan;

public class MenuJurusan {
    private JurusanController controller;

    public MenuJurusan(JurusanController controller) {
        this.controller = controller;
    }

    public void tampilkanDaftarJurusan() {
        System.out.println("=== Daftar Jurusan ===");
        for (Jurusan jurusan : controller.getDaftarJurusan()) {
            System.out.println("Kode: " + jurusan.getKode());
            System.out.println("Nama: " + jurusan.getNama());
            System.out.println("-------------------------");
        }
    }

    public void menuPendaftaranJurusanBaru() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Menu Pendaftaran Jurusan Baru ===");
        System.out.print("Masukkan Kode Jurusan: ");
        String kode = scanner.nextLine();
        System.out.print("Masukkan Nama Jurusan: ");
        String nama = scanner.nextLine();

        Jurusan jurusanBaru = new Jurusan(kode, nama);
        try {
            controller.tambahJurusan(jurusanBaru);
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
        System.out.println("Jurusan berhasil didaftarkan!");
    }

    public void hapusJurusanByKode() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kode jurusan yang ingin dihapus: ");
        String kode = scanner.nextLine();
        boolean result = controller.hapusJurusanByKode(kode);
        if (result) {
            System.out.println("Jurusan berhasil dihapus.");
        } else {
            System.out.println("Jurusan dengan kode tersebut tidak ditemukan.");
        }
    }

    public void menuUtamaJurusan() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== Menu Jurusan ===");
            System.out.println("1. List Jurusan");
            System.out.println("2. Daftarkan Jurusan");
            System.out.println("3. Hapus Jurusan");
            System.out.println("0. Keluar");
            System.out.print("Choose: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    tampilkanDaftarJurusan();
                    break;
                case "2":
                    menuPendaftaranJurusanBaru();
                    break;
                case "3":
                    hapusJurusanByKode();
                    break;
                case "0":
                    System.out.println("Keluar dari menu jurusan.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}