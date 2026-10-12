package com.route.e_commercec19_mobiletrack.gsat.di

import android.util.Log
import com.route.e_commercec19_mobiletrack.gsat.data.api.categoriesApis.CategoriesService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun getConverterFactory(): Converter.Factory {
        return Json { ignoreUnknownKeys = true }.asConverterFactory(
            "application/json; charset=utf-8".toMediaType()
        )
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor {
            Log.e("API", it)
        }.apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor).build()
    }

    @Provides
    @Singleton
    fun getRetrofit(client: OkHttpClient, converterFactory: Converter.Factory): Retrofit {
        return Retrofit
            .Builder()
            .client(client)
            .baseUrl("https://ecommerce.routemisr.com/api/v1/")
            .addConverterFactory(
                converterFactory
            )
            .build()
    }


}