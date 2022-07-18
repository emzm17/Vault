package com.example.vault.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "card_table")
data class Card(
    var cardHolder:String,
    var cardNumber:String,
    var cardExpiryMonth:String,
    var cardExpiryYear:String,
    var cardCvv:String,
    var cardType:String,
    var cardName:String,
    var creatAt:String,
    @PrimaryKey(autoGenerate = true)
    var id:Long=0
)