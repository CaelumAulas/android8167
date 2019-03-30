package br.com.caelum.casadocodigoapp.infra

import android.widget.ImageView
import com.squareup.picasso.Picasso

object CarregadorDeFoto {

    private val picasso = Picasso.get()


    fun carrega(foto: String, imageView: ImageView) {

        var fotoParaBusca = foto

        if (!foto.startsWith("https")) {
            fotoParaBusca = foto.replace("http", "https")
        }

        picasso.load(fotoParaBusca).fit().into(imageView)

    }


}