package com.route.e_commercec19_mobiletrack.gsat.di.categories

import com.route.e_commercec19_mobiletrack.gsat.data.api.categoriesApis.CategoriesService
import com.route.e_commercec19_mobiletrack.gsat.data.categories.dataSource.remote.CategoriesRemoteDataSourceImpl
import com.route.e_commercec19_mobiletrack.gsat.data.categories.repositoriesImpl.CategoriesRepositoryImpl
import com.route.e_commercec19_mobiletrack.gsat.domain.categories.repsoitories.CategoriesRemoteDataSource
import com.route.e_commercec19_mobiletrack.gsat.domain.categories.repsoitories.CategoriesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CategoriesRepositoryModule {
    @Provides
    @Singleton
    fun provideCategoriesRepository(remoteDataSource: CategoriesRemoteDataSource): CategoriesRepository {
        return CategoriesRepositoryImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideRemoteCategoriesDataSource(service: CategoriesService): CategoriesRemoteDataSource {
        return CategoriesRemoteDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun getCategoriesService(retrofit: Retrofit): CategoriesService {
        return retrofit.create(CategoriesService::class.java)
    }


}
