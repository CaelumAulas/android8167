package br.com.caelum.casadocodigoapp.vm

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import br.com.caelum.casadocodigoapp.modelo.Livro
import br.com.caelum.casadocodigoapp.repository.LivroRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class LivroViewModel(private val repository: LivroRepository) : ViewModel() {

    val livro: MutableLiveData<Livro> = MutableLiveData()
    val livros: MutableLiveData<List<Livro>> = MutableLiveData()
    val erro: MutableLiveData<Exception> = MutableLiveData()

    fun buscaLivros() {
        GlobalScope.launch(Dispatchers.IO) {
            try {
                val lista = repository.lista()

                launch(Dispatchers.Main) {
                    if (erro.value != null) {
                        erro.value = null
                    }
                    livros.value = lista
                }
            } catch (e: Exception) {
                launch(Dispatchers.Main) {
                    erro.value = e
                }
            }
        }

    }

    fun seleciona(selecionado: Livro) {

        livro.postValue(selecionado)

    }

    fun limpaLivro() {

        livro.value = null
    }
}