package com.example.vault.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = "login_table")
data class Login(
    var loginId:String,
    var loginPassword:String,
    var loginwebsite:String,
    var category:String,
    var createdAt:String,
    var note:String?,
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
): Parcelable