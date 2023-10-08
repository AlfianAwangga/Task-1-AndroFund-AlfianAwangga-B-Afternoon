package com.example.androidfundamtental1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class FormActivity : AppCompatActivity(), View.OnClickListener {
    //deklarasi variabel editText
    private lateinit var et_nama : EditText
    private lateinit var et_nim : EditText
    private lateinit var et_prodi : EditText
    private lateinit var et_jurusan : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form)

        //inisialisasi variabel editText
        et_nama = findViewById(R.id.et_nama)
        et_nim = findViewById(R.id.et_nim)
        et_prodi = findViewById(R.id.et_prodi)
        et_jurusan = findViewById(R.id.et_jurusan)

        //onClick button simpan
        val btn_simpan : Button = findViewById(R.id.btn_simpan)
        btn_simpan.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_simpan -> {
                //get teks inputan pada editText
                val nama = et_nama.text.toString()
                val nim = et_nim.text.toString()
                val prodi = et_prodi.text.toString()
                val jurusan = et_jurusan.text.toString()

                //intent form to data activity
                val intent = Intent(this@FormActivity, DataActivity::class.java)

                //send data menggunakan parcelable
                intent.putExtra("mahasiswa", Mahasiswa(nama, nim, prodi, jurusan))
                startActivity(intent)
            }
        }
    }
}