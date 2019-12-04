package cl.cristianvidal.dogsmobdevapp

import android.app.Activity
import android.app.Application
import androidx.databinding.library.BuildConfig
import cl.cristianvidal.dogsmobdevapp.di.AppInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import timber.log.Timber
import javax.inject.Inject

/**
 * Created by Cristian Vidal on 2019-12-03.
 */
class App : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())

        AppInjector.init(this)
    }


    override fun activityInjector() = dispatchingAndroidInjector


}