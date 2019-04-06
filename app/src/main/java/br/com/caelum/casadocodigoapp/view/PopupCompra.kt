package br.com.caelum.casadocodigoapp.view

import android.content.Context
import android.support.v7.app.AlertDialog
import android.view.LayoutInflater
import android.widget.RadioGroup
import br.com.caelum.casadocodigoapp.R
import br.com.caelum.casadocodigoapp.modelo.Carrinho
import br.com.caelum.casadocodigoapp.modelo.Item
import br.com.caelum.casadocodigoapp.modelo.Livro

class PopupCompra(private val carrinho: Carrinho) {


    fun exibe(livro: Livro, context: Context) {

        val group = getRadioGroup(context)

        AlertDialog.Builder(context)
            .setTitle("Escolha qual o tipo de livro você quer comprar:")
            .setView(group)
            .setPositiveButton("Adicionar") { _, _ ->

                val item = pegaItemSelecionado(livro, group)

                carrinho.adiciona(item)

            }
            .setNegativeButton("Cancelar", null)
            .show()
    }

    private fun getRadioGroup(context: Context): RadioGroup {
        val inflater = LayoutInflater.from(context)

        val tipos = inflater.inflate(R.layout.tipos_livro, null, false)

        val group = tipos as RadioGroup
        return group
    }

    private fun pegaItemSelecionado(
        livro: Livro,
        group: RadioGroup
    ): Item {
        var item: Item = Item.LivroVirtualEFisico(livro)

        when (group.checkedRadioButtonId) {
            R.id.radioFisico -> {
                item = Item.LivroFisico(livro)
            }
            R.id.radioVirtual -> {
                item = Item.LivroVirtual(livro)
            }
            R.id.radioAmbos -> {
                item = Item.LivroVirtualEFisico(livro)
            }


        }
        return item
    }

}
