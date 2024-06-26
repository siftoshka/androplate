package com.androplate.core.di

import com.androplate.core.exceptionhandler.ExceptionLogger
import com.androplate.core.exceptionhandler.ExceptionLoggerImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface ExceptionLoggerModule {

    @Binds
    fun bindExceptionLogger(exceptionLogger: ExceptionLoggerImpl): ExceptionLogger


}