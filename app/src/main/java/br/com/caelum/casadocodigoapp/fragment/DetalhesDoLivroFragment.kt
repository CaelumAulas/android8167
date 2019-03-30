package br.com.caelum.casadocodigoapp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caelum.casadocodigoapp.R
import br.com.caelum.casadocodigoapp.vm.LivroViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.detalhes_fragment.view.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class DetalhesDoLivroFragment : Fragment() {


    private val viewModel: LivroViewModel by sharedViewModel()
    private val livro by lazy { viewModel.livro.value!! }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activity = activity as AppCompatActivity

        activity.supportActionBar?.setDisplayHomeAsUpEnabled(true)

        activity.title = livro.titulo
        activity.supportActionBar?.subtitle = livro.dataPublicacao
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.detalhes_fragment, container, false)

        Picasso.get().load(livro.imagem).fit().into(view.foto_livro_detalhes)

        view.nome_livro_detalhes.text = livro.titulo

        view.desc_livro_detalhe.text = livro.descricao

        view.data_pub_livro_detalhe.text = livro.dataPublicacao

        view.livro_isbn_detalhe.text = livro.isbn

        view.num_pag_livro_detalhe.text = livro.numeroPaginas

        view.autores_livro_detalhes.text = "${livro.autores.map { autor -> autor.nome }}"


        return view

    }


}
