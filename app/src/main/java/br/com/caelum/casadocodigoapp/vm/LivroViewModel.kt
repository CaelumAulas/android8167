package br.com.caelum.casadocodigoapp.vm

import android.arch.lifecycle.ViewModel
import br.com.caelum.casadocodigoapp.repository.LivroRepository

class LivroViewModel(private val repository: LivroRepository) : ViewModel() {

    fun getLivros() = repository.livros
}