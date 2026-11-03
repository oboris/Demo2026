package ua.edu.cdu.boris.demo2026.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object AppRetrofitClient {
    private const val BASE_URL = "http://boris.cdu.edu.ua/api/"

    fun getClient(): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}