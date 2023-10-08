package com.example.androidfundamtental1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //onClick button start
        val btn_start : Button = findViewById(R.id.btn_start)
        btn_start.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id) {
            R.id.btn_start -> {
                //intent main to form activity
                val intent = Intent(this@MainActivity, FormActivity::class.java)
                startActivity(intent)
            }
        }
    }
}