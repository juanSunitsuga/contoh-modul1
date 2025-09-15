CREATE TABLE jurusan (
    kode VARCHAR(10) PRIMARY KEY,
    nama VARCHAR(100) NOT NULL
);

CREATE TABLE matakuliah (
    kode VARCHAR(10) PRIMARY KEY,
    nama VARCHAR(100) NOT NULL,
    sks INTEGER NOT NULL
);

CREATE TABLE mahasiswa (
    nim VARCHAR(20) PRIMARY KEY,
    nama VARCHAR(100) NOT NULL,
    kode_jurusan VARCHAR(10) REFERENCES jurusan(kode)
);

-- M-N table
CREATE TABLE mahasiswa_matakuliah (
    nim VARCHAR(20) REFERENCES mahasiswa(nim) ON DELETE CASCADE,
    kode_matakuliah VARCHAR(10) REFERENCES matakuliah(kode) ON DELETE CASCADE,
    indeks_nilai CHAR(1) CHECK (indeks_nilai IN ('A','B','C','D','E')),
    PRIMARY KEY (nim, kode_matakuliah)
);