package com.example.vault.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.vault.dao.CardDao
import com.example.vault.model.Card

@Database(entities = [Card::class],version = 1,exportSchema = false)
abstract class CardDatabase: RoomDatabase() {
    abstract fun cardDao(): CardDao
    companion object {
        private var INSTANCE: CardDatabase? = null
        fun getDatabase(context: Context): CardDatabase {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE =
                        Room.databaseBuilder(context,CardDatabase::class.java, "cardDB")
                            .build()
                }
            }
            return INSTANCE!!
        }
    }
}