package com.androplate.di

import com.androplate.core.initializers.AppInitializer
import com.androplate.initializers.TimberInitializer
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoSet

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule {

    @Binds
    @IntoSet
    abstract fun bindTimberInitializer(timberInitializer: TimberInitializer): AppInitializer

}