package com.example.androidfundamtental1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class HomeActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val data_nama : TextView = findViewById(R.id.tv_home_nama)
        val data_nim : TextView = findViewById(R.id.tv_home_nim)
        val data_prodi : TextView = findViewById(R.id.tv_home_prodi)
        val welcome_nama : TextView = findViewById(R.id.tv_welcome_nama)

        val nama = intent.getParcelableExtra<Mahasiswa>("mahasiswa")?.nama
        val nim = intent.getParcelableExtra<Mahasiswa>("mahasiswa")?.nim
        val prodi = intent.getParcelableExtra<Mahasiswa>("mahasiswa")?.prodi

        //set text
        data_nama.text = nama
        data_nim.text = nim
        data_prodi.text = prodi
        welcome_nama.text = nama

        val btn_light : Button = findViewById(R.id.btn_light)
        val btn_dark : Button = findViewById(R.id.btn_dark)
        val btn_back : Button = findViewById(R.id.btn_back)

        btn_light.setOnClickListener(this)
        btn_dark.setOnClickListener(this)
        btn_back.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_light -> {
                gantiFragment(FirstFragment())
            }
            R.id.btn_dark -> {
                gantiFragment(SecondFragment())
            }
            R.id.btn_back -> {
                val intent = Intent(this@HomeActivity, FormActivity::class.java)
                startActivity(intent)
            }
        }
    }
    private fun gantiFragment(fragment : Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.relative, fragment)
        fragmentTransaction.commit()
    }
}