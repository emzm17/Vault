package com.example.vault.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.vault.model.Card
import com.example.vault.model.Login
import com.example.vault.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class DetailsViewModel(private val repository: Repository): ViewModel() {

    private var cardlist: LiveData<List<Card>> = repository.getAllCardDetails()
    private var loginlist: LiveData<List<Login>> = repository.getAllLoginDetails()

    fun insertcard(card: Card){
        GlobalScope.launch(Dispatchers.IO) {
            repository.insertcard(card)
        }
    }
    fun insertlogin(login: Login){
        GlobalScope.launch(Dispatchers.IO) {
            repository.insertlogin(login)
        }
    }
    fun deletelogin(login: Login){
        GlobalScope.launch(Dispatchers.IO) {
            repository.deletelogin(login)
        }
    }
    fun deletecard(card: Card){
        GlobalScope.launch(Dispatchers.IO) {
            repository.deletecard(card)
        }
    }
    fun allcard(): LiveData<List<Card>> {
        return cardlist
    }
    fun alllogin(): LiveData<List<Login>> {
        return loginlist
    }

}