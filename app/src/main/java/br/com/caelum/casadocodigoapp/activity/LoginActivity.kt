package br.com.caelum.casadocodigoapp.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import android.widget.Toast
import br.com.caelum.casadocodigoapp.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*

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

            alteraAspectoDoButton(login_novo, Color.GRAY, "Criando um novo usuário", false)

            auth.createUserWithEmailAndPassword(email, senha)
                .addOnCompleteListener { task ->

                    alteraAspectoDoButton(login_novo, Color.parseColor("#ff9b19"), "Novo usuario", true)


                    if (task.isSuccessful) {
                        trocaTela()
                    } else {
                        Toast.makeText(this, "${task.exception?.message}", Toast.LENGTH_LONG).show()
                    }
                }
        }


        login_logar.setOnClickListener {

            val (email, senha) = usuarioDaTela()

            alteraAspectoDoButton(login_logar, Color.GRAY, "Logando usuário", false)

            auth.signInWithEmailAndPassword(email, senha)
                .addOnCompleteListener { task ->

                    alteraAspectoDoButton(login_logar, Color.parseColor("#ff9b19"), "Entrar", true)

                    if (task.isSuccessful) {
                        trocaTela()
                    } else {
                        Toast.makeText(this, "${task.exception?.message}", Toast.LENGTH_LONG).show()
                    }

                }
        }

    }

    private fun alteraAspectoDoButton(button: Button, color: Int, texto: String, ativo: Boolean) {
        button.setBackgroundColor(color)
        button.text = texto
        button.isEnabled = ativo
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