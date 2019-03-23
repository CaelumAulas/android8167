package br.com.caelum.casadocodigoapp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caelum.casadocodigoapp.R
import br.com.caelum.casadocodigoapp.vm.LivroViewModel
import kotlinx.android.synthetic.main.detalhes_fragment.view.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class DetalhesDoLivroFragment : Fragment() {


    private val viewModel: LivroViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val livro = viewModel.livro.value!!

        val view = inflater.inflate(R.layout.detalhes_fragment, container, false)

        view.nome_livro_detalhes.text = livro.titulo

        view.desc_livro_detalhe.text = livro.descricao

        view.data_pub_livro_detalhe.text = livro.dataPublicacao

        view.livro_isbn_detalhe.text = livro.isbn

        view.num_pag_livro_detalhe.text = livro.numeroPaginas

        view.autores_livro_detalhes.text = "${livro.autores.map { autor -> autor.nome }}"


        return view

    }


}
