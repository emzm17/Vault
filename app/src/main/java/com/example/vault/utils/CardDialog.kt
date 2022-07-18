package com.example.vault.utils

import android.annotation.SuppressLint
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.vault.R
import com.example.vault.model.Card

import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlinx.android.synthetic.main.card_dialog.*
import kotlinx.android.synthetic.main.card_item.*
import kotlinx.android.synthetic.main.login_dialog.*

class CardDialog(private var card: Card): BottomSheetDialogFragment()  {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return  inflater.inflate(R.layout.card_dialog, container, false)
    }

    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        cardHodlerNameisplay.text=card.cardHolder
        cardCVVdisplay.text=card.cardCvv
        cardExpirydisplay.text="${card.cardExpiryMonth}/${card.cardExpiryYear}"
        cardTypedisplay.text=card.cardType
        cardNumberDispaly.text=card.cardNumber
        updatetime.text="Update on ${card.creatAt}"

        cardExpiryCopy.setOnClickListener{
            val textcopy = cardExpiry.text
            val clipboardManager =
                requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Copy", textcopy)
            clipboardManager.setPrimaryClip(clip)
            Toast.makeText(requireContext(),"Copied", Toast.LENGTH_SHORT).show()
        }
        cardNumberCopy.setOnClickListener {
            val textcopy = cardNumberDispaly.text
            val clipboardManager =
                requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Copy", textcopy)
            clipboardManager.setPrimaryClip(clip)
            Toast.makeText(requireContext(),"Copied", Toast.LENGTH_SHORT).show()
        }
        cardHolderNameCopy.setOnClickListener {
            val textcopy = cardHodlerNameisplay.text
            val clipboardManager =
                requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Copy", textcopy)
            clipboardManager.setPrimaryClip(clip)
            Toast.makeText(requireContext(),"Copied", Toast.LENGTH_SHORT).show()
        }
        cardCVVcopy.setOnClickListener {
            val textcopy = cardCVVdisplay.text
            val clipboardManager =
                requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clip = ClipData.newPlainText("Copy", textcopy)
            clipboardManager.setPrimaryClip(clip)
            Toast.makeText(requireContext(),"Copied", Toast.LENGTH_SHORT).show()
        }
    }

}