package com.example.bloco_de_anotacoes
import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
class AnotacaoPreferencia(context: Context) {
    private val preferences: SharedPreferences
    private val NOME_ARQUIVO = "anotacao.preferencia"
    private val editor: Editor
    private val CHAVE_NOME = "nome"

    fun salvarAnotacao(anotacao: String?) {
        editor.putString(CHAVE_NOME, anotacao)
        editor.commit()
    }
    fun recuperarAnotacao(): String? {
        return  preferences.getString(CHAVE_NOME,  "")
    }
    fun main(args: Array<String>) {
        var email: String?
        email= null
        println(email)
    }
    init {
        preferences = context.getSharedPreferences(NOME_ARQUIVO ,  0)
        editor = preferences.edit()
    }

}