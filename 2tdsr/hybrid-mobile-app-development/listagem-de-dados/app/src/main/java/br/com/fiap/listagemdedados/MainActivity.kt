package br.com.fiap.listagemdedados

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    val paises = arrayOf(
        "Alemanha",
        "Argentina",
        "Afeganistão",
        "Bélgica",
        "Bolívia",
        "Brasil",
        "Camarões",
        "Canadá",
        "Colômbia",
        "Djibouti",
        "Dinamarca",
        "Dominica",
        "Espanha",
        "Equador",
        "Estônia",
        "Finlândia",
        "França",
        "Filipinas",
    )

    lateinit var lstPaises : ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lstPaises = findViewById(R.id.lstPaises)
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, paises)

        lstPaises.adapter = adapter
        lstPaises.setOnItemClickListener { parent, view, position, id ->

            // Toast.makeText(this, paises[position], Toast.LENGTH_SHORT).show()
            val it = Intent(this, PaisActivity::class.java)

            it.putExtra("nomePais", paises[position])
            it.putExtra("posicao", position)

            startActivity(it)
        }
    }
}