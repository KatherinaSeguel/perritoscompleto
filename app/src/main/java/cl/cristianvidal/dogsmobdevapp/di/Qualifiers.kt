package cl.cristianvidal.dogsmobdevapp.di

import javax.inject.Qualifier

/**
 * Created by Cristian Vidal on 2019-12-03.
 */

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class ApiDogService

@Retention(AnnotationRetention.BINARY)
@Qualifier
annotation class CoroutineScropeIO