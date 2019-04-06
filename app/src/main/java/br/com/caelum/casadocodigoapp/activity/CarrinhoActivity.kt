package br.com.caelum.casadocodigoapp.activity

import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import br.com.caelum.casadocodigoapp.R
import br.com.caelum.casadocodigoapp.adapter.ItemAdapter
import br.com.caelum.casadocodigoapp.adapter.ItemListener
import br.com.caelum.casadocodigoapp.modelo.Carrinho
import br.com.caelum.casadocodigoapp.modelo.Item
import kotlinx.android.synthetic.main.activity_carrinho.*
import org.koin.android.ext.android.inject

class CarrinhoActivity : AppCompatActivity(), ItemListener {


    private val carrinho: Carrinho by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrinho)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.subtitle = "Total R$${carrinho.getValorTotal()}"

        listaItens.adapter = ItemAdapter(carrinho.getItens(), this)
        listaItens.layoutManager = LinearLayoutManager(this)

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

    override fun onClick(item: Item, position: Int) {

        AlertDialog.Builder(this)
            .setTitle("Deseja remover esse item do carrinho ?")
            .setMessage("${item.livro.titulo} : ${item.tipoDeLivro}")
            .setPositiveButton("Sim") { _, _ ->
                carrinho.remove(item)

                listaItens.adapter?.notifyItemRemoved(position)
                supportActionBar?.subtitle = "Total R$${carrinho.getValorTotal()}"


            }
            .setNegativeButton("Não", null)
            .show()


    }
}