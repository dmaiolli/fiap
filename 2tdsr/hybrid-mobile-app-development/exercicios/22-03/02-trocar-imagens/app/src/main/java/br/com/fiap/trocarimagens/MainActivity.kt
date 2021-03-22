package br.com.fiap.trocarimagens

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView

class MainActivity : AppCompatActivity() {

    lateinit var imgView1 : ImageView;
    lateinit var imgView2 : ImageView;

    var inverter = false;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgView1 = findViewById(R.id.imgView1);
        imgView2 = findViewById(R.id.imgView2);
    }

    fun trocarImagens(view: View) {
        // Aqui estamos invertendo, se for true vai se tornar false, e se for false se tornará true
        this.inverter = !this.inverter;

        /* if ( inverter ) {
            imgView1.setImageResource( R.drawable.person1 );
            imgView2.setImageResource( R.drawable.person2 );
        } else {
            imgView1.setImageResource( R.drawable.person2 );
            imgView2.setImageResource( R.drawable.person1 );
        } */

        val img01 = if (inverter) R.drawable.person1 else R.drawable.person2;
        val img02 = if (inverter) R.drawable.person2 else R.drawable.person1;

        imgView1.setImageResource(img01);
        imgView2.setImageResource(img02);
    }
}