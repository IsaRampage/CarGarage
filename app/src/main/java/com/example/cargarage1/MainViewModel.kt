package com.example.cargarage1

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.apicalls.data.AppRepository
import com.example.apicalls.data.remote.CarApi
import com.example.cargarage1.data.Model.Car
import com.example.cargarage1.data.local.getDatabase
import kotlinx.coroutines.launch

/**
 * Das MainViewModel
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {

    var TAG = "MainViewModel"
    private val database = getDatabase(application)
    var repository = AppRepository(CarApi, database)
    /* -------------------- Klassen Variablen -------------------- */

    var cars = repository.cars
    var garageCars = repository.garage


    fun loadCars() {
        viewModelScope.launch {
            try {
                repository.loadCars()
            } catch (e: Exception) {
                Log.e(TAG, "failed loading cars: $e")
            }
        }
    }


    fun updateCar(car: Car) {
        var newCar1 = car
        car.isGarage = !car.isGarage
        viewModelScope.launch {
            try {
                repository.saveCar(newCar1)
            } catch (e: Exception) {
                Log.e(TAG, "failed loading cars: $e")
            }
        }
    }
}
