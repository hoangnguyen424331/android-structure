package com.example.android_structure.utils

import com.example.android_structure.utils.Constant.POSITION_DEFAULT

interface OnItemClickListener<T> {
    fun onItemViewClick(item: T, position: Int = POSITION_DEFAULT)
}
