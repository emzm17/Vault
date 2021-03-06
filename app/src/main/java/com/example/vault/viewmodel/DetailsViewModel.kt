package com.example.vault.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vault.model.Card
import com.example.vault.model.Login
import com.example.vault.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel(private val repository: Repository): ViewModel() {



    fun insertcard(card: Card){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertcard(card)
        }
    }
    fun insertlogin(login: Login){
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertlogin(login)
        }
    }
    fun deletelogin(uid:Long){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletelogin(uid)
        }
    }
    fun deletecard(uid:Long){
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletecard(uid)
        }
    }
   fun allCard()=repository.getAllCardDetails()
   fun allLogin()=repository.getAllLoginDetails()


    fun updatelogin(login:Login){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatelogin(login)
        }
    }
    fun searchForResult(website:String):LiveData<List<Login>>{
        return repository.search(website)
    }
    fun category(category:String):LiveData<List<Login>>{
        return repository.getCategory(category)
    }
    fun type(cardtype:String):LiveData<List<Card>>{
        return repository.getType(cardtype)
    }


}