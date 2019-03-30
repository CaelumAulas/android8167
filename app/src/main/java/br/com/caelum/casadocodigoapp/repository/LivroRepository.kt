package br.com.caelum.casadocodigoapp.repository

import br.com.caelum.casadocodigoapp.modelo.Livro

class LivroRepository {

    val livros = arrayListOf<Livro>(
        Livro("Kotlin", dataPublicacao = "15/12/2019"),
        Livro("Android", dataPublicacao = "15/12/2019"),
        Livro("Ruby", dataPublicacao = "15/12/2019"),
        Livro("Sapiens", dataPublicacao = "15/12/2019"),
        Livro("Destiny", dataPublicacao = "15/12/2019"),
        Livro("Java", dataPublicacao = "15/12/2019"),
        Livro("IOS", dataPublicacao = "15/12/2019"),
        Livro("Go", dataPublicacao = "15/12/2019"),
        Livro("Python", dataPublicacao = "15/12/2019"),
        Livro("C#", dataPublicacao = "15/12/2019")
    )


}