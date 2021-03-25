package br.com.fiap.cp01.rm86487_rm84432

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast

lateinit var imgView: ImageView

var imagemAtual = 0 // guarda a posição que a imagem está atualmente
val imgs = intArrayOf(
        R.drawable.p0,
        R.drawable.p1,
        R.drawable.p2,
        R.drawable.p3,
        R.drawable.p4,
        R.drawable.p5,
        R.drawable.p6,
)

class MainActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imgView = findViewById(R.id.imgView);
    } // onCreate()

    fun avancarImagem(view: View) {
        var proximaImagem = imagemAtual + 1

        // Valida se tem próxima imagem
        if( proximaImagem >= imgs.size) {
            Toast.makeText(this, "Não temos mais imagens", Toast.LENGTH_SHORT).show()
            return
        } // if

        // Ajusta o indíce que aponta para a próxima imagem
        imagemAtual++
        imgView.setImageResource(imgs[imagemAtual])

        Toast.makeText(this, "Você está na imagem ${imagemAtual + 1}", Toast.LENGTH_SHORT).show()
    } // avancarImagem()

    fun recuarImagem(view: View) {

        // Valida se a imagem atual tem imagem antes
        if (imagemAtual <= 0) {
            Toast.makeText(this, "Não temos mais imagens", Toast.LENGTH_SHORT).show()
            return
        } // if

        Toast.makeText(this, "Você está na imagem ${imagemAtual}", Toast.LENGTH_SHORT).show()

        // Ajuda o indíce que aponta para a próxima imagem recuando
        imagemAtual--
        imgView.setImageResource(imgs[imagemAtual])

    } // recuarImagem()

}// main