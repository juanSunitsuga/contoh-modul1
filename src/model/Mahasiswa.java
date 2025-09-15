package model;

import java.util.HashMap;
import java.util.Map;

public class Mahasiswa {
    private String nim;
    private String nama;
    private Jurusan jurusan;
    private Map<MataKuliah, String> indeksNilai; // 4=A, 3=B, 2=C, 1=D, 0=E

    public Mahasiswa(String nim, String nama, Jurusan jurusan) {
        this.nim = nim;
        this.nama = nama;
        this.jurusan = jurusan;
        this.indeksNilai = new HashMap<>();
    }

    public String getNim() {
        return nim;
    }

    public String getNama() {
        return nama;
    }

    public Jurusan getJurusan() {
        return jurusan;
    }

    public Map<MataKuliah, String> getIndeksNilai() {
        return indeksNilai;
    }

    public void setIndeksNilai(MataKuliah mataKuliah, String nilai) {
        this.indeksNilai.put(mataKuliah, nilai);
    }
}