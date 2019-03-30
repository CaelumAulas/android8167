package br.com.caelum.casadocodigoapp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caelum.casadocodigoapp.R
import br.com.caelum.casadocodigoapp.adapter.LivroAdapter
import br.com.caelum.casadocodigoapp.modelo.Livro
import br.com.caelum.casadocodigoapp.vm.LivroViewModel
import kotlinx.android.synthetic.main.lista_livros_fragment.view.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class ListaLivrosFragment : Fragment(), LivroAdapter.LivroListener {



    private val livroViewModel: LivroViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.lista_livros_fragment, container, false)

        val livros = livroViewModel.livros.value!!

        view.listaLivros.adapter = LivroAdapter(livros, this)

        view.listaLivros.layoutManager = LinearLayoutManager(context)

        return view

    }

    override fun onResume() {
        super.onResume()
        val activity = activity as AppCompatActivity
        activity.supportActionBar?.setDisplayHomeAsUpEnabled(false)
        activity.title = "Lista de Livros"
        activity.supportActionBar?.subtitle = ""
    }

    override fun onClick(livro: Livro) {

        livroViewModel.seleciona(livro)

    }

}