package com.example.vault.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "card_table")
data class Card (

    var cardHolder:String,
    var cardType:String,
    var cardNumber:String,
    var cardExpiryMonth:String,
    var cardExpiryYear:String,
    var cardCvvNo:String,
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
)