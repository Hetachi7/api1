package com.example.appisimpson.network

import com.example.appisimpson.models.Personaje
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface Webservice {

    @GET("quotes?count=12")
    suspend fun obtenerPersonajes(): Response<List<Personaje>>

    @GET ("quotes")
    suspend fun obtenerPersonaje(
        @Query("charachter") personaje: String
    ):Response<List<Personaje>>
}