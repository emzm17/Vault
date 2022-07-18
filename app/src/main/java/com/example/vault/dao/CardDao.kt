package com.example.vault.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.braintreepayments.cardform.utils.CardType
import com.example.vault.model.Card

@Dao
interface CardDao {

    @Insert
    suspend fun insertCard(card: Card)

    @Query("Delete from card_table where id=:uid")
    suspend fun deleteCard(uid:Long)

    @Query("SELECT * FROM card_table")
    fun getAllcard(): LiveData<List<Card>>

    @Query("SELECT * FROM card_table WHERE cardType like :cardType")
    fun getAllcardType(cardType: String):LiveData<List<Card>>

}