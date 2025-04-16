package com.example.tutorm4

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

//Parcelize digunakan untuk mengirimkan object dalam arguments
@Parcelize
data class Mahasiswa(
    val nrp: String,
    var nama: String,
    var jurusan: Int
) : Parcelable