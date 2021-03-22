package br.com.fiap.manipulandoimagens

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var imgView : ImageView;

    val images = intArrayOf(
        R.drawable.person1,
        R.drawable.person2,
        R.drawable.person3,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgView = findViewById(R.id.imgView);
    }

    fun sorteiaImagem(view: View) {
        val sorteia = Random.nextInt( images.size )
        
        imgView.setImageResource( images[sorteia] )
    }
}