package com.example.sonetprojectsession.repository

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.sonetprojectsession.data.User
import com.example.sonetprojectsession.data.UserDatabase
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {
    val readAllData: LiveData<List<User>>
    var repo:UserRepository

    init{
        val userDao = UserDatabase.getDatabase(application).userDao()
        repo = UserRepository(userDao)
        readAllData = repo.readAllData
    }

    fun addUser(user:User){
        viewModelScope.launch {
          repo.addUser(user)
        }
    }

}