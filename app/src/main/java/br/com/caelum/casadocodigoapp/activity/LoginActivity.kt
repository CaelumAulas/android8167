package br.com.caelum.casadocodigoapp.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import br.com.caelum.casadocodigoapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val auth = FirebaseAuth.getInstance()

        login_novo.setOnClickListener {

            val (email, senha) = usuarioDaTela()

            auth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener { task ->

                    if (task.isSuccessful) {
                        trocaTela()
                    }
                }
        }


        login_logar.setOnClickListener {

            val (email, senha) = usuarioDaTela()

            auth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        trocaTela()
                    }

                }
        }

    }

    private fun trocaTela() {
        val vaiParaLista = Intent(this, LivroActivity::class.java)
        startActivity(vaiParaLista)
        finish()
    }

    private fun usuarioDaTela(): Pair<String, String> {
        val email = login_email.text.toString()
        val senha = login_senha.text.toString()
        return Pair(email, senha)
    }
}