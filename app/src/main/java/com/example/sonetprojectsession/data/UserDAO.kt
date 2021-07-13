package com.example.sonetprojectsession.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDAO {
    @Insert
    suspend fun addUser(user:User)

    @Query("SELECT * FROM user_table")
    suspend fun readAllData():List<User>
}