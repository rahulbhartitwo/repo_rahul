package com.kreate.daggerwithhilt

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.fragment.app.viewModels
import com.kreate.daggerwithhilt.api.Status
import com.kreate.daggerwithhilt.common.BaseActivity
import com.kreate.daggerwithhilt.di.provideSomeInterface1
import com.kreate.daggerwithhilt.di.provideSomeInterface2
import com.kreate.daggerwithhilt.utils.snackbar
import com.kreate.daggerwithhilt.viewmodel.MyViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Inject
import javax.inject.Qualifier
import javax.inject.Singleton

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    var tag = "MainActivity"
    private val viewMode by viewModels<MyViewModel>()


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


        viewMode.getData().observe(this, {
            it.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
//                        Log.e("TAG","Succes : ${it.message}")
                        it.data?.let {
                            it.title?.let {
                                Log.e(tag, it)
//                                snackbar("API Invoked ==> $it")
                            }
                        }
                    }
                    Status.ERROR -> {
                        Log.e(tag, "ERROR")
                        it?.message.let {
                            Log.e(tag, it!!)
//                            snackbar(it)
                        }
                    }
                    Status.LOADING -> {
                        Log.e(tag, "Loading")
                    }
                }
            }
        })
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

//@InstallIn(ApplicationComponent::class)
//@Module
//abstract class MyModule {
//    @Singleton
//    @Binds
//    abstract fun something(someImp: SomeInterfaceImp): SomeInterface
//}
