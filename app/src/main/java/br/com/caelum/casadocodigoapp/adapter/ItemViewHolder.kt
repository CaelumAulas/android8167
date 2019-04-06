package br.com.caelum.casadocodigoapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import br.com.caelum.casadocodigoapp.R
import br.com.caelum.casadocodigoapp.infra.CarregadorDeFoto
import br.com.caelum.casadocodigoapp.modelo.Item
import com.squareup.picasso.Picasso

sealed class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val nome: TextView = view.findViewById(R.id.nomeItem)
    private val valor: TextView = view.findViewById(R.id.valorItem)
    private val imagem: ImageView = view.findViewById(R.id.fotoItem)

    fun popula(item: Item) {
        nome.text = item.livro.titulo

        valor.text = "R$ ${item.getValor()}"

        CarregadorDeFoto.carrega(item.livro.imagem!!, imagem)

    }

    class ItemFisicoViewHolder(view: View) : ItemViewHolder(view)
    class ItemAmbosViewHolder(view: View) : ItemViewHolder(view)
    class ItemVirtualViewHolder(view: View) : ItemViewHolder(view)

}
