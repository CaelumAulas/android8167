package br.com.caelum.casadocodigoapp.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import br.com.caelum.casadocodigoapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import kotlin.math.log

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val auth = FirebaseAuth.getInstance()


        if (estaLogado(auth)) {
            trocaTela()
        }

        login_novo.setOnClickListener {

            val (email, senha) = usuarioDaTela()

            login_novo.setBackgroundColor(Color.GRAY)
            login_novo.text = "Criando um novo usuário"
            login_novo.isEnabled = false

            auth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener { task ->

                    login_novo.setBackgroundColor(Color.parseColor("#ff9b19"))
                    login_novo.text = "Novo Usuario"
                    login_novo.isEnabled = true


                    if (task.isSuccessful) {
                        trocaTela()
                    } else {
                        Toast.makeText(this, "${task.exception?.message}", Toast.LENGTH_LONG).show()
                    }
                }
        }


        login_logar.setOnClickListener {

            val (email, senha) = usuarioDaTela()

            login_logar.setBackgroundColor(Color.GRAY)
            login_logar.text = "Logando usuário"
            login_logar.isEnabled = false

            auth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener { task ->

                    login_logar.setBackgroundColor(Color.parseColor("#ff9b19"))
                    login_logar.text = "Entrar"
                    login_logar.isEnabled = true

                    if (task.isSuccessful) {
                        trocaTela()
                    } else {
                        Toast.makeText(this, "${task.exception?.message}", Toast.LENGTH_LONG).show()
                    }

                }
        }

    }

    private fun estaLogado(auth: FirebaseAuth) = auth.currentUser != null

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