package controller;

import model.*;
import java.util.List;

public class JurusanController {
    public List<Jurusan> getDaftarJurusan() {
        return DataDummy.jurusanList;
    }

    public Jurusan cariJurusan(String kode) {
        return Jurusan.findJurusan(kode);
    }

    public void tambahJurusan(Jurusan jurusan) {
        DataDummy.jurusanList.add(jurusan);
    }

    public boolean hapusJurusanByKode(String kode) {
        Jurusan jurusan = cariJurusan(kode);
        if (jurusan != null) {
            DataDummy.jurusanList.remove(jurusan);
            return true;
        }
        return false;
    }
}