package br.com.caelum.casadocodigoapp.application

import android.app.Application
import br.com.caelum.casadocodigoapp.di.modulos
import org.koin.android.ext.android.startKoin

class CasaDoCodigoApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin(this, modulos)
    }
}