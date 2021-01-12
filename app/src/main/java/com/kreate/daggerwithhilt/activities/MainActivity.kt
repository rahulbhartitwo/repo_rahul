package com.kreate.daggerwithhilt

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ApplicationComponent
import java.util.concurrent.RecursiveTask
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @provideSomeInterface1
    @Inject
    lateinit var someInterface1: SomeInterface

    @provideSomeInterface2
    @Inject
    lateinit var someInterface2: SomeInterface

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.e("TAG", someInterface1.someThing)
        Log.e("TAG", someInterface2.someThing)
    }
}

class SomeInterfaceImp
@Inject constructor(val str: String) : SomeInterface {
    override val someThing: String
        get() = "Rahul $str"
}

interface SomeInterface {
    val someThing: String
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class provideSomeInterface1

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class provideSomeInterface2

//@InstallIn(ApplicationComponent::class)
//@Module
//abstract class MyModule {
//    @Singleton
//    @Binds
//    abstract fun something(someImp: SomeInterfaceImp): SomeInterface
//}

@InstallIn(ApplicationComponent::class)
@Module
object MyModule {

    @Singleton
    @Provides
    @provideSomeInterface1
    fun provideSomeInterface1(): SomeInterface {
        return SomeInterfaceImp("1")
    }

    @Singleton
    @Provides
    @provideSomeInterface2
    fun provideSomeInterface2(): SomeInterface {
        return SomeInterfaceImp("2")
    }
}