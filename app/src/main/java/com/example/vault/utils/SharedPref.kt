package com.example.vault.utils

import android.content.Context
import android.content.SharedPreferences

class SharedPref(context: Context){
    private var sharedPref: SharedPreferences = context.getSharedPreferences("VAULT",0)
    fun setString(key:String,value:String){
        sharedPref.edit().putString(key,value).commit()
    }
    fun isThere(key: String):Boolean{
         if(sharedPref.contains(key)) return true
         return false
    }
    fun getString(key: String):String?{
        return sharedPref.getString(key,"")
    }
}