package com.ogunladetaiye.udux.di


import com.ogunladetaiye.udux.data.remote.UduxApi
import com.ogunladetaiye.udux.utils.Constants.API_KEY
import com.ogunladetaiye.udux.utils.Constants.BASE_URL
import com.ogunladetaiye.udux.utils.Constants.HEADER_KEY
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton


@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Singleton
    @Provides
    fun provideConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    @Singleton
    @Provides
    fun provideRetrofitInstance(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(provideHttpClient())
            .addConverterFactory(provideConverterFactory())
            .build()
    }

    @Provides
    fun provideHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .readTimeout(20, TimeUnit.SECONDS)
            .connectTimeout(20, TimeUnit.SECONDS)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).addInterceptor(buildAuthorizationInterceptor()).build()
    }

    @Provides
    fun buildAuthorizationInterceptor() = object : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val originalRequest = chain.request()
            val new = originalRequest.newBuilder().addHeader(HEADER_KEY, API_KEY).build()
            return chain.proceed(new)
        }
    }


    @Singleton
    @Provides
    fun provideDummyApiService(retrofit: Retrofit): UduxApi {
        return retrofit.create(UduxApi::class.java)
    }
}