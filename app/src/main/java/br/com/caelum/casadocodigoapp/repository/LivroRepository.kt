package br.com.caelum.casadocodigoapp.repository

import br.com.caelum.casadocodigoapp.clients.LivroApi

class LivroRepository(private val api: LivroApi) {

    suspend fun lista() = api.listar()


}