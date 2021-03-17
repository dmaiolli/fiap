package br.com.fiap.calculadorafiap

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var edtNumero01 : EditText;
    lateinit var edtNumero02 : EditText;
    lateinit var txtResultado : TextView;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edtNumero01 = findViewById(R.id.edtNumero01);
        edtNumero02 = findViewById(R.id.edtNumero02);
        txtResultado = findViewById(R.id.txtResultado);
    } // fun onCreate

    fun somar(view: View) {
        val strNumero01 = edtNumero01.text.toString();
        val strNumero02 = edtNumero02.text.toString();

        if ( ! validar(strNumero01, strNumero02) ) {
            return
        } // if

        try {
            val numero01 = strNumero01.toInt();
            val numero02 = strNumero02.toInt();

            val soma = numero01 + numero02;

            exibeResultado("${soma}", txtResultado, true)
        } catch ( e: Exception ) {
            Toast.makeText(
                    this,
                    "Não foi possível efetuar a soma",
                    Toast.LENGTH_SHORT
            ).show()
        } // try

    } // fun soma

    fun validar(numero01 : String, numero02 : String): Boolean {
        if ( numero01.trim().isEmpty() ) {
            Toast.makeText(
                    this,
                    "Informe corretamente o primeiro número inteiro",
                    Toast.LENGTH_SHORT
            ).show()

            exibeResultado("Informe corretamente o primeiro numero inteiro", txtResultado, false)

            return false
        } // if

        if ( numero02.trim().isEmpty() ) {
            Toast.makeText(
                    this,
                    "Informe corretamente o segundo número inteiro",
                    Toast.LENGTH_SHORT
            ).show()

            exibeResultado("Informe corretamente o segundo numero inteiro", txtResultado, false)

            return false
        } // if

        return true
    } // fun validar

    fun exibeResultado(mensagem : String, txtView: TextView, passou : Boolean) {
        txtView.setText("O resultado da soma é de: ${mensagem}");

        if ( passou == false ) {
            txtView.setTextColor(Color.parseColor("#ff0000"));
            txtView.setText(mensagem);
            return
        } // if

        txtView.setTextColor(Color.parseColor("#0aad3f"));

    } // fun exibeResultado

}// main