package com.kreate.daggerwithhilt

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import com.kreate.daggerwithhilt.api.Status
import com.kreate.daggerwithhilt.common.BaseActivity
import com.kreate.daggerwithhilt.databinding.ActivityMainBinding
import com.kreate.daggerwithhilt.entity.room.DummyUser
import com.kreate.daggerwithhilt.entity.room.UserRegistration
import com.kreate.daggerwithhilt.utils.showToast
import com.kreate.daggerwithhilt.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : BaseActivity() {
    var tag = "MainActivity"
    private val viewMode by viewModels<MyViewModel>()

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(LayoutInflater.from(this))
        setContentView(binding.root)
        binding.submit.setOnClickListener(this)

        viewMode.getFetchData().observe(this, {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        it.data?.let {
                            Log.e(tag,"Succes : ${it.title}")
                            it.title?.let {
                            }
                        }
                    }
                    Status.ERROR -> {
                        Log.e(tag, "Error")
                        it.message.let {
                        }

                    }
                    Status.LOADING -> {
                        Log.e(tag, "Loading")
                    }
                }
            }
        })
    }

    override fun onClick(p0: View?) {
        super.onClick(p0)
        when (p0) {
            binding.submit -> {
                showToast(this, "Call")
                val entity  =  UserRegistration().also {
                    it.username = binding.etUsername.text.toString()
                    it.age = binding.etAge.text.toString()
                }
                dbInvoked!!.insertAll(entity)
            }
        }
    }
}
//
class SomeInterfaceImp
@Inject constructor(val str: String) : SomeInterface {

    override val someThing: String
        get() = "Rahul $str"
}

interface SomeInterface {
    val someThing: String
}