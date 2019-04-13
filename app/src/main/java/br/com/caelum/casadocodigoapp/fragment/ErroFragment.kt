package br.com.caelum.casadocodigoapp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caelum.casadocodigoapp.R
import br.com.caelum.casadocodigoapp.vm.LivroViewModel
import kotlinx.android.synthetic.main.erro_fragment.view.*
import org.koin.android.viewmodel.ext.android.sharedViewModel

class ErroFragment : Fragment() {


    private val viewModel: LivroViewModel by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val exception = viewModel.erro.value!!


        val view = inflater.inflate(R.layout.erro_fragment, container, false)

        view.mensagemErro.text = exception.message

        view.tentarNovamente.setOnClickListener {
            viewModel.buscaLivros()
        }

        return view


    }
}
