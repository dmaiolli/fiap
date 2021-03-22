package br.com.fiap.manipulandoimagens

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var imgView : ImageView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgView = findViewById(R.id.imgView);
    }

    fun sorteiaImagem(view: View) {
        // Equivalente ao switch/case
        val imagem = when ( view.id ) {
            R.id.btnPerson01 -> R.drawable.person1
            R.id.btnPerson02 -> R.drawable.person2
            else -> R.drawable.person3
        }

        imgView.setImageResource(imagem);
    }
}