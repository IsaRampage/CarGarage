package com.example.cargarage1

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.apicalls.data.AppRepository
import com.example.apicalls.data.remote.CarApi
import kotlinx.coroutines.launch

/**
 * Das MainViewModel
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {

    var TAG = "MainViewModel"
    var repository = AppRepository(CarApi)
    /* -------------------- Klassen Variablen -------------------- */

    var cars = repository.cars
    // var navigateToFragmentTwo = MutableLiveData(false)

    fun loadCars() {
        viewModelScope.launch {
            try {
                repository.loadCars()
            } catch (e: Exception) {
                Log.e(TAG, "failed loading cars: $e")
            }
        }
    }
    /* -------------------- Öffentliche Funktionen -------------------- */

    //fun navigateToFragmentTwo() {
      //  navigateToFragmentTwo.value = true
    //}

    //fun resetAllValues() {
      //  navigateToFragmentTwo.value = false
    //}
}
