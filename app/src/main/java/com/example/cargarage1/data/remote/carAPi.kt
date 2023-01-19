package com.example.apicalls.data.remote

import com.example.cargarage1.data.Model.Car
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

const val BASE_URL = "https://public.syntax-institut.de/apps/batch4/Steven/"

private val client: OkHttpClient = OkHttpClient.Builder()
    .addInterceptor { chain ->
        val newRequest = chain.request().newBuilder()
            .build()
        chain.proceed(newRequest)
    }.build()

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .client(client)
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

interface CarApiService {
    @GET("cars.json")
    suspend fun loadCars(): List<Car>
}

object CarApi {
    val retrofitService: CarApiService by lazy { retrofit.create(CarApiService::class.java) }
}