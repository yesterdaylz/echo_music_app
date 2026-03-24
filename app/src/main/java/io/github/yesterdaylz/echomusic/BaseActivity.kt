package io.github.yesterdaylz.echomusic

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.startActivity
import androidx.viewbinding.ViewBinding

/**
 * Activity 通用基类
 */
abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {


    protected lateinit var binding: VB

    override fun onCreate(savedInstanceState: Bundle?) {
        beforeCreate()

        super.onCreate(savedInstanceState)

        //初始化 ViewBinding
        binding = getViewBinding()
        setContentView(binding.root)

        //执行生命周期抽象方法
        initView()
        initListener()
        initData(savedInstanceState)
    }

    /**
     * 在 super.onCreate() 之前调用
     */
    protected open fun beforeCreate() {}

    /**
     * 返回对应的 ViewBinding 实例
     */
    protected abstract fun getViewBinding(): VB

    /**
     * 初始化视图
     */
    protected abstract fun initView()

    /**
     * 初始化事件监听
     */
    protected open fun initListener() {}

    /**
     * 初始化数据
     */
    protected abstract fun initData(savedInstanceState: Bundle?)



    /**
     *  Toast
     */
    protected fun showToast(msg: String?) {
        if (!msg.isNullOrEmpty()) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }
    }

    /**
     * 页面跳转
     */
    protected fun skipActivity(targetClass: Class<*>, bundle: Bundle? = null) {
        val intent = Intent(this, targetClass)
        bundle?.let { intent.putExtras(it) }
        startActivity(intent)
    }
}