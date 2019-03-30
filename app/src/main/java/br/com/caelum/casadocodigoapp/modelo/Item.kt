package br.com.caelum.casadocodigoapp.modelo

sealed class Item(
    val livro: Livro,
    val tipoDeLivro: TipoDeLivro
) {
    fun getValor(): Double = when (tipoDeLivro) {
        TipoDeLivro.AMBOS -> livro.precoAmbos
        TipoDeLivro.FISICO -> livro.precoFisico
        else -> livro.precoVirtual
    }


    class LivroFisico(livro: Livro) : Item(livro, TipoDeLivro.FISICO)
    class LivroVirtual(livro: Livro) : Item(livro, TipoDeLivro.VIRTUAL)
    class LivroVirtualEFisico(livro: Livro) : Item(livro, TipoDeLivro.AMBOS)
}

enum class TipoDeLivro {
    FISICO, VIRTUAL, AMBOS
}
