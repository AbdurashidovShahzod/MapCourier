package uz.unzosoft.maposmdroiddemo.presentation.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import uz.unzosoft.maposmdroiddemo.presentation.app.App
import javax.inject.Singleton


/**
 * Created by Abdurashidov Shahzod on 14/12/21 15:14.
 * company QQBank
 * shahzod9933@gmail.com
 */
@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideAppContext(@ApplicationContext app: Context): App =
        app as App
}