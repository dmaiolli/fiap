package br.com.fiap.palindromos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var edtFrase : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtFrase = findViewById(R.id.edtFrase);
    }

    /**
     * Evento disparado pelo botão verificar
     */
    fun verificar(view: View) {
        var txt = edtFrase.text.toString().trim().toLowerCase();

        if ( txt.isEmpty() ) {
            toast("Informe corretamente uma palavra ou frase")
            return
        }

        val txtInvertido = txt.reversed();

        val frase = if ( txt.equals(txtInvertido) ) "É um palindromo" else "Não é um palindromo"

        toast(frase);
    }

    /**
     * Remove caracteres especiais de uma string
     *
     * @param txt
     * @return String
     */
    fun removeCaracteresEspeciais( txt : String ): String{
        var txt = txt.replace("ã", "a")
            .replace("á", "a")
            .replace("à", "a");

        var regex = "[^a-z]".toRegex();

        return regex.replace(txt, "")
    }

    /**
     * Exibe um toast padronizado para o APP
     *
     * @param frase
     */
    fun toast( frase: String ) {
        Toast.makeText(this, frase, Toast.LENGTH_SHORT).show();
    }
}