package br.com.caelum.casadocodigoapp.infra

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CriadorDeRetrofit {

    val retrofit = Retrofit.Builder()
        .baseUrl("https://cdcmob.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(CoroutineCallAdapterFactory())
        .build()

}