package br.com.caelum.casadocodigoapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import br.com.caelum.casadocodigoapp.R
import br.com.caelum.casadocodigoapp.adapter.ItemViewHolder.*
import br.com.caelum.casadocodigoapp.modelo.Item
import br.com.caelum.casadocodigoapp.modelo.TipoDeLivro

class ItemAdapter(private val itens: List<Item>) : RecyclerView.Adapter<ItemViewHolder>() {

    override fun getItemCount(): Int {
        return itens.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        when (viewType) {
            1 -> {
                val view = inflater.inflate(R.layout.item_livro_fisico, parent, false)
                return ItemFisicoViewHolder(view)
            }
            2 -> {
                val view = inflater.inflate(R.layout.item_livro_virtual, parent, false)
                return ItemVirtualViewHolder(view)

            }
            else -> {
                val view = inflater.inflate(R.layout.item_livro_ambos, parent, false)
                return ItemAmbosViewHolder(view)
            }
        }


    }

    override fun getItemViewType(position: Int): Int = when (itens[position].tipoDeLivro) {
        TipoDeLivro.FISICO -> 1
        TipoDeLivro.VIRTUAL -> 2
        TipoDeLivro.AMBOS -> 3
    }


    override fun onBindViewHolder(viewHolder: ItemViewHolder, posicao: Int) {
        val item = itens[posicao]
        viewHolder.popula(item)
    }
}