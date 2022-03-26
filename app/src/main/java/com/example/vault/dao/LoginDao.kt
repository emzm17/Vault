package com.example.vault.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.vault.model.Login

@Dao
interface LoginDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertLogin(login: Login)

    @Query("Delete from login_table where id=:uid")
    suspend fun deleteLogin(uid:Long)

    @Update
    suspend fun updateLogin(login: Login)

    @Query("SELECT * FROM login_table")
    fun getAllLogin(): LiveData<List<Login>>
}