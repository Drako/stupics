package guru.drako.stupics

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [
    AndroidInjectionModule::class,
    StupicsModule::class
])
interface StupicsComponent : AndroidInjector<StupicsApplication>
