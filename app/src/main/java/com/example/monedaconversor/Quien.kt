package com.example.monedaconversor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Quien : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quien)

        val volver: Button = findViewById(R.id.volver)

        volver.setOnClickListener {

            val volver: Intent = Intent(this,MainActivity::class.java)
            startActivity(volver)
        }
    }


}


