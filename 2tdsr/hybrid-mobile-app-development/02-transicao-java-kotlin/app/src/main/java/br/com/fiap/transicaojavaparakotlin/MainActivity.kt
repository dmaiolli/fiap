package br.com.fiap.transicaojavaparakotlin

import android.icu.number.IntegerWidth
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
// extends e implements = :, seguindo a ordem, primeiro o extends e depois o implements
// MainActivity : Extends1, Interface1, Interface2
class MainActivity : AppCompatActivity() {

    // override é obrigatório para sobrescrever classe
    // fun - definindo função
    //                          Variável: Tipo
    //                                  ? = pode ser desse tipo mas também pode ser nulo
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pessoa : Pessoas = Pessoas("Denys")

        // var = O valor pode ser alterado
        // val = Como se fosse constante ( imutavel )

        val pessoa2 = PessoaJava("Denysss", "denys@maiolli")
        pessoa2.nome
        pessoa2.nome = "Domingas"
    }

    fun soma(a : Int,  b : Int): Int {
        return a + b
    }
}

class Pessoa {
    // private var nome:String; Irá retornar erro desse jeito se não instanciarmos
    private var nome:String? = null
}

// Ja é o construtor e ja gera os gets/sets implicitamente
class Pessoas(val nome:String)
class PessoaEmail(val nome:String, val email:String)
