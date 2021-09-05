package com.example.android_structure.utils.base

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.example.android_structure.widget.dialogManager.DialogManager

abstract class BaseActivity<viewBinding : ViewBinding, viewModel : BaseViewModel> :
    AppCompatActivity() {

    protected abstract val viewModel: viewModel
    protected lateinit var viewBinding: viewBinding
    lateinit var dialogManager: DialogManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = inflateBinding(layoutInflater)
        setContentView(viewBinding.root)
        initView()
        initData()
    }

    override fun onStart() {
        super.onStart()
        registerLiveData()
    }

    private fun showLoading() {
        dialogManager.showLoading()
    }

    private fun hideLoading() {
        dialogManager.hideLoading()
    }

    abstract fun inflateBinding(inflater: LayoutInflater): viewBinding
    abstract fun initView()
    abstract fun initData()

    open fun registerLiveData() {
        viewModel.run {
            isLoading.observe(this@BaseActivity, {
                if (it) showLoading() else hideLoading()
            })
        }
    }
}
