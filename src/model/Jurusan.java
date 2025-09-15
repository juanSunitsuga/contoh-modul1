package model;

import java.util.ArrayList;

public class Jurusan {
	private String kode;
	private String nama;
    private ArrayList<MataKuliah> mataKuliahList;

	public Jurusan(String kode, String nama) {
		this.kode = kode;
		this.nama = nama;
		this.mataKuliahList = new ArrayList<>();
	}

	public void setMataKuliahList(ArrayList<MataKuliah> mataKuliahList) {
		this.mataKuliahList = mataKuliahList;
	}

	public ArrayList<MataKuliah> getMataKuliahList() {
		return mataKuliahList;
	}

	public String getKode() {
		return kode;
	}

	public String getNama() {
		return nama;
	}

    public MataKuliah findMataKuliah(String kodeMK) {
        for (MataKuliah mk : mataKuliahList) {
            if (mk.getKode().equals(kodeMK)) {
                return mk;
            }
        }
        return null;
    }
    
    public static Jurusan findJurusan(String kodeJurusan) {
        for (Jurusan jurusan : DataDummy.jurusanList) {
            if (jurusan.getKode().equals(kodeJurusan)) {
                return jurusan;
            }
        }
        return null;
    }
}
