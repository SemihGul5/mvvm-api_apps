package com.example.gotapiapp.data.datasource

import com.example.gotapiapp.data.model.Karakter
import com.example.gotapiapp.retrofit.ApiUtils
import com.example.gotapiapp.retrofit.KarakterDao

class DataSource:KarakterDao {

    override suspend fun karakterYukle(): List<Karakter> {
        return ApiUtils.getCharacterDao().karakterYukle()
    }
}