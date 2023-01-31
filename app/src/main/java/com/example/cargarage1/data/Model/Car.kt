package com.example.cargarage1.data.Model

import android.media.Image
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.Json


@Entity
data class Car(


    val id: Int,

    @Json(name = "Marke")
    val manufacturer: String,

    @PrimaryKey
    @Json(name = "Modell")
    val model: String,

    @Json(name = "Baujahr")
    val year: Int,

    @Json(name = "Leistung")
    val performance: String,

    @Json(name = "Verbrauch")
    val consumption: String,

    @Json(name = "Preis")
    val price: String,

    @Json(name = "Img")
    val carImage: String,

    @Json(name = "Race Bonus")
    val raceBonus: String,

    var isGarage: Boolean = false
)
