package br.com.caelum.casadocodigoapp.modelo

import com.google.gson.annotations.SerializedName

data class Livro(
    @SerializedName("nomeLivro") val titulo: String,
    @SerializedName("descricaoLivro") val descricao: String? = null,
    @SerializedName("imagemUrl") val imagem: String? = null,
    val isbn: String = "",
    @SerializedName("valorFisico") val precoFisico: Double = 0.0,
    @SerializedName("valorVirtual") val precoVirtual: Double = 0.0,
    @SerializedName("valorAmbos") val precoAmbos: Double = 0.0,
    val dataPublicacao: String = "",
    val numeroPaginas: String = "",
    val id: Long = 0,
    val autores: List<Autor> = emptyList()

)