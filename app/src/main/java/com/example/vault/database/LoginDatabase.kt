package com.example.vault.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.example.vault.dao.LoginDao
import com.example.vault.model.Login

@Database(entities = [Login::class],version = 3,exportSchema = false)
abstract class LoginDatabase: RoomDatabase() {
    abstract fun loginDao(): LoginDao
    companion object {
        val migration_1_2=object:Migration(1,2){
            override fun migrate(database: SupportSQLiteDatabase) {
                   database.execSQL("ALTER  TABLE login_table ADD COLUMN createdAt INTEGER NOT NULL DEFAULT(1)    ")
            }

        }
        private var INSTANCE: LoginDatabase? = null
        fun getDatabase(context: Context): LoginDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context,LoginDatabase::class.java, "loginDB")
                            .addMigrations(migration_1_2)
                            .build()
                }
            }
            return INSTANCE!!
        }
    }
}