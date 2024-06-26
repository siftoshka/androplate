package com.androplate.core.di

import com.androplate.core.logger.Logger
import com.androplate.core.logger.LoggerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface LoggerModule {

    @Binds
    fun bindLogger(loggerImpl: LoggerImpl): Logger
}