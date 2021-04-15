package br.com.fiap.cp02.RM86487_RM84281_RM84432_RM84361_RM85631

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var rdgMateriais : RadioGroup

    lateinit var chkFrete : CheckBox

    lateinit var edtMedida : EditText

    lateinit var txtResultado : TextView

    val VALOR_PISO_BRANCO = 24.90
    val VALOR_PISO_ALBANIA = 11.90
    val VALOR_PORCELANATO_PERLATO = 39.90
    val VALOR_REVESTIMENTO_MOSAICO = 16.90

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rdgMateriais = findViewById(R.id.rdgMateriais)
        chkFrete = findViewById(R.id.chkFrete)
        edtMedida = findViewById(R.id.edtMedida)
        txtResultado = findViewById(R.id.txtResultado)
    } // onCreate()

    /**
     * Evento disparado pelo botão CALCULAR
     */
    fun calcularValor(view: View) {
        val material = rdgMateriais.checkedRadioButtonId
        val strVlMedida = edtMedida.text.toString()
        var resultado = 0.00

        if( ! validarValor(strVlMedida) ) {
            return
        } // if

        var strValidada = substituiCaractere( strVlMedida )
        var vlMedida = strValidada.toFloat()

        when( material ) {
            R.id.rdbPisoBranco -> resultado = VALOR_PISO_BRANCO * vlMedida
            R.id.rdbPisoAlbania -> resultado = VALOR_PISO_ALBANIA * vlMedida
            R.id.rdbPorcelanatoPerlato -> resultado = VALOR_PORCELANATO_PERLATO * vlMedida
            R.id.rdbRevestimentoMosaico -> resultado = VALOR_REVESTIMENTO_MOSAICO * vlMedida
        } // when

        if ( chkFrete.isChecked ) {
            resultado *= 1.3
        } // if

        val resultadoArredondado = "%.2f".format(resultado)
        txtResultado.setText("R$ ${resultadoArredondado}")
    } // calcularValor()

    /**
     * Substitui vírgula para ponto
     *
     * @param strValorMedida
     * @return String
     */
    fun substituiCaractere( strValorMedida: String ) : String {

        if( strValorMedida.contains(",") ) {
            return strValorMedida.replace(",", ".")
        } // if

        return strValorMedida
    } // substituiCaractere()

    /**
     * Verifica se o valor passado como parâmetro é válido
     *
     * @param strValorMedida
     * @return Boolean
     */
    fun validarValor(strValorMedida: String): Boolean {

        val regex = "[/wÀ-úa-zA-Z]+".toRegex()
        if ( strValorMedida.contains(regex) ) {
            exibeToast("Informe apenas números")

            return false
        } // if

        if ( strValorMedida.trim().isEmpty() ) {
            exibeToast("Informe corretamente a medida em m2")

            return false

        } // if

        return true
    } // validar()

    /**
     * Exibe toast padronizado
     *
     * @param strMensagem
     */
    fun exibeToast( strMensagem : String ) {
        Toast.makeText(this, strMensagem, Toast.LENGTH_SHORT).show()
    } // exibeToast()


}