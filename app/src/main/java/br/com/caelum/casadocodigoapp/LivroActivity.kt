package br.com.caelum.casadocodigoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.caelum.casadocodigoapp.fragment.ListaLivrosFragment

class LivroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.container, ListaLivrosFragment())

        transaction.commit()
    }
}
