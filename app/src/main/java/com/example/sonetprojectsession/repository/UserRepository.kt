package com.example.sonetprojectsession.repository

import androidx.lifecycle.LiveData
import com.example.sonetprojectsession.data.User
import com.example.sonetprojectsession.data.UserDAO

class UserRepository(val userDao:UserDAO) {
    val readAllData:LiveData<List<User>> = userDao.readAllData()
    suspend fun addUser(user:User){
        userDao.addUser(user)
    }
}