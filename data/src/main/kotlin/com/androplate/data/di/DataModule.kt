package com.androplate.data.di

import com.androplate.data.repository.TemplateRepositoryImpl
import com.androplate.domain.repository.TemplateRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindTemplateRepository(templateRepository: TemplateRepositoryImpl): TemplateRepository
}