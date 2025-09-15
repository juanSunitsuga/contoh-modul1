package view;

import java.util.Scanner;
import controller.MataKuliahController;
import model.*;

public class MenuMataKuliah {
    private MataKuliahController controller;

    public MenuMataKuliah(MataKuliahController controller) {
        this.controller = controller;
    }

    public void tampilkanDaftarMataKuliah(Jurusan jurusan) {
        System.out.println("=== Daftar Mata Kuliah ===");
        if (jurusan == null || jurusan.getMataKuliahList().isEmpty()) {
            System.out.println("Jurusan tidak ditemukan atau belum ada mata kuliah.");
            return;
        }
        for (MataKuliah mk : jurusan.getMataKuliahList()) {
            System.out.println("Kode: " + mk.getKode());
            System.out.println("Nama: " + mk.getNama());
            System.out.println("SKS: " + mk.getSks());
            System.out.println("-------------------------");
        }
    }

    public void menuTambahMataKuliah() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kode jurusan: ");
        String kodeJurusan = scanner.nextLine();
        Jurusan jurusan = Jurusan.findJurusan(kodeJurusan);
        if (jurusan == null) {
            System.out.println("Jurusan tidak ditemukan.");
            return;
        }
        System.out.print("Masukkan kode mata kuliah: ");
        String kodeMK = scanner.nextLine();
        System.out.print("Masukkan nama mata kuliah: ");
        String namaMK = scanner.nextLine();
        System.out.print("Masukkan jumlah SKS: ");
        int sks = Integer.parseInt(scanner.nextLine());

        MataKuliah mkBaru = new MataKuliah(kodeMK, namaMK, sks);
        controller.tambahMataKuliah(jurusan, mkBaru);
        System.out.println("Mata kuliah berhasil ditambahkan.");
    }

    public void menuHapusMataKuliah() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan kode jurusan: ");
        String kodeJurusan = scanner.nextLine();
        Jurusan jurusan = Jurusan.findJurusan(kodeJurusan);
        if (jurusan == null) {
            System.out.println("Jurusan tidak ditemukan.");
            return;
        }
        System.out.print("Masukkan kode mata kuliah yang ingin dihapus: ");
        String kodeMK = scanner.nextLine();
        boolean result = controller.hapusMataKuliah(jurusan, kodeMK);
        if (result) {
            System.out.println("Mata kuliah berhasil dihapus.");
        } else {
            System.out.println("Mata kuliah dengan kode tersebut tidak ditemukan.");
        }
    }

    public void menuUtamaMataKuliah() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== Menu Mata Kuliah ===");
            System.out.println("1. List Mata Kuliah");
            System.out.println("2. Tambah Mata Kuliah");
            System.out.println("3. Hapus Mata Kuliah");
            System.out.println("0. Keluar");
            System.out.print("Choose: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    System.out.print("Masukkan kode jurusan: ");
                    String kodeJurusan = scanner.nextLine();
                    Jurusan jurusan = Jurusan.findJurusan(kodeJurusan);
                    tampilkanDaftarMataKuliah(jurusan);
                    break;
                case "2":
                    menuTambahMataKuliah();
                    break;
                case "3":
                    menuHapusMataKuliah();
                    break;
                case "0":
                    System.out.println("Keluar dari menu mata kuliah.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
