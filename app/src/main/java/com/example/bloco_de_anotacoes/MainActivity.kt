package com.example.bloco_de_anotacoes

import android.os.Bundle
import  android.widget.EditText
import  com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import com.example.bloco_de_anotacoes.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private var preferencias: AnotacaoPreferencia? = null
    private var editAnotacao: EditText? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val editAnotacao: EditText = findViewById(R.id.blocoAnotacao)
        val preferencias = AnotacaoPreferencia(applicationContext)
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            val textoRecuperado = editAnotacao.getText().toString()
            if (textoRecuperado == "") {
                Snackbar.make(view, "Digite uma anotação para ser salva ", Snackbar.LENGTH_LONG)
                    .show()
            } else {
                preferencias!!.salvarAnotacao(textoRecuperado)
                Snackbar.make(view, "Anotação salvar com sucesso", Snackbar.LENGTH_LONG)
                    .show()
            }

        }
        //recuperar a anotacao salva
        val anotacao = preferencias.recuperarAnotacao()
        if(anotacao != ""){
            editAnotacao.setText(anotacao)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}
   /* override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }*/







