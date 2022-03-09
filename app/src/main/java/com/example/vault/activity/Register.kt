package com.example.vault.activity

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.BoringLayout
import android.view.TextureView
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.vault.R
import com.example.vault.model.Login
import com.example.vault.utils.Constants.Companion.Masterpassword
import com.example.vault.utils.Constants.Companion.pin
import kotlinx.android.synthetic.main.activity_lock.*
import kotlinx.android.synthetic.main.activity_register.*

class Register : AppCompatActivity(),View.OnClickListener {
    private var masterpassword:String=""
    private var count:Int=0
    private var onConfirmation:Boolean=false
    private var tempmasterpassword=""
    private lateinit var pref:SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        pref=getSharedPreferences("password", Context.MODE_PRIVATE)
        setContentView(R.layout.activity_register)
        if(pref.contains(pin)){
            val i=Intent(this,LockActivity::class.java)
            i.putExtra(pin,pref.getString(pin,"xyz"))
            startActivity(i)
            finish()

        }
        setupclicklistener()
    }

    private fun setupclicklistener() {
        rnumber0.setOnClickListener(this)
        rnumber1.setOnClickListener(this)
        rnumber2.setOnClickListener(this)
        rnumber3.setOnClickListener(this)
        rnumber4.setOnClickListener(this)
        rnumber5.setOnClickListener(this)
        rnumber6.setOnClickListener(this)
        rnumber7.setOnClickListener(this)
        rnumber8.setOnClickListener(this)
        rnumber9.setOnClickListener(this)
        rnumberDelete.setOnClickListener(this)
        rnext.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(p0: View?) {
       when(p0!!.id){
             R.id.rnumber0->{
                         p0 as TextView
                         count++
                         masterpassword+=p0.text
                         if(count==4  && !onConfirmation    ){
                            rpasswordFourth.setImageResource(R.drawable.password_entered)
                            rdemoText.text="Confirm Pin"
                            onConfirmation=true
                            uncheckPasswordView()
                            count=0
                            tempmasterpassword=masterpassword
                            masterpassword=""
                         }
                         else if(count==4 && onConfirmation){
                             rpasswordFourth.setImageResource(R.drawable.password_entered)
                             if(masterpassword==tempmasterpassword){
                                 Masterpassword=masterpassword
                                 val editor=pref.edit()
                                 editor.putString("PIN",masterpassword)
                                 editor.commit()
                                }
                               else{
                                   demoText.text="Wrong Pin"
                                   count=0
                                   uncheckPasswordView()
                                   masterpassword=""
                                }
                         }
                       else{
                           when(count){
                               1 -> rpasswordFirst.setImageResource(R.drawable.password_entered)
                               2 -> rpasswordSecond.setImageResource(R.drawable.password_entered)
                               3 -> rpasswordThird.setImageResource(R.drawable.password_entered)
                               4 -> rpasswordFourth.setImageResource(R.drawable.password_entered)
                           }
                         }

             }
           R.id.rnumber1->{
               p0 as TextView
               count++
               masterpassword+=p0.text
               if(count==4  && !onConfirmation    ){
                   rpasswordFourth.setImageResource(R.drawable.password_entered)
                   rdemoText.text="Confirm Pin"
                   onConfirmation=true
                   uncheckPasswordView()
                   count=0
                   tempmasterpassword=masterpassword
                   masterpassword=""
               }
               else if(count==4 && onConfirmation){
                   rpasswordFourth.setImageResource(R.drawable.password_entered)
                   if(masterpassword==tempmasterpassword){
                       Masterpassword=masterpassword
                       val editor=pref.edit()
                       editor.putString("PIN",masterpassword)
                       editor.commit()
                   }
                   else{
                       demoText.text="Wrong Pin"
                       count=0
                       uncheckPasswordView()
                       masterpassword=""
                   }
               }
               else{
                   when(count){
                       1 -> rpasswordFirst.setImageResource(R.drawable.password_entered)
                       2 -> rpasswordSecond.setImageResource(R.drawable.password_entered)
                       3 -> rpasswordThird.setImageResource(R.drawable.password_entered)
                       4 -> rpasswordFourth.setImageResource(R.drawable.password_entered)
                   }
               }
           }
           R.id.rnumber2->{
               p0 as TextView
               count++
               masterpassword+=p0.text
               if(count==4  && !onConfirmation    ){
                   rpasswordFourth.setImageResource(R.drawable.password_entered)
                   rdemoText.text="Confirm Pin"
                   onConfirmation=true
                   uncheckPasswordView()
                   count=0
                   tempmasterpassword=masterpassword
                   masterpassword=""
               }
               else if(count==4 && onConfirmation){
                   rpasswordFourth.setImageResource(R.drawable.password_entered)
                   if(masterpassword==tempmasterpassword){
                       Masterpassword=masterpassword
                       val editor=pref.edit()
                       editor.putString("PIN",masterpassword)
                       editor.commit()
                   }
                   else{
                       demoText.text="Wrong Pin"
                       count=0
                       uncheckPasswordView()
                       masterpassword=""
                   }
               }
               else{
                   when(count){
                       1 -> rpasswordFirst.setImageResource(R.drawable.password_entered)
                       2 -> rpasswordSecond.setImageResource(R.drawable.password_entered)
                       3 -> rpasswordThird.setImageResource(R.drawable.password_entered)
                       4 -> rpasswordFourth.setImageResource(R.drawable.password_entered)
                   }
               }
           }
           R.id.rnumber3->{
               p0 as TextView
               count++
               masterpassword+=p0.text
               if(count==4  && !onConfirmation    ){
                   rpasswordFourth.setImageResource(R.drawable.password_entered)
                   rdemoText.text="Confirm Pin"
                   onConfirmation=true
                   uncheckPasswordView()
                   count=0
                   tempmasterpassword=masterpassword
                   masterpassword=""
               }
               else if(count==4 && onConfirmation){
                   rpasswordFourth.setImageResource(R.drawable.password_entered)
                   if(masterpassword==tempmasterpassword){
                       Masterpassword=masterpassword
                       val editor=pref.edit()
                       editor.putString("PIN",masterpassword)
                       editor.commit()
                   }
                   else{
                       demoText.text="Wrong Pin"
                       count=0
                       uncheckPasswordView()
                       masterpassword=""
                   }
               }
               else{
                   when(count){
                       1 -> rpasswordFirst.setImageResource(R.drawable.password_entered)
                       2 -> rpasswordSecond.setImageResource(R.drawable.password_entered)
                       3 -> rpasswordThird.setImageResource(R.drawable.password_entered)
                       4 -> rpasswordFourth.setImageResource(R.drawable.password_entered)
                   }
               }
           }
           R.id.rnumber4->{
               p0 as TextView
               count++
               masterpassword+=p0.text
               if(count==4  && !onConfirmation    ){
                   rpasswordFourth.setImageResource(R.drawable.password_entered)
                   rdemoText.text="Confirm Pin"
                   onConfirmation=true
                   uncheckPasswordView()
                   count=0
                   tempmasterpassword=masterpassword
                   masterpassword=""
               }
               else if(count==4 && onConfirmation){
                   rpasswordFourth.setImageResource(R.drawable.password_entered)
                   if(masterpassword==tempmasterpassword){
                       Masterpassword=masterpassword
                       val editor=pref.edit()
                       editor.putString("PIN",masterpassword)
                       editor.commit()
                   }
                   else{
                       demoText.text="Wrong Pin"
                       count=0
                       uncheckPasswordView()
                       masterpassword=""
                   }
               }
               else{
                   when(count){
                       1 -> rpasswordFirst.setImageResource(R.drawable.password_entered)
                       2 -> rpasswordSecond.setImageResource(R.drawable.password_entered)
                       3 -> rpasswordThird.setImageResource(R.drawable.password_entered)
                       4 -> rpasswordFourth.setImageResource(R.drawable.password_entered)
                   }
               }
           }
           R.id.rnumber5->{
               p0 as TextView
               count++
               masterpassword+=p0.text
               if(count==4  && !onConfirmation    ){
                   rpasswordFourth.setImageResource(R.drawable.password_entered)
                   rdemoText.text="Confirm Pin"
                   onConfirmation=true
                   uncheckPasswordView()
                   count=0
                   tempmasterpassword=masterpassword
                   masterpassword=""
               }
               else if(count==4 && onConfirmation){
                   rpasswordFourth.setImageResource(R.drawable.password_entered)
                   if(masterpassword==tempmasterpassword){
                       Masterpassword=masterpassword
                       val editor=pref.edit()
                       editor.putString("PIN",masterpassword)
                       editor.commit()
                   }
                   else{
                       demoText.text="Wrong Pin"
                       count=0
                       uncheckPasswordView()
                       masterpassword=""
                   }
               }
               else{
                   when(count){
                       1 -> rpasswordFirst.setImageResource(R.drawable.password_entered)
                       2 -> rpasswordSecond.setImageResource(R.drawable.password_entered)
                       3 -> rpasswordThird.setImageResource(R.drawable.password_entered)
                       4 -> rpasswordFourth.setImageResource(R.drawable.password_entered)
                   }
               }
           }
           R.id.rnumber6->{
               p0 as TextView
               count++
               masterpassword+=p0.text
               if(count==4  && !onConfirmation    ){
                   rpasswordFourth.setImageResource(R.drawable.password_entered)
                   rdemoText.text="Confirm Pin"
                   onConfirmation=true
                   uncheckPasswordView()
                   count=0
                   tempmasterpassword=masterpassword
                   masterpassword=""
               }
               else if(count==4 && onConfirmation){
                   rpasswordFourth.setImageResource(R.drawable.password_entered)
                   if(masterpassword==tempmasterpassword){
                       Masterpassword=masterpassword
                       val editor=pref.edit()
                       editor.putString("PIN",masterpassword)
                       editor.commit()
                   }
                   else{
                       demoText.text="Wrong Pin"
                       count=0
                       uncheckPasswordView()
                       masterpassword=""
                   }
               }
               else{
                   when(count){
                       1 -> rpasswordFirst.setImageResource(R.drawable.password_entered)
                       2 -> rpasswordSecond.setImageResource(R.drawable.password_entered)
                       3 -> rpasswordThird.setImageResource(R.drawable.password_entered)
                       4 -> rpasswordFourth.setImageResource(R.drawable.password_entered)
                   }
               }
           }
           R.id.rnumber7->{
               p0 as TextView
               count++
               masterpassword+=p0.text
               if(count==4  && !onConfirmation    ){
                   rpasswordFourth.setImageResource(R.drawable.password_entered)
                   rdemoText.text="Confirm Pin"
                   onConfirmation=true
                   uncheckPasswordView()
                   count=0
                   tempmasterpassword=masterpassword
                   masterpassword=""
               }
               else if(count==4 && onConfirmation){
                   rpasswordFourth.setImageResource(R.drawable.password_entered)
                   if(masterpassword==tempmasterpassword){
                       Masterpassword=masterpassword
                       val editor=pref.edit()
                       editor.putString("PIN",masterpassword)
                       editor.commit()
                   }
                   else{
                       demoText.text="Wrong Pin"
                       count=0
                       uncheckPasswordView()
                       masterpassword=""
                   }
               }
               else{
                   when(count){
                       1 -> rpasswordFirst.setImageResource(R.drawable.password_entered)
                       2 -> rpasswordSecond.setImageResource(R.drawable.password_entered)
                       3 -> rpasswordThird.setImageResource(R.drawable.password_entered)
                       4 -> rpasswordFourth.setImageResource(R.drawable.password_entered)
                   }
               }
           }
           R.id.rnumber8->{
               p0 as TextView
               count++
               masterpassword+=p0.text
               if(count==4  && !onConfirmation    ){
                   rpasswordFourth.setImageResource(R.drawable.password_entered)
                   rdemoText.text="Confirm Pin"
                   onConfirmation=true
                   uncheckPasswordView()
                   count=0
                   tempmasterpassword=masterpassword
                   masterpassword=""
               }
               else if(count==4 && onConfirmation){
                   rpasswordFourth.setImageResource(R.drawable.password_entered)
                   if(masterpassword==tempmasterpassword){
                       Masterpassword=masterpassword
                       val editor=pref.edit()
                       editor.putString("PIN",masterpassword)
                       editor.commit()
                   }
                   else{
                       demoText.text="Wrong Pin"
                       count=0
                       uncheckPasswordView()
                       masterpassword=""
                   }
               }
               else{
                   when(count){
                       1 -> rpasswordFirst.setImageResource(R.drawable.password_entered)
                       2 -> rpasswordSecond.setImageResource(R.drawable.password_entered)
                       3 -> rpasswordThird.setImageResource(R.drawable.password_entered)
                       4 -> rpasswordFourth.setImageResource(R.drawable.password_entered)
                   }
               }
           }
           R.id.rnumber9->{
               p0 as TextView
               count++
               masterpassword+=p0.text
               if(count==4  && !onConfirmation    ){
                   rpasswordFourth.setImageResource(R.drawable.password_entered)
                   rdemoText.text="Confirm Pin"
                   onConfirmation=true
                   uncheckPasswordView()
                   count=0
                   tempmasterpassword=masterpassword
                   masterpassword=""
               }
               else if(count==4 && onConfirmation){
                   rpasswordFourth.setImageResource(R.drawable.password_entered)
                   if(masterpassword==tempmasterpassword){
                       Masterpassword=masterpassword
                       val editor=pref.edit()
                       editor.putString("PIN",masterpassword)
                       editor.commit()
                   }
                   else{
                       demoText.text="Wrong Pin"
                       count=0
                       uncheckPasswordView()
                       masterpassword=""
                   }
               }
               else{
                   when(count){
                       1 -> rpasswordFirst.setImageResource(R.drawable.password_entered)
                       2 -> rpasswordSecond.setImageResource(R.drawable.password_entered)
                       3 -> rpasswordThird.setImageResource(R.drawable.password_entered)
                       4 -> rpasswordFourth.setImageResource(R.drawable.password_entered)
                   }
               }
           }
           R.id.rnumberDelete->{
               masterpassword=masterpassword.substring(0,masterpassword.length-1)

               when(count){
                   1 -> rpasswordFirst.setImageResource(R.drawable.password_not_entered)
                   2 -> rpasswordSecond.setImageResource(R.drawable.password_not_entered)
                   3 -> rpasswordThird.setImageResource(R.drawable.password_not_entered)
                   4 -> rpasswordFourth.setImageResource(R.drawable.password_not_entered)
               }
               count--
           }
           R.id.rnext->{
                   val i=Intent(this,LockActivity::class.java)
                   i.putExtra(pin,masterpassword)
                   startActivity(i)
                   finish()
           }


       }
    }
    private fun uncheckPasswordView() {
        rpasswordFirst.setImageResource(R.drawable.password_not_entered)
        rpasswordSecond.setImageResource(R.drawable.password_not_entered)
        rpasswordThird.setImageResource(R.drawable.password_not_entered)
        rpasswordFourth.setImageResource(R.drawable.password_not_entered)
    }
}

