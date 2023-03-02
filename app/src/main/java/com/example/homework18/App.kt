package com.example.homework18

import android.app.Application
import androidx.room.Room
import com.example.homework18.data.AppDatabase

class App : Application() {

    lateinit var db: AppDatabase
        private set

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
        db = Room
            .databaseBuilder(
                this,
                AppDatabase::class.java,
                "db"
            )
            .fallbackToDestructiveMigration()
            .build()
    }

    companion object {
        lateinit var INSTANCE: App
            private set
    }
}