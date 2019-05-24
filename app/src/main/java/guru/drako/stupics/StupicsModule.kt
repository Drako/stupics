package guru.drako.stupics

import com.squareup.picasso.Picasso
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
abstract class StupicsModule {
    @ContributesAndroidInjector
    abstract fun contributeActivityInjector(): MainActivity

    @Module
    companion object {
        @JvmStatic
        @Provides
        @Singleton
        fun providePicasso(): Picasso = Picasso.get().apply {
            isLoggingEnabled = true
        }

        @JvmStatic
        @Provides
        @Singleton
        fun provideCatApiService(): CatApiService = Retrofit.Builder()
            .baseUrl("https://api.thecatapi.com/v1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create<CatApiService>()
    }
}
