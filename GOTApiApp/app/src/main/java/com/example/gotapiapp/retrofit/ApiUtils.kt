package com.example.gotapiapp.retrofit

class ApiUtils {// get post işlemlerinin olduğu interfaceleri çalıştırır
    companion object{
        val BASE_URL="https://thronesapi.com/api/v2/"

        fun getCharacterDao(): KarakterDao{
            return RetrofitClient.getClient(BASE_URL).create(KarakterDao::class.java)
        }
    }
}