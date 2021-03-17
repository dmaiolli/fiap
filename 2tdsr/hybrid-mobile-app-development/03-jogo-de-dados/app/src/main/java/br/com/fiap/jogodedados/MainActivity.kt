package br.com.fiap.jogodedados

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    // Nesse formato ele pode voltar a ser nulo depois de ser inicializado
    // var imgJogador01 : ImageView? = null;

    // Nesse formato ele só é nulo até inicializar, depois não pode ser nulo
    lateinit var imgJogador01 : ImageView;
    lateinit var imgJogador02 : ImageView;

    val imgs = intArrayOf(
        R.drawable.d01,
        R.drawable.d02,
        R.drawable.d03,
        R.drawable.d04,
        R.drawable.d05,
        R.drawable.d06,
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Buscando os ids no nosso XML
        imgJogador01 = findViewById(R.id.imgJogador01);
        imgJogador02 = findViewById(R.id.imgJogador02);
    }

    fun jogarDados(view: View) {
        val dadoJogador01 = Random.nextInt(imgs.size);
        val dadoJogador02 = Random.nextInt(imgs.size);

        imgJogador01.setImageResource( imgs[dadoJogador01] )
        imgJogador02.setImageResource( imgs[dadoJogador02] )

        quemVenceu(dadoJogador01, dadoJogador02);
    }

    fun quemVenceu(jogador01 : Int, jogador02 : Int) {
        var msg = "Deu empate";

        if (jogador01 > jogador02) {
            msg = "Jogador 01 venceu"
        } else if (jogador01 < jogador02) {
            msg = "Jogador 02 venceu"
        }

        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}