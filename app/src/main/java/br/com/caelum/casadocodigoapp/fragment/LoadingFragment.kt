package br.com.caelum.casadocodigoapp.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.caelum.casadocodigoapp.R
import br.com.caelum.casadocodigoapp.vm.LivroViewModel
import org.koin.android.viewmodel.ext.android.sharedViewModel

class LoadingFragment : Fragment() {

    private val viewModel: LivroViewModel by sharedViewModel()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        viewModel.buscaLivros()

        return inflater.inflate(R.layout.loading_fragment, container, false)
    }
}