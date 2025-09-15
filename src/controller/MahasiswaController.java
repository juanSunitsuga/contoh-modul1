package controller;

import model.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaController {
    private List<Mahasiswa> daftarMahasiswa;

    public MahasiswaController() {
        daftarMahasiswa = new ArrayList<>();
    }

    public void tambahMahasiswa(Mahasiswa mahasiswa) {
        daftarMahasiswa.add(mahasiswa);
    }

    public List<Mahasiswa> getDaftarMahasiswa() {
        return daftarMahasiswa;
    }

    // Logic to calculate total SKS for a Mahasiswa
    public int getTotalSks(Mahasiswa m) {
        int totalSks = 0;
        if (m.getJurusan() != null && m.getJurusan().getMataKuliahList() != null) {
            for (MataKuliah mk : m.getJurusan().getMataKuliahList()) {
                totalSks += mk.getSks();
            }
        }
        return totalSks;
    }

    public double getGpa(Mahasiswa m, List<Integer> indeksNilai) {
        // Nilai indeks: E=0, D=1, C=2, B=3, A=4
        double[] nilaiKonversi = {0.0, 1.0, 2.0, 3.0, 4.0};
        double totalNilai = 0;
        int jumlahMatkul = 0;
        if (m.getJurusan() != null && m.getJurusan().getMataKuliahList() != null) {
            List<MataKuliah> matkulList = m.getJurusan().getMataKuliahList();
            for (int i = 0; i < matkulList.size(); i++) {
                int idx = (indeksNilai != null && i < indeksNilai.size()) ? indeksNilai.get(i) : 4; // default A
                totalNilai += nilaiKonversi[idx];
                jumlahMatkul++;
            }
        }
        return jumlahMatkul > 0 ? totalNilai / jumlahMatkul : 0;
    }

    public Mahasiswa cariMahasiswaByNim(String nim) {
        for (Mahasiswa m : daftarMahasiswa) {
            if (m.getNim().equalsIgnoreCase(nim)) {
                return m;
            }
        }
        return null;
    }

    public boolean hapusMahasiswaByNim(String nim) {
        Mahasiswa mhs = cariMahasiswaByNim(nim);
        if (mhs != null) {
            daftarMahasiswa.remove(mhs);
            return true;
        }
        return false;
    }
}
