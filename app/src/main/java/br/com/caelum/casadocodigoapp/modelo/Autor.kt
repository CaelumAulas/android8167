package br.com.caelum.casadocodigoapp.modelo

import com.google.gson.annotations.SerializedName

data class Autor(
    @SerializedName("nomeAutor") val nome: String,
    @SerializedName("detalhesAutor") val detalhes: String,
    @SerializedName("imagemAutor") val imagem: String,
    @SerializedName("idAutor") val id: Long
)