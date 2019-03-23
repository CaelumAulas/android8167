package br.com.caelum.casadocodigoapp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.caelum.casadocodigoapp.fragment.ListaLivrosFragment
import br.com.caelum.casadocodigoapp.vm.LivroViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class LivroActivity : AppCompatActivity() {

    private val livroViewModel: LivroViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.container, ListaLivrosFragment())

        transaction.commit()
    }
}
