package com.example.vault.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.vault.R
import com.example.vault.activity.MainActivity
import com.example.vault.database.CardDatabase
import com.example.vault.database.LoginDatabase
import com.example.vault.model.Login
import com.example.vault.repository.Repository
import com.example.vault.viewmodel.DetailsViewModel
import com.example.vault.viewmodel.DetailsViewModelFactory
import kotlinx.android.synthetic.main.fragment_add_login.*
import java.text.SimpleDateFormat
import java.util.*


class AddLoginFragment : Fragment() {
    private lateinit var username: String
    private lateinit var userpassword: String
    private lateinit var website: String
    private lateinit var vm: DetailsViewModel
    private lateinit var rp: Repository
    private lateinit var cardDatabase: CardDatabase
    private lateinit var loginDatabase: LoginDatabase
    private val categorylist = arrayListOf("E-Commerce","Work","Social","Others")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUPSpinner()
        cardDatabase = CardDatabase.getDatabase(requireContext())
        loginDatabase = LoginDatabase.getDatabase(requireContext())
        rp = Repository(cardDatabase, loginDatabase)
        vm = ViewModelProvider(this, DetailsViewModelFactory(rp)).get(DetailsViewModel::class.java)
        addLoginBtn.setOnClickListener {
            if (valid(
                    loginEmailEt.text.toString(),
                    loginWebsiteEt.text.toString(),
                    loginPasswordEt.text.toString()
                )
            ) {
                SaveLoginCredentials()
                Toast.makeText(requireContext(), "lOGIN DATA SAVED", Toast.LENGTH_LONG).show()
                val action=AddLoginFragmentDirections.actionAddLoginFragmentToLoginFragment2()
                findNavController().navigate(action)
            } else {
                Toast.makeText(
                    requireContext(),
                    "SOMETHING WENT WRONG PLEASE RECHECK FILLED ITEMS ",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    }
    @SuppressLint("SimpleDateFormat")
    private fun SaveLoginCredentials() {
        username = loginEmailEt.text.toString()
        userpassword = loginPasswordEt.text.toString()
        website = loginWebsiteEt.text.toString()
        val notes=loginNoteEt.text.toString()
        var selected = add_login_spinner.selectedItem.toString()
        val sdf=SimpleDateFormat("MM/dd/yyy")
        val currentd=sdf.format(Date())
        vm.insertlogin(Login(username, userpassword, website,selected,currentd.toString(),notes))
    }

    private fun valid(loginName: String, loginEmail: String, loginPassword: String): Boolean {

        return !(loginName.isEmpty() || loginEmail.isEmpty() || loginPassword.isEmpty())
    }

    private fun setUPSpinner() {
        val adapter = ArrayAdapter<String>(requireContext(), R.layout.support_simple_spinner_dropdown_item, categorylist)
        categorylist.sort()
        add_login_spinner.adapter = adapter
    }


}