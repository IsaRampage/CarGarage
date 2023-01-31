package com.example.apicalls.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.apicalls.data.remote.CarApi
import com.example.cargarage1.data.Model.Car
import com.example.cargarage1.data.local.CarDatabase

class AppRepository(private val api: CarApi, private val database: CarDatabase) {

    // Speichert Cars in Liste zum Abruf
   // private val _cars = MutableLiveData<List<Car>>()
    //val cars: LiveData<List<Car>>
      //  get() = _cars

    val cars = database.carDatabaseDao.getAll()
    val garage = database.carDatabaseDao.getGarageCars()

    // APi Call liefert Liste mit Autos zurück
    suspend fun loadCars() {
        val newCars = api.retrofitService.loadCars()
        database.carDatabaseDao.insertAll(newCars)
    }

   suspend fun saveCar(car: Car) {
    database.carDatabaseDao.updateCar(car)
    }

}