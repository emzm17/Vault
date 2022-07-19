package com.example.vault.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.vault.dao.LoginDao
import com.example.vault.model.Login

@Database(entities = [Login::class],version = 1)
abstract class LoginDatabase: RoomDatabase() {
    abstract fun loginDao(): LoginDao

    companion object {
        private var INSTANCE: LoginDatabase? = null
        fun getDatabase(context: Context): LoginDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context, LoginDatabase::class.java, "loginDB")
                            .build()
                }
            }
            return INSTANCE!!
        }

    }
}