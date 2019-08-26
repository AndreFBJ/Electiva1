package com.example.guessingnumber

import kotlin.random.Random
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import java.util.*

class MainActivity : AppCompatActivity() {

    var randomNumber = (0..1000).random()
    val numeroAleatorio = Random
    var createrandom = numeroAleatorio.nextInt(0,10)
    var attempts=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_number_guess)
    }

    fun myButtonPlay(view: View) {
        val number = findViewById<EditText>(R.id.editTextEnterNumber).getText().toString().toInt()

        if(number == createrandom) {
            Toast.makeText(this, "Felicidades el numero era $number, ganaste", Toast.LENGTH_LONG).show()
            Toast.makeText(this, "El numero de intentos fueron $attempts", Toast.LENGTH_LONG).show()
        }
        else if (number < createrandom) {
            Toast.makeText(this, "Tu numero es muy pequeño al que adivine", Toast.LENGTH_LONG).show()
            attempts += 1
        }
        else if (number > createrandom) {
            Toast.makeText(this, "Tu numero es muy grande al que adivine", Toast.LENGTH_LONG).show()
            attempts += 1
        }
    }

    fun theButtonReset (view: View){

        setContentView(R.layout.activity_number_guess)

        fun reiniciar (attempts :Int, createrandom :Int) :Int{

            this.attempts=0
            this.createrandom=numeroAleatorio.nextInt(0,10)

            return attempts;createrandom
        }

        reiniciar(attempts,createrandom)
    }
}
