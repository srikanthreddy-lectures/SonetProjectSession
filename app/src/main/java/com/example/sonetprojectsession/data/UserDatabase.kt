package com.example.sonetprojectsession.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [User::class],version = 1, exportSchema = false)
abstract class  UserDatabase: RoomDatabase(){
    abstract fun userDAO():UserDAO

    //Singleton for a function
    companion object {
        fun getDatabase(context: Context): UserDatabase {
            //logic
            //lock
            synchronized(this) {
                var instance = Room.databaseBuilder(
                    context.applicationContext,
                    UserDatabase::class.java,
                    "user_database"
                ).build()
                return instance
            }
        }
    }
}