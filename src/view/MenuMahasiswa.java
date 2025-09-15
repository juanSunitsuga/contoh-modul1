package view;

import java.util.Scanner;

import model.*;
import controller.MahasiswaController;

public class MenuMahasiswa {
    private MahasiswaController controller;

    public MenuMahasiswa(MahasiswaController controller) {
        this.controller = controller;
    }

    public void menuPendaftaranMahasiswaBaru() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== Menu Pendaftaran Mahasiswa Baru ===");
        System.out.print("Masukkan NIM: ");
        String nim = scanner.nextLine();
        System.out.print("Masukkan Nama: ");
        String nama = scanner.nextLine();
        System.out.print("Masukkan Kode Jurusan: ");
        String kodeJurusan = scanner.nextLine();

        Jurusan newJurusan = Jurusan.findJurusan(kodeJurusan);
        Mahasiswa newMahasiswa = new Mahasiswa(nim, nama, newJurusan);

        try {
            controller.tambahMahasiswa(newMahasiswa);
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
        System.out.println("Mahasiswa berhasil didaftarkan!");
    }

    public void tampilkanDaftarMahasiswa() {
        System.out.println("=== Daftar Mahasiswa ===");
        for (Mahasiswa m : controller.getDaftarMahasiswa()) {
            System.out.println("NIM: " + m.getNim());
            System.out.println("Nama: " + m.getNama());
            System.out.println("Jurusan: " + (m.getJurusan() != null ? m.getJurusan().getNama() : "-"));
            // Tampilkan indeks nilai jika ada
            if (m.getIndeksNilai() != null && !m.getIndeksNilai().isEmpty()) {
                System.out.println("Indeks Nilai:");
                for (MataKuliah mk : m.getIndeksNilai().keySet()) {
                    String nilaiHuruf = m.getIndeksNilai().get(mk);
                    System.out.println("  " + mk.getNama() + ": " + nilaiHuruf);
                }
            }
            System.out.println("-------------------------");
        }
    }

    public void cariMahasiswaByNim() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan NIM yang dicari: ");
        String nim = scanner.nextLine();
        Mahasiswa hasil = controller.cariMahasiswaByNim(nim);
        if (hasil != null) {
            System.out.println("Mahasiswa ditemukan:");
            System.out.println("NIM: " + hasil.getNim());
            System.out.println("Nama: " + hasil.getNama());
            System.out.println("Jurusan: " + (hasil.getJurusan() != null ? hasil.getJurusan().getNama() : "-"));
            // Tampilkan indeks nilai jika ada
            if (hasil.getIndeksNilai() != null && !hasil.getIndeksNilai().isEmpty()) {
                System.out.println("Indeks Nilai:");
                for (MataKuliah mk : hasil.getIndeksNilai().keySet()) {
                    String nilaiHuruf = hasil.getIndeksNilai().get(mk);
                    System.out.println("  " + mk.getNama() + ": " + nilaiHuruf);
                }
            }
        } else {
            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
        }
    }

    public void setIndeksMahasiswa() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Masukkan NIM Mahasiswa: ");
            String nim = scanner.nextLine();
            Mahasiswa mhs = controller.cariMahasiswaByNim(nim);
            if (mhs == null) {
                System.out.println("Mahasiswa tidak ditemukan.");
                return;
            }
            Jurusan jurusan = mhs.getJurusan();
            if (jurusan == null || jurusan.getMataKuliahList() == null || jurusan.getMataKuliahList().isEmpty()) {
                System.out.println("Jurusan atau daftar mata kuliah tidak ditemukan.");
                return;
            }
            System.out.println("Daftar Mata Kuliah:");
            for (MataKuliah mk : jurusan.getMataKuliahList()) {
                System.out.println("- " + mk.getKode() + " : " + mk.getNama());
            }
            System.out.print("Masukkan kode mata kuliah yang ingin diinput nilai: ");
            String kodeMK = scanner.nextLine();
            MataKuliah targetMK = null;
            for (MataKuliah mk : jurusan.getMataKuliahList()) {
                if (mk.getKode().equalsIgnoreCase(kodeMK)) {
                    targetMK = mk;
                    break;
                }
            }
            if (targetMK == null) {
                System.out.println("Mata kuliah dengan kode tersebut tidak ditemukan.");
                return;
            }
            String nilai = "G";
            while (!nilai.equals("A") && !nilai.equals("B") && !nilai.equals("C") && !nilai.equals("D") && !nilai.equals("E")) {
                System.out.print("Nilai untuk " + targetMK.getNama() + " (A/B/C/D/E): ");
                nilai = scanner.nextLine().toUpperCase();
                if(!nilai.equals("A") && !nilai.equals("B") && !nilai.equals("C") && !nilai.equals("D") && !nilai.equals("E")) {
                    System.out.println("Input tidak valid! Masukkan hanya A, B, C, D, atau E.");
                }
            }
            mhs.setIndeksNilai(targetMK, nilai);
            System.out.println("Indeks nilai berhasil disimpan.");
        } catch (Exception e) {
            System.out.println("Terjadi kesalahan: " + e.getMessage());
        }
    }

    public void hapusMahasiswaByNim() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan NIM Mahasiswa yang ingin dihapus: ");
        String nim = scanner.nextLine();
        boolean result = controller.hapusMahasiswaByNim(nim);
        if (result) {
            System.out.println("Mahasiswa berhasil dihapus.");
        } else {
            System.out.println("Mahasiswa dengan NIM tersebut tidak ditemukan.");
        }
    }

    public void menuUtamaMahasiswa() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("=== Menu Mahasiswa ===");
            System.out.println("1. List Mahasiswa");
            System.out.println("2. Daftarkan Mahasiswa");
            System.out.println("3. Cari Mahasiswa by NIM");
            System.out.println("4. Set Indeks Nilai Mahasiswa");
            System.out.println("5. Hapus Mahasiswa by NIM");
            System.out.println("0. Keluar");
            System.out.print("Choose: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    tampilkanDaftarMahasiswa();
                    break;
                case "2":
                    menuPendaftaranMahasiswaBaru();
                    break;
                case "3":
                    cariMahasiswaByNim();
                    break;
                case "4":
                    setIndeksMahasiswa();
                    break;
                case "5":
                    hapusMahasiswaByNim();
                    break;
                case "0":
                    System.out.println("Keluar dari menu mahasiswa.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
