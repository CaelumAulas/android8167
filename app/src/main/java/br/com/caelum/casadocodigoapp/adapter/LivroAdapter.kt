package br.com.caelum.casadocodigoapp.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caelum.casadocodigoapp.R
import br.com.caelum.casadocodigoapp.modelo.Livro
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_livro.view.*

class LivroAdapter(val livros: List<Livro>, val listener: LivroListener) :
    RecyclerView.Adapter<LivroAdapter.LivroViewHolder>() {


    override fun getItemCount(): Int {
        return livros.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): LivroViewHolder {

        val inflater = LayoutInflater.from(parent.context)

        val view = inflater.inflate(R.layout.item_livro, parent, false)

        return LivroViewHolder(view)
    }

    override fun onBindViewHolder(holder: LivroViewHolder, position: Int) {
        val livro = livros[position]

        holder.bind(livro, listener)

    }

    class LivroViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        private val nome = view.item_nome

        fun bind(livro: Livro, listener: LivroListener) {

            view.setOnClickListener {
                listener.onClick(livro)
            }
            nome.text = livro.titulo
        }
    }

    interface LivroListener {

        fun onClick(livro: Livro)
    }

}
