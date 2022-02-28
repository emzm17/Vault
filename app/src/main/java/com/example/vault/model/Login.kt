package com.example.vault.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "login_table")
data class Login(
    var loginId:String,
    var loginPassword:String,
    var loginwebsite:String,
    var category:String,
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
)