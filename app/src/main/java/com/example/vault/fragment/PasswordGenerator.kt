package com.example.vault.fragment

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.vault.R
import kotlinx.android.synthetic.main.fragment_password_generator.*
import kotlinx.android.synthetic.main.fragment_password_generator.copyPassword
import kotlinx.android.synthetic.main.login_dialog.*


class PasswordGenerator : Fragment() {
   private var len:Int = 0
   private var pass:String=""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_password_generator, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       lengthtext.addTextChangedListener {
               generatePassword.isEnabled = !(it!!.length<0 || it.isNullOrEmpty())
       }
       generatePassword.setOnClickListener {
               val list = ArrayList<Char>()
               len=lengthtext.text.toString().toInt()
               if (capitalsSwitch.isChecked) {
                   list.add('A')
               }
               if (smallLetterSwitch.isChecked) {
                   list.add('S')
               }
               if (numberSwitch.isChecked) {
                   list.add('1')
               }
               if (symbolSwitch.isChecked) {
                   list.add('@')
               }
               for (i in 1..len) {
                   when (list.random()) {
                       'A' -> {
                           pass += ('A'..'Z').random().toString()
                       }
                       'S' -> {
                           pass += ('a'..'z').random().toString()
                       }
                       '1' -> {
                           pass += ('0'..'9').random().toString()
                       }
                       '@' -> {
                           pass += listOf(
                               '*',
                               '+',
                               '=',
                               '-',
                               '~',
                               '!',
                               '@',
                               '#',
                               '$',
                               '%',
                               '&'
                           ).random()
                               .toString()
                       }

                   }

               }
               generatedPasswordText.text = pass
               pass=""
           }

           copyPassword.setOnClickListener {
               val textcopy = generatedPasswordText.text
               val clipboardManager =
                   requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
               val clip = ClipData.newPlainText("Copy", textcopy)
               clipboardManager.setPrimaryClip(clip)
                Toast.makeText(requireContext(),"Copied to clipboard", Toast.LENGTH_SHORT).show()
            }


        }




}