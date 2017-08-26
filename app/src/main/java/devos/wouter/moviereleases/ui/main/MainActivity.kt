package devos.wouter.moviereleases.ui.main

import android.databinding.DataBindingUtil
import android.os.Bundle
import devos.wouter.moviereleases.R
import devos.wouter.moviereleases.databinding.ActivityMainBinding
import devos.wouter.moviereleases.ui.BaseActivity

class MainActivity : BaseActivity() {

    lateinit var mBinding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
    }
}
