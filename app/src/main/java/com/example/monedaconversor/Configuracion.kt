package com.example.monedaconversor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Configuracion : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)

        val Aceptar:Button=findViewById(R.id.btObtener)
        val NuevoEuro: EditText=findViewById(R.id.EditModi)

        Aceptar.setOnClickListener {


            val NuevaDivisa: Float = NuevoEuro.text.toString().toFloat() // recoje los datos ingresados por el usuario
            val Guardar = getSharedPreferences("GUARDAR", MODE_PRIVATE)
            val Editar = Guardar.edit()
            Editar.putFloat("DivisaModificada",NuevaDivisa)
            Editar.commit()

            Toast.makeText(this,"El Nuevo Valor de La Divisa Es "+ NuevaDivisa, Toast.LENGTH_LONG).show()

            val configu: Intent = Intent(this,MainActivity::class.java)
            startActivity(configu)
        }
    }
}