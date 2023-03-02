package com.example.homework18.data.entity

import androidx.room.ColumnInfo
import androidx.room.PrimaryKey

class NewPhoto(
    @PrimaryKey
    @ColumnInfo(name = "id")
    val id: Int? = null,

    @ColumnInfo(name = "uri")
    val uri: String,

    @ColumnInfo(name = "date")
    val date: String
)
