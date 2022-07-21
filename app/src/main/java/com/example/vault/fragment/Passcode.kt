package com.example.vault.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.vault.R
import com.example.vault.utils.Constants.Companion.Masterpassword
import com.example.vault.utils.Constants.Companion.pin
import com.example.vault.utils.SharedPref
import kotlinx.android.synthetic.main.fragment_passcode.*


class Passcode : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_passcode, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


            changepin.setOnClickListener {
                if (oldpin.text.toString() == SharedPref(requireContext()).getString("PIN")) {
                    if (confirmpin.text.toString() == newpin.text.toString()) {
                       SharedPref(requireContext()).setString("PIN",newpin.text.toString())
                        val action=PasscodeDirections.actionPasscodeToLoginFragment()
                        findNavController().navigate(action)
                    }
                    else {
                        Toast.makeText(requireContext(), "Pin don't match", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(requireContext(), "Wrong Pin", Toast.LENGTH_LONG).show()
                }
            }

        }


}