package com.androplate.domain.di

import com.androplate.domain.exceptions.ErrorConverter
import com.androplate.domain.exceptions.ErrorConverterImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ErrorConverterModule {
    @Binds
    fun bindErrorConverter(errorConverter: ErrorConverterImpl): ErrorConverter
}