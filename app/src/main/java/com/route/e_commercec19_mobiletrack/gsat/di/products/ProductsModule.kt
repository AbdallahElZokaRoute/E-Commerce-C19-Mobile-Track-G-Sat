package com.route.e_commercec19_mobiletrack.gsat.di.products

import com.route.e_commercec19_mobiletrack.gsat.data.api.categoriesApis.CategoriesService
import com.route.e_commercec19_mobiletrack.gsat.data.api.productsService.ProductsService
import com.route.e_commercec19_mobiletrack.gsat.data.categories.dataSource.remote.CategoriesRemoteDataSourceImpl
import com.route.e_commercec19_mobiletrack.gsat.data.categories.repositoriesImpl.CategoriesRepositoryImpl
import com.route.e_commercec19_mobiletrack.gsat.data.products.dataSource.ProductsRemoteDataSourceImpl
import com.route.e_commercec19_mobiletrack.gsat.data.products.repositoriesImpl.ProductsRepositoryImpl
import com.route.e_commercec19_mobiletrack.gsat.domain.categories.repsoitories.CategoriesRemoteDataSource
import com.route.e_commercec19_mobiletrack.gsat.domain.categories.repsoitories.CategoriesRepository
import com.route.e_commercec19_mobiletrack.gsat.domain.products.repositories.ProductsRemoteDataSource
import com.route.e_commercec19_mobiletrack.gsat.domain.products.repositories.ProductsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ProductsModule {
    @Provides
    @Singleton
    fun provideProductsRepository(remoteDataSource: ProductsRemoteDataSource): ProductsRepository {
        return ProductsRepositoryImpl(remoteDataSource)
    }

    @Provides
    @Singleton
    fun provideRemoteProductsDataSource(service: ProductsService): ProductsRemoteDataSource {
        return ProductsRemoteDataSourceImpl(service)
    }

    @Provides
    @Singleton
    fun provideProductsService(retrofit: Retrofit): ProductsService {
        return retrofit.create(ProductsService::class.java)
    }

}
