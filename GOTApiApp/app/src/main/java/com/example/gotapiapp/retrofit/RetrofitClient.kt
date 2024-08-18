package com.example.gotapiapp.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {//1 kere tanımlanır, json dönüşüm işlemleri yapılır
    companion object{
        fun getClient(baseUrl:String): Retrofit {
            return Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}