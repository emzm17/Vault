package com.example.vault.utils

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.ListFragment
import androidx.navigation.fragment.findNavController
import com.example.vault.R
import com.example.vault.model.Login
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.login_dialog.*


class Dialog(private var login: Login) : BottomSheetDialogFragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.login_dialog, container, false)

    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loginEmaildisplay.text = login.loginId
        loginPassworddisplay.text = login.loginPassword
        loginWebsitedisplayname.text = login.loginwebsite
        loginCategorydisplay.text = login.category
        loginwebsitego.text="www.${loginWebsitedisplayname.text}.com"
        copyEmail.setOnClickListener {
            val textcopy = loginEmaildisplay.text
            val clipboardManager =
                requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Copy", textcopy)
            clipboardManager.setPrimaryClip(clip)
        }

        copyPassword.setOnClickListener {
            val textcopy = loginEmaildisplay.text
            val clipboardManager =
                requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Copy", textcopy)
            clipboardManager.setPrimaryClip(clip)
        }
        gotowebsite.setOnClickListener {
            val temp="http://www.${loginWebsitedisplayname.text}.com"
               val i= Intent(Intent.ACTION_VIEW)
               i.setData(Uri.parse(temp))
               startActivity(i)
        }


    }
}