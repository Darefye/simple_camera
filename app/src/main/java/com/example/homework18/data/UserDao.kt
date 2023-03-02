package com.example.homework18.data

import androidx.room.*
import com.example.homework18.data.entity.NewPhoto
import com.example.homework18.data.entity.Photo
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Transaction
    @Query("SELECT * FROM photo")
    fun getAll(): Flow<List<Photo>>

    @Insert(entity = Photo::class)
    suspend fun insert(user: NewPhoto)

    @Delete
    suspend fun delete(user: Photo)

    @Update
    suspend fun update(user: Photo)
}