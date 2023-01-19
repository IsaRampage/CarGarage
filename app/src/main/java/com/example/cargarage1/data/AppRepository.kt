package com.example.apicalls.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apicalls.data.remote.CarApi
import com.example.cargarage1.data.Model.Car

class AppRepository(private val api: CarApi) {

    // Speichert Cars in Liste zum Abruf
    private val _cars = MutableLiveData<List<Car>>()
    val cars: LiveData<List<Car>>
        get() = _cars

    // APi Call liefert Liste mit Autos zurück
    suspend fun loadCars() {
        _cars.value = api.retrofitService.loadCars()
    }

}