package com.example.vault.activity

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.vault.R
import com.example.vault.utils.Constants.Companion.pin
import kotlinx.android.synthetic.main.activity_lock.*
import kotlinx.android.synthetic.main.login_list.*

class LockActivity : AppCompatActivity() ,View.OnClickListener{
    private var password: String = ""
    private var count: Int = 0
    private lateinit var masterPassword: String
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lock)
        masterPassword=intent.getStringExtra(pin).toString()
        setupOnclickListener()

        }
    @SuppressLint("SetTextI18n")
    override fun onClick(p0: View?) {
        when (p0!!.id) {
            R.id.number0 -> {
                p0 as TextView
                count++
                password += p0.text
                if(count==4){
                    passwordFourth.setImageResource(R.drawable.password_entered)

                    if(password==masterPassword) {
                        startActivity(Intent(this, MainActivity::class.java))
                        finish()
                    }
                    else{
                        Toast.makeText(this,"Wrong Pin Try Again",Toast.LENGTH_LONG).show()
                        count=0;
                        uncheckPasswordView()
                        demoText.text="Re-Enter Pin"
                        password=""
                    }
                }
                else{
                    when(count){
                        1 -> passwordFirst.setImageResource(R.drawable.password_entered)
                        2 -> passwordSecond.setImageResource(R.drawable.password_entered)
                        3 -> passwordThird.setImageResource(R.drawable.password_entered)
                        4 -> passwordFourth.setImageResource(R.drawable.password_entered)
                    }
                }
            }
            R.id.number1 -> {
                p0 as TextView
                count++
                password += p0.text
                if(count==4){
                    passwordFourth.setImageResource(R.drawable.password_entered)
                    if(password==masterPassword){
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    }
                    else{
                        Toast.makeText(this,"Wrong Pin Try Again",Toast.LENGTH_LONG).show()
                        count=0;
                        uncheckPasswordView()
                        demoText.text="Re-Enter Pin"
                        password=""
                    }
                }
                else{
                    when(count){
                        1 -> passwordFirst.setImageResource(R.drawable.password_entered)
                        2 -> passwordSecond.setImageResource(R.drawable.password_entered)
                        3 -> passwordThird.setImageResource(R.drawable.password_entered)
                        4 -> passwordFourth.setImageResource(R.drawable.password_entered)
                    }
                }
            }
            R.id.number2 -> {
                p0 as TextView
                count++
                password += p0.text
                if(count==4){
                    passwordFourth.setImageResource(R.drawable.password_entered)
                    if(password==masterPassword){
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    }
                    else{
                        Toast.makeText(this,"Wrong Pin Try Again",Toast.LENGTH_LONG).show()
                        count=0;
                        uncheckPasswordView()
                        demoText.text="Re-Enter Pin"
                        password=""
                    }
                }
                else{
                    when(count){
                        1 -> passwordFirst.setImageResource(R.drawable.password_entered)
                        2 -> passwordSecond.setImageResource(R.drawable.password_entered)
                        3 -> passwordThird.setImageResource(R.drawable.password_entered)
                        4 -> passwordFourth.setImageResource(R.drawable.password_entered)
                    }
                }
            }

            R.id.number3 -> {
                p0 as TextView
                count++
                password += p0.text
                if(count==4){
                    passwordFourth.setImageResource(R.drawable.password_entered)
                    if(password==masterPassword){
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    }
                    else{
                        Toast.makeText(this,"Wrong Pin Try Again",Toast.LENGTH_LONG).show()
                        count=0;
                        uncheckPasswordView()
                        demoText.text="Re-Enter Pin"
                        password=""
                    }
                }
                else{
                    when(count){
                        1 -> passwordFirst.setImageResource(R.drawable.password_entered)
                        2 -> passwordSecond.setImageResource(R.drawable.password_entered)
                        3 -> passwordThird.setImageResource(R.drawable.password_entered)
                        4 -> passwordFourth.setImageResource(R.drawable.password_entered)
                    }
                }
            }

            R.id.number4 -> {
                p0 as TextView
                count++
                password += p0.text
                if(count==4){
                    passwordFourth.setImageResource(R.drawable.password_entered)
                    if(password==masterPassword){
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    }
                    else{
                        Toast.makeText(this,"Wrong Pin Try Again",Toast.LENGTH_LONG).show()
                        count=0;
                        uncheckPasswordView()
                        demoText.text="Re-Enter Pin"
                        password=""
                    }
                }
                else{
                    when(count){
                        1 -> passwordFirst.setImageResource(R.drawable.password_entered)
                        2 -> passwordSecond.setImageResource(R.drawable.password_entered)
                        3 -> passwordThird.setImageResource(R.drawable.password_entered)
                        4 -> passwordFourth.setImageResource(R.drawable.password_entered)
                    }
                }
            }

            R.id.number5 -> {
                p0 as TextView
                count++
                password += p0.text
                if(count==4){
                    passwordFourth.setImageResource(R.drawable.password_entered)
                    if(password==masterPassword){
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    }
                    else{
                        Toast.makeText(this,"Wrong Pin Try Again",Toast.LENGTH_LONG).show()
                        count=0;
                        uncheckPasswordView()
                        demoText.text="Re-Enter Pin"
                        password=""
                    }
                }
                else{
                    when(count){
                        1 -> passwordFirst.setImageResource(R.drawable.password_entered)
                        2 -> passwordSecond.setImageResource(R.drawable.password_entered)
                        3 -> passwordThird.setImageResource(R.drawable.password_entered)
                        4 -> passwordFourth.setImageResource(R.drawable.password_entered)
                    }
                }
            }

            R.id.number6 -> {
                p0 as TextView
                count++
                password += p0.text
                if(count==4){
                    passwordFourth.setImageResource(R.drawable.password_entered)
                    if(password==masterPassword){
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    }
                    else{
                        Toast.makeText(this,"Wrong Pin Try Again",Toast.LENGTH_LONG).show()
                        count=0;
                        uncheckPasswordView()
                        demoText.text="Re-Enter Pin"
                        password=""
                    }
                }
                else{
                    when(count){
                        1 -> passwordFirst.setImageResource(R.drawable.password_entered)
                        2 -> passwordSecond.setImageResource(R.drawable.password_entered)
                        3 -> passwordThird.setImageResource(R.drawable.password_entered)
                        4 -> passwordFourth.setImageResource(R.drawable.password_entered)
                    }
                }
            }

            R.id.number7 -> {
                p0 as TextView
                count++
                password += p0.text
                if(count==4){
                    passwordFourth.setImageResource(R.drawable.password_entered)
                    if(password==masterPassword){
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    }
                    else{
                        Toast.makeText(this,"Wrong Pin Try Again",Toast.LENGTH_LONG).show()
                        count=0;
                        uncheckPasswordView()
                        demoText.text="Re-Enter Pin"
                        password=""
                    }
                }
                else{
                    when(count){
                        1 -> passwordFirst.setImageResource(R.drawable.password_entered)
                        2 -> passwordSecond.setImageResource(R.drawable.password_entered)
                        3 -> passwordThird.setImageResource(R.drawable.password_entered)
                        4 -> passwordFourth.setImageResource(R.drawable.password_entered)
                    }
                }
            }
            R.id.number8 -> {
                p0 as TextView
                count++
                password += p0.text
                if(count==4){
                    passwordFourth.setImageResource(R.drawable.password_entered)
                    if(password==masterPassword){
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    }
                    else{
                        Toast.makeText(this,"Wrong Pin Try Again",Toast.LENGTH_LONG).show()
                        count=0;
                        uncheckPasswordView()
                        demoText.text="Re-Enter Pin"
                        password=""
                    }
                }
                else{
                    when(count){
                        1 -> passwordFirst.setImageResource(R.drawable.password_entered)
                        2 -> passwordSecond.setImageResource(R.drawable.password_entered)
                        3 -> passwordThird.setImageResource(R.drawable.password_entered)
                        4 -> passwordFourth.setImageResource(R.drawable.password_entered)
                    }
                }
            }

            R.id.number9 -> {
                p0 as TextView
                count++
                password += p0.text
                if(count==4){
                    passwordFourth.setImageResource(R.drawable.password_entered)
                    if(password==masterPassword){
                        startActivity(Intent(this,MainActivity::class.java))
                        finish()
                    }
                    else{
                        Toast.makeText(this,"Wrong Pin Try Again",Toast.LENGTH_LONG).show()
                        count=0;
                        uncheckPasswordView()
                        demoText.text="Re-Enter Pin"
                        password=""
                    }
                }
                else{
                    when(count){
                        1 -> passwordFirst.setImageResource(R.drawable.password_entered)
                        2 -> passwordSecond.setImageResource(R.drawable.password_entered)
                        3 -> passwordThird.setImageResource(R.drawable.password_entered)
                        4 -> passwordFourth.setImageResource(R.drawable.password_entered)
                    }
                }
            }
            R.id.numberDelete->{
               password=password.substring(0,password.length-1)

                when(count){
                    1 -> passwordFirst.setImageResource(R.drawable.password_not_entered)
                    2 -> passwordSecond.setImageResource(R.drawable.password_not_entered)
                    3 -> passwordThird.setImageResource(R.drawable.password_not_entered)
                    4 -> passwordFourth.setImageResource(R.drawable.password_not_entered)
                }
                count--
            }
        }
    }
    private fun setupOnclickListener() {
        number0.setOnClickListener(this)
        number1.setOnClickListener(this)
        number2.setOnClickListener(this)
        number3.setOnClickListener(this)
        number4.setOnClickListener(this)
        number5.setOnClickListener(this)
        number6.setOnClickListener(this)
        number7.setOnClickListener(this)
        number8.setOnClickListener(this)
        number9.setOnClickListener(this)
        numberDelete.setOnClickListener(this)
    }


    private fun uncheckPasswordView() {
        passwordFirst.setImageResource(R.drawable.password_not_entered)
        passwordSecond.setImageResource(R.drawable.password_not_entered)
        passwordThird.setImageResource(R.drawable.password_not_entered)
        passwordFourth.setImageResource(R.drawable.password_not_entered)
    }
}


