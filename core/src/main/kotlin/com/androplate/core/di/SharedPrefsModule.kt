package com.androplate.core.di

import com.androplate.core.di.annotations.EncryptedSharedPrefs
import com.androplate.core.di.annotations.MainSharedPrefs
import com.androplate.core.prefs.base.BasePreferences
import com.androplate.core.prefs.sharedprefs.EncryptedSharedPreference
import com.androplate.core.prefs.sharedprefs.MainSharedPreferences
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface SharedPrefsModule {

    @Binds
    @MainSharedPrefs
    @Singleton
    fun bindMainSharedPrefs(mainSharedPreferences: MainSharedPreferences): BasePreferences

    @Binds
    @EncryptedSharedPrefs
    @Singleton
    fun bindEncryptedSharedPrefs(encryptedSharedPreference: EncryptedSharedPreference): BasePreferences

}