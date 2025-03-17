package com.example.tutorm3

class MockDB {
    // companion object digunakan untuk membuat properti atau fungsi yang bisa diakses tanpa membuat objek
    // biasanya digunakan untuk membuat properti atau fungsi yang bersifat global
    // disini mockDB digunakan untuk menyimpan data mahasiswa + function untuk menambahkan data mahasiswa
    companion object{
        val listMhs = mutableListOf<Mahasiswa>(
//            Mahasiswa("220181000", "Andi", 18),
//            Mahasiswa("220181000", "Abdi", 18),
//            Mahasiswa("220111001", "Budi", 11),
//            Mahasiswa("220101002", "Chandra", 12),
//            Mahasiswa("220171003", "Danu", 17),
        )
        fun addMahasiswa(m:Mahasiswa){
            listMhs.add(m)
        }
    }
}