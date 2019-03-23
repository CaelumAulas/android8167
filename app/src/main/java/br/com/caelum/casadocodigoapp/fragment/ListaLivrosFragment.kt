package br.com.caelum.casadocodigoapp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caelum.casadocodigoapp.R
import br.com.caelum.casadocodigoapp.adapter.LivroAdapter
import br.com.caelum.casadocodigoapp.modelo.Livro
import kotlinx.android.synthetic.main.lista_livros_fragment.view.*

class ListaLivrosFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.lista_livros_fragment, container, false)

        val livros = arrayListOf<Livro>(
            Livro("Kotlin"),
            Livro("Android"),
            Livro("Ruby"),
            Livro("Sapiens"),
            Livro("Destiny"),
            Livro("Java"),
            Livro("IOS"),
            Livro("Go"),
            Livro("Python"),
            Livro("C#")
        )


        view.listaLivros.adapter = LivroAdapter(livros)

        view.listaLivros.layoutManager = LinearLayoutManager(context)

        return view

    }
}