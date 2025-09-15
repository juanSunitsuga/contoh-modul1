package model;

import java.util.ArrayList;
import java.util.List;

public class DataDummy {
    public static List<Jurusan> jurusanList = new ArrayList<>();

    static {
        Jurusan informatika = new Jurusan("IF", "Informatika");
        ArrayList<MataKuliah> informatikaMatkul = new ArrayList<>();
        informatikaMatkul.add(new MataKuliah("IF101", "Algoritma dan Pemrograman", 3));
        informatikaMatkul.add(new MataKuliah("IF102", "Struktur Data", 3));
        informatika.setMataKuliahList(informatikaMatkul);

        Jurusan sistemInformasi = new Jurusan("SI", "Sistem Informasi");
        ArrayList<MataKuliah> sistemInformasiMatkul = new ArrayList<>();
        sistemInformasiMatkul.add(new MataKuliah("SI201", "Sistem Informasi Manajemen", 3));
        sistemInformasiMatkul.add(new MataKuliah("SI202", "Basis Data", 3));
        sistemInformasi.setMataKuliahList(sistemInformasiMatkul);

        Jurusan dkv = new Jurusan("DKV", "DKV");
        ArrayList<MataKuliah> dkvMatkul = new ArrayList<>();
        dkvMatkul.add(new MataKuliah("DKV301", "Dasar Desain Grafis", 3));
        dkvMatkul.add(new MataKuliah("DKV302", "Tipografi", 2));
        dkv.setMataKuliahList(dkvMatkul);

        jurusanList.add(informatika);
        jurusanList.add(sistemInformasi);
        jurusanList.add(dkv);
    }
}
