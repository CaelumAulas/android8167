package br.com.caelum.casadocodigoapp.modelo

import java.util.*

class Carrinho {

    private val itens: MutableList<Item> = ArrayList()

    fun adiciona(item: Item) {
        itens.add(item)
    }

    fun remove(item: Item) {
        itens.remove(item)
    }

    fun getItens(): MutableList<Item>? {
        return Collections.unmodifiableList(itens)
    }

}