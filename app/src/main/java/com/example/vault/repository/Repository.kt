package com.example.vault.repository

import androidx.lifecycle.LiveData
import com.example.vault.database.CardDatabase
import com.example.vault.database.LoginDatabase
import com.example.vault.model.Card
import com.example.vault.model.Login

class Repository(private val cardDatabase: CardDatabase, private val loginDatabase: LoginDatabase){

    suspend fun insertcard(card: Card){
        cardDatabase.cardDao().insertCard(card)
    }
    suspend fun deletecard(card: Card){
        cardDatabase.cardDao().deleteCard(card)
    }


    suspend fun insertlogin(login: Login){
        loginDatabase.loginDao().insertLogin(login)
    }
    suspend fun deletelogin(login: Login){
        loginDatabase.loginDao().deleteLogin(login)
    }

    fun getAllCardDetails(): LiveData<List<Card>> {
        return cardDatabase.cardDao().getAllcard()
    }

    fun getAllLoginDetails(): LiveData<List<Login>> {
        return loginDatabase.loginDao().getAllLogin()
    }

    suspend fun updatelogin(login: Login){
       loginDatabase.loginDao().updateLogin(login)
    }

}