package br.com.caelum.casadocodigoapp.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.com.caelum.casadocodigoapp.R
import br.com.caelum.casadocodigoapp.modelo.Carrinho
import org.koin.android.ext.android.inject

class CarrinhoActivity : AppCompatActivity() {

    private val carrinho: Carrinho by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrinho)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.subtitle = "Total R$${carrinho.getValorTotal()}"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.carrinho_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.menu_carrinho_concluir -> {
                carrinho.limpa()
                Toast.makeText(this, "Compra concluida com sucesso", Toast.LENGTH_LONG).show()
                finish()
            }
            android.R.id.home -> {
                finish()
            }

            else -> {
            }
        }
        return true
    }
}