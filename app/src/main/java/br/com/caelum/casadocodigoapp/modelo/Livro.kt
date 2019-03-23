package br.com.caelum.casadocodigoapp.modelo

data class Livro(
    val titulo: String,
    val descricao: String? = null,
    val imagem: String? = null,
    val isbn: String = "",
    val precoFisico: Double = 0.0,
    val precoVirtual: Double = 0.0,
    val precoAmbos: Double = 0.0,
    val dataPublicacao: String = "",
    val numeroPaginas: String = "",
    val id: Long = 0,
    val autores: List<Autor> = emptyList()

)