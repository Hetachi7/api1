package com.example.appisimpson.core

import com.example.appisimpson.network.Webservice
import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitClient {
    val webService: Webservice by lazy {
        Retrofit.Builder()
            .baseUrl(constantes.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder().create()))
            .build()
            .create(Webservice::class.java)
    }
}