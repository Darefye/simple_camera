package com.example.homework18.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.homework18.data.entity.Photo

@Database(
    entities = [
        Photo::class
    ], version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}