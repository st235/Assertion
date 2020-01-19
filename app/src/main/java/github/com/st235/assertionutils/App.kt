package github.com.st235.assertionutils

import android.app.Application
import github.com.st235.assertlib.Assert
import github.com.st235.assertlib.DefaultEnvironment

class App: Application() {
    override fun onCreate() {
        super.onCreate()
        Assert.setEnvironment(DefaultEnvironment(BuildConfig.DEBUG))
    }
}
