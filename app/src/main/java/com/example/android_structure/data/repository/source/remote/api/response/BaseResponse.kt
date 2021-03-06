package com.example.android_structure.data.repository.source.remote.api.response

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class BaseResponse<T>(
    @Expose
    @SerializedName("results")
    val data: T
)
