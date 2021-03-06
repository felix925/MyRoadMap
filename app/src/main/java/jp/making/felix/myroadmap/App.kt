package jp.making.felix.myroadmap

import android.app.Application
import jp.making.felix.myroadmap.di.moduleList
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        initializeKoin()
        initializeTimber()
    }

    private fun initializeKoin() {
        startKoin {
            androidContext(this@App)
            modules(modules = moduleList)
        }
    }

    private fun initializeTimber() {
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}