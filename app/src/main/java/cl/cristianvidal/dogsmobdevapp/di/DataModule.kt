package cl.cristianvidal.dogsmobdevapp.di

import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by Cristian Vidal on 2019-12-03.
 * in this module put and provide okHttpClient and interceptor if necessary
 */
@Module
class DataModule {


    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory =
        GsonConverterFactory.create(gson)
}