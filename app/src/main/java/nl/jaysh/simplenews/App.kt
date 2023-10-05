package nl.jaysh.simplenews

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import logcat.AndroidLogcatLogger

@HiltAndroidApp
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initializeLogcat()
    }

    private fun initializeLogcat() {
        AndroidLogcatLogger.installOnDebuggableApp(this)
    }
}
