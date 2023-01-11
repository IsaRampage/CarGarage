package com.example.cargarage1

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData

/**
 * Das MainViewModel
 */
class MainViewModel(application: Application) : AndroidViewModel(application) {

    /* -------------------- Klassen Variablen -------------------- */

    var navigateToFragmentTwo = MutableLiveData(false)

    /* -------------------- Öffentliche Funktionen -------------------- */

    fun navigateToFragmentTwo() {
        navigateToFragmentTwo.value = true
    }

    fun resetAllValues() {
        navigateToFragmentTwo.value = false
    }
}
