package devos.wouter.moviereleases.ui

import android.arch.lifecycle.LifecycleRegistry
import android.arch.lifecycle.LifecycleRegistryOwner
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import devos.wouter.moviereleases.R
import devos.wouter.moviereleases.databinding.ActivityMainBinding

abstract class BaseActivity : AppCompatActivity(), LifecycleRegistryOwner {

    private val mLifecycleRegistry = LifecycleRegistry(this)

    override fun getLifecycle(): LifecycleRegistry {
        return mLifecycleRegistry
    }
}
