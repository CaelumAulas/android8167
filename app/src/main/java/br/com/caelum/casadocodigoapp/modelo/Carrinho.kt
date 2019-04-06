package br.com.caelum.casadocodigoapp.modelo

import java.math.BigDecimal
import java.math.MathContext
import java.math.RoundingMode
import java.util.*

class Carrinho {

    private val itens: MutableList<Item> = ArrayList()

    fun adiciona(item: Item) {
        itens.add(item)
    }

    fun remove(item: Item) {
        itens.remove(item)
    }

    fun getItens(): List<Item> {
        return Collections.unmodifiableList(itens)
    }

    fun getValorTotal(): BigDecimal {
        val price = itens.sumByDouble { item -> item.getValor() }.toBigDecimal()
        price.setScale(2, RoundingMode.UP)
        return price.round(MathContext.DECIMAL32)
    }

    fun limpa() {
        itens.clear()
    }

}