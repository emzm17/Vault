package com.example.vault.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.vault.model.Login

@Dao
interface LoginDao {

    @Insert
    suspend fun insertLogin(login: Login)

    @Delete
    suspend fun deleteLogin(login: Login)

    @Query("SELECT * FROM login_table")
    fun getAllLogin(): LiveData<List<Login>>
}