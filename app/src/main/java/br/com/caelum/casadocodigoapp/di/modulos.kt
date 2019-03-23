package br.com.caelum.casadocodigoapp.di

import br.com.caelum.casadocodigoapp.repository.LivroRepository
import br.com.caelum.casadocodigoapp.vm.LivroViewModel
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


private val repositories = module {

    single { LivroRepository() }
}


private val viewModels = module {


    viewModel { LivroViewModel(get()) }

}


val modulos = arrayListOf(repositories, viewModels)