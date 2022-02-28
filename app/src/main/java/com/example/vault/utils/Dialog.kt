package com.example.vault.utils

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        loginEmaildisplay.text = login.loginId
        loginPassworddisplay.text = login.loginPassword
        loginWebsitedisplay.text = login.loginwebsite
        loginCategorydisplay.text = login.category

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
    }
}