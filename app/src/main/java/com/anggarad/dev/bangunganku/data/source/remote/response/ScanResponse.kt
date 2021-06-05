package com.anggarad.dev.bangunganku.data.source.remote.response

import com.google.gson.annotations.SerializedName
import java.sql.Timestamp

data class ScanResponse(

    @field:SerializedName("response")
    val response: Boolean? = null,

    @field:SerializedName("process_token")
    val processToken: String? = null,

    @field:SerializedName("timestamp")
    val timeStamp: Timestamp? = null,

    @field:SerializedName("date_time")
    val dateTime: String? = null,

    @field:SerializedName("urlimage")
    val urlImage: String? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("damagelevel")
    val damageLevel: String? = null,
)
