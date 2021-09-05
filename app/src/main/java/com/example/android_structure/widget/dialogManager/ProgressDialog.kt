package com.example.android_structure.widget.dialogManager

import android.app.Dialog
import android.content.Context
import com.example.android_structure.R

class ProgressDialog(context: Context) : Dialog(context) {

    init {
        initView()
    }

    private fun initView() {
        setContentView(R.layout.layout_progress_dialog)
        setCancelable(false)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        setCanceledOnTouchOutside(false)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        dismiss()
    }
}
