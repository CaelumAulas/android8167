package br.com.caelum.casadocodigoapp

import android.arch.lifecycle.Observer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.MenuItem
import br.com.caelum.casadocodigoapp.fragment.DetalhesDoLivroFragment
import br.com.caelum.casadocodigoapp.fragment.ListaLivrosFragment
import br.com.caelum.casadocodigoapp.vm.LivroViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class LivroActivity : AppCompatActivity() {

    private val livroViewModel: LivroViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        exibe(ListaLivrosFragment(), false)


        livroViewModel.livro.observe(this, Observer { livro ->
            if (livro != null) {
                exibe(DetalhesDoLivroFragment(), true)
            }
        })

    }

    private fun exibe(fragment: Fragment, deveEmpilhar: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()

        transaction.replace(R.id.container, fragment)

        if (deveEmpilhar) transaction.addToBackStack(null)

        transaction.commit()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
            else -> {
            }
        }

        return true
    }


    override fun onBackPressed() {
        super.onBackPressed()
        livroViewModel.limpaLivro()
    }
}
