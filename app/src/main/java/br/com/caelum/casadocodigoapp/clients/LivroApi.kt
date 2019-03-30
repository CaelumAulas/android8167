package br.com.caelum.casadocodigoapp.clients

import br.com.caelum.casadocodigoapp.modelo.Livro
import kotlinx.coroutines.Deferred
import retrofit2.Retrofit
import retrofit2.http.GET

class LivroApi(retrofit: Retrofit) {

    private val service by lazy { retrofit.create(LivroService::class.java) }


    suspend fun listar(): List<Livro> {

        val listaDeLivros = service.listar().await()

        return listaDeLivros.livros
    }



    interface LivroService {

        @GET("listarLivros?indicePrimeiroLivro=0&qtdLivros=20")
        fun listar(): Deferred<LivrosDTO>

    }
}