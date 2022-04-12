package com.example.monedaconversor

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // val Saldo: EditText= findViewById(R.id.txtsaldo)
       // val total: TextView= findViewById(R.id.txtresultado)
        val convertir : Button = findViewById(R.id.btncon)

        convertir.setOnClickListener {


            val mantener: RadioButton = man
            val cambiar: RadioButton = cambiar


            if (mantener.isChecked) {
                NoCambiarDividar()


            } else if (cambiar.isChecked){

                modificarDivisa()

            }




        }



    }


    // funcion para hacer aparecer el menu

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.configuracion, menu)
        return true

    }
    // para cambiar la actividad desde el menu
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId){
            R.id.Configuracion -> {

                val configu: Intent = Intent(this,Configuracion::class.java)
                startActivity(configu)

                true
            }
            R.id.Quien -> {

                val configu: Intent = Intent(this, Quien::class.java)
                startActivity(configu)

                true
            }

            else ->super.onOptionsItemSelected(item)

        }

    }
    // funcion a ejecutarse  cuando no se quiere cambiar la divisa

    private  fun NoCambiarDividar(){
        val dol: Double=txtsaldo.text.toString().toDouble()
        val Total:TextView= txtresultado
        var ValorEuro : Double= 0.91

        val resultado: Double= dol * ValorEuro

        // resultados a decimales

        var resultadoDecimales = BigDecimal(resultado)
        resultadoDecimales= resultadoDecimales.setScale(2,RoundingMode.DOWN)

        Total.text= "$resultadoDecimales €"


    }
    // funcion para cambio de divisa

    private fun modificarDivisa(){

        val dol: Float=txtsaldo.text.toString().toFloat()
        val Total:TextView= txtresultado

        // hacemos el llamado de los datos de la actividad configuracion

        val Guardar = getSharedPreferences("GUARDAR", MODE_PRIVATE)
        val nuevadivisa= Guardar.getFloat("DivisaModificada", 0.0F)

        val resultado:Float = dol * nuevadivisa

        val resultado2 : Double = resultado.toDouble()

        // Resutado dos decimoarles

        var resultadoDecimales = BigDecimal(resultado2)
        resultadoDecimales= resultadoDecimales.setScale(2,RoundingMode.DOWN)

        Total.text= "$resultadoDecimales €"






    }








}


