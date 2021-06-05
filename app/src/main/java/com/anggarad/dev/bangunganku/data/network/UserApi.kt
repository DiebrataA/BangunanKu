package com.anggarad.dev.bangunganku.data.network

import com.anggarad.dev.bangunganku.data.source.remote.response.ReportResponse
import com.anggarad.dev.bangunganku.data.source.remote.response.UserResponse
import com.google.android.gms.maps.model.LatLng
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi {

    @GET("service_my_data")
    suspend fun getUser(): UserResponse

    @POST("service_report")
    suspend fun postReport(
        fullname: String,
        address: String,
        coordinate: LatLng,
        damageLvl: String,
        buildingType: String,
        photo: String
    ): ReportResponse
}