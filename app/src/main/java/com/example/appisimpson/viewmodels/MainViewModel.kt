package com.example.appisimpson.viewmodels

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.appisimpson.core.RetrofitClient
import com.example.appisimpson.models.Personaje
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import com.example.appisimpson.network.Webservice

class MainViewModel: ViewModel() {

    private var _listaPersonajes = MutableLiveData<List<Personaje>>()
    val listaPersonajes: LiveData<List<Personaje>> get() = _listaPersonajes

    fun obtenerPersonajes() {

        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.obtenerPersonajes()
            withContext(Dispatchers.Main) {
                Log.d("API", response.body().toString())
                _listaPersonajes.value = response.body()
            }
        }
    }

    fun obtenerPersonaje(personaje: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val response = RetrofitClient.webService.obtenerPersonaje(personaje)
            withContext(Dispatchers.Main) {
                Log.d("API", response.body().toString())
                _listaPersonajes.value = response.body()
            }
        }
    }

}