package io.github.yesterdaylz.echomusic.ui.main

import android.os.Bundle
import android.view.View
import androidx.core.content.edit
import androidx.core.view.GravityCompat
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import io.github.yesterdaylz.echomusic.BaseActivity
import io.github.yesterdaylz.echomusic.R
import io.github.yesterdaylz.echomusic.databinding.ActivityMainBinding
import io.github.yesterdaylz.echomusic.ui.dialog.ApiConfigDialogFragment


class MainActivity : BaseActivity<ActivityMainBinding>() {


    override fun getViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView() {
        // 导航栏基础配置
        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        binding.bottomNav.setupWithNavController(navHost.navController)
    }

    override fun initListener() {
        val navHost = supportFragmentManager.findFragmentById(R.id.nav_host) as NavHostFragment
        val navController = navHost.navController

        // 底部导航栏显示/隐藏逻辑
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {

                R.id.chatFragment -> binding.bottomNav.visibility = View.GONE

                else -> binding.bottomNav.visibility = View.VISIBLE
            }
        }

        // 侧边栏点击逻辑
        binding.navView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_domain -> ApiConfigDialogFragment().show(
                    supportFragmentManager,
                    "ApiConfigDialog"
                )
                R.id.nav_exit -> finishAffinity()
            }
            binding.drawerLayout.closeDrawer(GravityCompat.START)
            true
        }
    }

    override fun initData(savedInstanceState: Bundle?) {
        //首次弹窗
        if (savedInstanceState == null) {
            val firstLaunchPrefs = getSharedPreferences("app_config", MODE_PRIVATE)
            val isFirstLaunch = firstLaunchPrefs.getBoolean("is_first_launch", true)
            if (isFirstLaunch) {
                firstLaunchPrefs.edit { putBoolean("is_first_launch", false) }
                ApiConfigDialogFragment().show(supportFragmentManager, "ApiConfigDialog")
            }
        }
    }

    fun openDrawer() {
        binding.drawerLayout.openDrawer(GravityCompat.START)
    }



    override fun onDestroy() {
        super.onDestroy()
    }
}
