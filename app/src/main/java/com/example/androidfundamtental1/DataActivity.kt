package com.example.androidfundamtental1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class DataActivity : AppCompatActivity(), View.OnClickListener {
    //deklarasi variabel textView
    private lateinit var data_nama : TextView
    private lateinit var data_nim : TextView
    private lateinit var data_prodi : TextView
    private lateinit var data_jurusan : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data)

        //inisialisasi variabel textView
        data_nama = findViewById(R.id.tv_data_nama)
        data_nim = findViewById(R.id.tv_data_nim)
        data_prodi = findViewById(R.id.tv_data_prodi)
        data_jurusan = findViewById(R.id.tv_data_jurusan)

        //get data Parcelable
        val nama = intent.getParcelableExtra<Mahasiswa>("mahasiswa")?.nama
        val nim = intent.getParcelableExtra<Mahasiswa>("mahasiswa")?.nim
        val prodi = intent.getParcelableExtra<Mahasiswa>("mahasiswa")?.prodi
        val jurusan = intent.getParcelableExtra<Mahasiswa>("mahasiswa")?.jurusan

        //set text
        data_nama.text = nama
        data_nim.text = nim
        data_prodi.text = prodi
        data_jurusan.text = jurusan

        //onClick button home
        val btn_home : Button = findViewById(R.id.btn_home)
        btn_home.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_home -> {
                //intent data to home activity
                val intent = Intent(this@DataActivity, HomeActivity::class.java)
                intent.putExtra("mahasiswa", Mahasiswa(data_nama.text.toString(), data_nim.text.toString()
                    , data_prodi.text.toString(), data_jurusan.text.toString()) )
                startActivity(intent)
            }
        }
    }
}