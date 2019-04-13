package br.com.caelum.casadocodigoapp.activity

import android.arch.lifecycle.Observer
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.Menu
import android.view.MenuItem
import br.com.caelum.casadocodigoapp.R
import br.com.caelum.casadocodigoapp.fragment.DetalhesDoLivroFragment
import br.com.caelum.casadocodigoapp.fragment.ListaLivrosFragment
import br.com.caelum.casadocodigoapp.fragment.LoadingFragment
import br.com.caelum.casadocodigoapp.vm.LivroViewModel
import com.google.firebase.auth.FirebaseAuth
import org.koin.android.viewmodel.ext.android.viewModel

class LivroActivity : AppCompatActivity() {

    private val livroViewModel: LivroViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if (savedInstanceState == null)
            exibe(LoadingFragment(), false)


        livroViewModel.livros.observe(this, Observer {
            exibe(ListaLivrosFragment(), false)
        })


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


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.livro_menu, menu)
        return true
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
            }
            R.id.carrinho -> {

                val irParaCarrinho = Intent(this, CarrinhoActivity::class.java)
                startActivity(irParaCarrinho)

            }

            R.id.logout -> {

                FirebaseAuth.getInstance().signOut()

                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
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
