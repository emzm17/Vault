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
    suspend fun deletecard(uid:Long){
        cardDatabase.cardDao().deleteCard(uid)
    }


    suspend fun insertlogin(login: Login){
        loginDatabase.loginDao().insertLogin(login)
    }
    suspend fun deletelogin(uid: Long){
        loginDatabase.loginDao().deleteLogin(uid)
    }

   fun getAllCardDetails()=cardDatabase.cardDao().getAllcard()

    fun getAllLoginDetails(): LiveData<List<Login>> {
        return loginDatabase.loginDao().getAllLogin()
    }

    suspend fun updatelogin(login: Login){
       loginDatabase.loginDao().updateLogin(login)
    }
    fun search(website:String):LiveData<List<Login>>{
        return loginDatabase.loginDao().getSearchResult(website)
    }

   fun getCategory(category:String):LiveData<List<Login>>{
         return loginDatabase.loginDao().getCategoryList(category)
    }
    fun getType(cardType:String):LiveData<List<Card>>{
        return cardDatabase.cardDao().getAllcardType(cardType)
    }



}