package com.example.androidfundamtental1

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Mahasiswa(
    val nama : String,
    val nim : String,
    val prodi : String,
    val jurusan : String
) : Parcelable
