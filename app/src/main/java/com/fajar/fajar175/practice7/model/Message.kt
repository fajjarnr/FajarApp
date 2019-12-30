package com.fajar.fajar175.practice7.model

import com.google.gson.annotations.SerializedName

data class Message(
    @SerializedName("status")
    var status: String? = null,
    @SerializedName("error")
    var error: String? = null,
    @SerializedName("message")
    var message: String? = null
)