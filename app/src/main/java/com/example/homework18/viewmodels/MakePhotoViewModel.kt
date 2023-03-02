package com.example.homework18.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.homework18.data.UserDao
import com.example.homework18.data.entity.NewPhoto
import kotlinx.coroutines.launch

class MakePhotoViewModel(private val userDao: UserDao) : ViewModel() {
    fun addPhotoInDb(date: String, uri: String) {
        viewModelScope.launch {
            userDao.insert(
                NewPhoto(
                    date = date,
                    uri = uri
                )
            )
        }
    }
}