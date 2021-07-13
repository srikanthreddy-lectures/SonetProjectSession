package com.example.sonetprojectsession.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
data class User(
    @PrimaryKey(autoGenerate = true)
    var id:Int,
    var firstname:String,
    var lastname:String,
    var age:Int
    )