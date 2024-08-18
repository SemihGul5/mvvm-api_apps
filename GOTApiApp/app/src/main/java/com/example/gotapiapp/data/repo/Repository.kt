package com.example.gotapiapp.data.repo

import com.example.gotapiapp.data.datasource.DataSource
import com.example.gotapiapp.data.model.Karakter
import com.example.gotapiapp.retrofit.KarakterDao

class Repository {
    var ds=DataSource()
    suspend fun karakterYukle(): List<Karakter> =ds.karakterYukle()





}