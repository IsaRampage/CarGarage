package com.example.cargarage1.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.cargarage1.data.Model.Car
import retrofit2.http.GET


@Dao
interface CarDatabaseDao {

    // Liste wird in Datenbank geladen
    @Insert(onConflict = OnConflictStrategy.ABORT)
    suspend fun insertAll(cars: List<Car>)

    // Liste holen um sie anzuzeigen
    @Query("SELECT * FROM Car WHERE isGarage = 0")
    fun getAll(): LiveData<List<Car>>

    @Query("SELECT * FROM Car WHERE isGarage = 1")
    fun getGarageCars() : LiveData<List<Car>>

    @Update
    suspend fun updateCar(car: Car)
}