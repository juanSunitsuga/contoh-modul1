package controller;

import model.*;

public class MataKuliahController {

    public void tambahMataKuliah(Jurusan jurusan, MataKuliah mataKuliah) {
        if (jurusan != null && mataKuliah != null) {
            jurusan.getMataKuliahList().add(mataKuliah);
        }
    }

    public MataKuliah cariMataKuliah(Jurusan jurusan, String kode) {
        if (jurusan != null && kode != null) {
            for (MataKuliah mk : jurusan.getMataKuliahList()) {
                if (mk.getKode().equalsIgnoreCase(kode)) {
                    return mk;
                }
            }
        }
        return null;
    }

    public boolean hapusMataKuliah(Jurusan jurusan, String kode) {
        MataKuliah mk = cariMataKuliah(jurusan, kode);
        if (mk != null) {
            return jurusan.getMataKuliahList().remove(mk);
        }
        return false;
    }
}
