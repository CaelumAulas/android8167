package br.com.caelum.casadocodigoapp.fcm

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.support.v4.app.NotificationCompat
import br.com.caelum.casadocodigoapp.R
import br.com.caelum.casadocodigoapp.activity.CarrinhoActivity
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage

class RecebedorDeNotificacao : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        val manager: NotificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        criaChannel(manager)
        val procuracao = criaProcuracao()
        val notification = criaNotificacao(procuracao)

        manager.notify(123, notification)

    }

    private fun criaNotificacao(procuracao: PendingIntent): Notification? {
        val notification = NotificationCompat.Builder(this, "canal_cdc")
            .setContentTitle("Testeeeeee")
            .setContentText("Essa é uma mensagem de teste")
            .setContentIntent(procuracao)
            .setSmallIcon(R.drawable.carrinho_vazio)
            .setAutoCancel(true)
            .build()
        return notification
    }

    private fun criaProcuracao(): PendingIntent {
        val procuracao = PendingIntent.getActivity(
            this,
            123,
            Intent(this, CarrinhoActivity::class.java),
            PendingIntent.FLAG_UPDATE_CURRENT
        )
        return procuracao
    }

    private fun criaChannel(manager: NotificationManager) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

            val channel = NotificationChannel(
                "canal_cdc",
                "Canal de cupons",
                NotificationManager.IMPORTANCE_HIGH
            )
            channel.description = "Aqui voce receberá as notificações de cupons para usar na compra dos seus livros"

            manager.createNotificationChannel(channel)
        }
    }
}