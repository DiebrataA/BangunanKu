package com.anggarad.dev.bangunganku.data.source.local.entity

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "reportentities")
data class ReportEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "reportId")
    var reportId: Int,

    @ColumnInfo(name = "fullname")
    var fullname: String,

    @ColumnInfo(name = "urlImage")
    var urlImage: String,

    @ColumnInfo(name = "buildType")
    var buildType: String,

    @ColumnInfo(name = "address")
    var address: String,

    @ColumnInfo(name = "coordinate")
    var coordinate: String,

    @ColumnInfo(name = "damageLvl")
    var damageLvl: String,

    @ColumnInfo(name = "dateTime")
    var dateTime: String,


    )
