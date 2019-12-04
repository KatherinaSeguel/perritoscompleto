package cl.cristianvidal.dogsmobdevapp.di

import android.app.Application
import cl.cristianvidal.dogsmobdevapp.breedList.data.BreedListRemoteDataSource
import cl.cristianvidal.dogsmobdevapp.data.AppDataBase
import cl.cristianvidal.dogsmobdevapp.util.Constants
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Cristian Vidal on 2019-12-03.
 */
@Module(includes = [DataModule::class, ViewModelModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideApiDogService(
        @ApiDogService okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ) = provideService(okHttpClient, converterFactory, ApiDogService::class.java)

    @Singleton
    @Provides
    fun provideRemoteBreedListDataSource(apiDogService: cl.cristianvidal.dogsmobdevapp.api.ApiDogService) =
        BreedListRemoteDataSource(
            apiDogService
        )

    //This is not use because this api don`t need AuthInterceptor

//    @ApiDogService
//    @Provides
//    fun provideOkHttpClient( upstreamClient: OkHttpClient
//    ): OkHttpClient {
//        return upstreamClient.newBuilder()
//            .addInterceptor(AuthInterceptor(BuildConfig.API_DEVELOPER_TOKEN)).build()


    @CoroutineScropeIO
    @Provides
    fun provideCoroutineScopeIO() = CoroutineScope(Dispatchers.IO)


    @Singleton
    @Provides
    fun provideDb(app: Application) = AppDataBase.getInstance(app)


    private fun createRetrofit(
        okhttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(Constants.ENDPOINT)
            .client(okhttpClient)
            .addConverterFactory(converterFactory)
            .build()
    }

    private fun <T> provideService(
        okhttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory, clazz: Class<T>
    ): T {
        return createRetrofit(okhttpClient, converterFactory).create(clazz)
    }

}