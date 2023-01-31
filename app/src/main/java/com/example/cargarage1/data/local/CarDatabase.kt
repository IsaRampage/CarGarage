package com.example.cargarage1.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cargarage1.data.Model.Car


@Database(entities = [Car::class], version = 1)
abstract class CarDatabase : RoomDatabase() {

    abstract val carDatabaseDao: CarDatabaseDao
}

private lateinit var INSTANCE: CarDatabase

fun getDatabase(context: Context): CarDatabase {
    synchronized(CarDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                CarDatabase::class.java,
                "cars4you"
            )
                .build()
        }
    }
    return INSTANCE
}