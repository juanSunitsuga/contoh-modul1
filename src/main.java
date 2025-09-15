import java.util.Scanner;
import controller.*;
import view.*;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        JurusanController jurusanController = new JurusanController();
        MahasiswaController mahasiswaController = new MahasiswaController();
        MataKuliahController mataKuliahController = new MataKuliahController();

        MenuJurusan menuJurusan = new MenuJurusan(jurusanController);
        MenuMahasiswa menuMahasiswa = new MenuMahasiswa(mahasiswaController);
        MenuMataKuliah menuMataKuliah = new MenuMataKuliah(mataKuliahController);

        while (true) {
            System.out.println("=== Main Menu ===");
            System.out.println("1. Menu Jurusan");
            System.out.println("2. Menu Mahasiswa");
            System.out.println("3. Menu Mata Kuliah");
            System.out.println("0. Keluar");
            System.out.print("Choose: ");
            String pilihan = scanner.nextLine();

            switch (pilihan) {
                case "1":
                    menuJurusan.menuUtamaJurusan();
                    break;
                case "2":
                    menuMahasiswa.menuUtamaMahasiswa();
                    break;
                case "3":
                    menuMataKuliah.menuUtamaMataKuliah();
                    break;
                case "0":
                    System.out.println("Keluar dari program.");
                    return;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }
}
