package com.example.appisimpson.models


import com.google.gson.annotations.SerializedName

data class Personaje(
    @SerializedName("quoetes")
    val frase:String,
    @SerializedName("character")
    val personaje:String,
    @SerializedName("image")
    val image:String,
    @SerializedName("characterDirection")
    val direccionPersonaje: String
)
