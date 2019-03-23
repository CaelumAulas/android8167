package br.com.caelum.casadocodigoapp.vm

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.caelum.casadocodigoapp.modelo.Livro
import br.com.caelum.casadocodigoapp.repository.LivroRepository

class LivroViewModel(private val repository: LivroRepository) : ViewModel() {

    val livro: MutableLiveData<Livro> = MutableLiveData()

    fun getLivros() = repository.livros

    fun seleciona(selecionado: Livro) {

        livro.postValue(selecionado)

    }

    fun limpaLivro() {

        livro.value = null
    }
}