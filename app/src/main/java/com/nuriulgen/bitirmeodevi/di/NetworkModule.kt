package com.nuriulgen.bitirmeodevi.di

import com.nuriulgen.bitirmeodevi.BuildConfig
import com.nuriulgen.bitirmeodevi.data.remote.ApiService
import com.nuriulgen.bitirmeodevi.data.remote.GuideApiService
import com.nuriulgen.bitirmeodevi.data.remote.repository.*
import com.nuriulgen.bitirmeodevi.domain.repository.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    /**
     * BASE_URL, API_KEY gibi özel değerler için güvenlik açığı olmaması için gizlendi.
     */
    private val baseUrl = BuildConfig.BASE_URL
    private val guideBaseUrl = BuildConfig.GUIDE_BASE_URL

    /**
     *  modelimizi json convert edebilmesi için GsonConvertorFactory kullanıldı.
     */
    @Provides
    @Singleton
    fun provideGsonConvertorFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }

    /**
     * Retrofit ( GET, POST vb.)
     */
    @Provides
    @Singleton
    fun provideRetrofit(gsonConverterFactory: GsonConverterFactory): Retrofit{
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(gsonConverterFactory)
            .build()
    }

    @Provides
    @Singleton
    fun provideService(retrofit: Retrofit): ApiService{
        return retrofit.create(ApiService::class.java)
    }

    @Provides
    @Singleton
    fun provideTopDestinationRepository(apiService: ApiService): TopDestinationRepository{
        return TopDestinationRepositoryImp(apiService)
    }

    @Provides
    @Singleton
    fun provideNearbyAttractionsRepository(apiService: ApiService): NearbyAttractionsRepository{
        return NearbyAttractionsRepositoryImp(apiService)
    }

    @Provides
    @Singleton
    fun provideMightNeedRepository(apiService: ApiService): MightNeedRepository{
        return MightNeedRepositoryImp(apiService)
    }

    @Provides
    @Singleton
    fun provideTopPickRepository(apiService: ApiService): TopPickRepository{
        return TopPickRepositoryImp(apiService)
    }

    @Provides
    @Singleton
    fun provideAllRepository(apiService: ApiService): AllRepository{
        return AllRepositoryImp(apiService)
    }

    /**
     * Api Service base url farklı olduğu için yeni bir retrofit builde oluşturuldu.
     */
    @Provides
    @Singleton
    fun provideGuideRepository(gsonConverterFactory: GsonConverterFactory): GuideRepository{
        val retrofit = Retrofit.Builder()
            .baseUrl(guideBaseUrl)
            .addConverterFactory(gsonConverterFactory)
            .build()

        val guideApiService = retrofit.create(GuideApiService::class.java)

        return GuideRepositoryImp(guideApiService)
    }

}