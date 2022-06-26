package com.saize.genshinassistant.di

import com.saize.genshinassistant.data.GenshinRepositoryImpl
import com.saize.genshinassistant.data.RealmHolder
import com.saize.genshinassistant.data.RealmListSerializer
import com.saize.genshinassistant.domain.GenshinRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule

@Module
@InstallIn(SingletonComponent::class)
interface SingletonModule {
    @Binds
    fun repo(impl: GenshinRepositoryImpl): GenshinRepository
}

@Module
@InstallIn(SingletonComponent::class)
class SingletonProvidesModule {
    @Provides
    fun realm() = RealmHolder.realm
}