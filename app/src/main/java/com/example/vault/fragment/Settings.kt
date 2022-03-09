package com.example.vault.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.vault.R
import com.example.vault.utils.Constants.Companion.Masterpassword
import com.example.vault.utils.Constants.Companion.pin
import kotlinx.android.synthetic.main.fragment_settings.*


class Settings : Fragment() {
    private lateinit var pref:SharedPreferences
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_settings, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        pref = requireActivity().getSharedPreferences("password", Context.MODE_PRIVATE)

        if (pref.contains(pin)) {
            val mpassword= Masterpassword
            changepin.setOnClickListener {
                Log.i("SharedPreferences", mpassword)
                if (oldpin.text.toString() == mpassword) {
                    if (confirmpin.text.toString() == newpin.text.toString()) {
                        val editor = pref.edit()
                        editor.putString("PIN", confirmpin.text.toString())
                        editor.commit()
                        Masterpassword=confirmpin.toString()
                    }
                } else {
                    Toast.makeText(requireContext(), "Wrong Pin", Toast.LENGTH_LONG).show()
                }
            }

        }
    }

}