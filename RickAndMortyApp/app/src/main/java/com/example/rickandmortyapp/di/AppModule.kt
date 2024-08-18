package com.example.rickandmortyapp.di

import android.content.Context
import android.provider.ContactsContract.Data
import com.example.rickandmortyapp.data.datasource.DataSource
import com.example.rickandmortyapp.data.repo.Repository
import com.example.rickandmortyapp.retrofit.ApiUtils
import com.example.rickandmortyapp.retrofit.CharacterDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideKarakterDataSource(kdao:CharacterDao) :DataSource  {
        return DataSource(kdao)
    }

    @Provides
    @Singleton
    fun provideRepository(dataSource: DataSource) :Repository  {
        return Repository(dataSource)
    }


    @Provides
    @Singleton
    fun provideCharacterDao() :CharacterDao  {
        return ApiUtils.getCharacterDao()
    }




}