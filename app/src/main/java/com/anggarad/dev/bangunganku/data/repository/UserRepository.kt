package com.anggarad.dev.bangunganku.data.repository

import com.anggarad.dev.bangunganku.data.network.UserApi
import com.google.android.gms.maps.model.LatLng

class UserRepository(
    private val api: UserApi
) : BaseRepository() {


    suspend fun getUser() = safeApiCall {
        api.getUser()
    }

//    fun getUserNameLocal(): LiveData<UserEntity> = mUserDao.getUserLocalData()
//
//    fun insertDataToLocal(user: UserEntity){
//        executorService.execute { mUserDao.insertUserData(user) }
//    }

    //
    suspend fun postReport(
        name: String,
        address: String,
        coordinate: LatLng,
        damageLvl: String,
        buildingType: String,
        photo: String
    ) = safeApiCall {
        api.postReport(name, address, coordinate, damageLvl, buildingType, photo)
    }
}