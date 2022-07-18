package com.example.vault.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.vault.R
import com.example.vault.database.CardDatabase
import com.example.vault.database.LoginDatabase
import com.example.vault.model.Login
import com.example.vault.repository.Repository
import com.example.vault.viewmodel.DetailsViewModel
import com.example.vault.viewmodel.DetailsViewModelFactory
import kotlinx.android.synthetic.main.fragment_add_login.*
import kotlinx.android.synthetic.main.fragment_update_login.*
import kotlinx.android.synthetic.main.fragment_update_login.view.*
import kotlinx.android.synthetic.main.login_dialog.*
import kotlinx.android.synthetic.main.login_list.*
import kotlinx.android.synthetic.main.login_list.view.*
import java.text.SimpleDateFormat
import java.util.*


class UpdateLogin : Fragment() {
    private lateinit var vm: DetailsViewModel
    private lateinit var rp: Repository
    private lateinit var cardDatabase: CardDatabase
    private lateinit var loginDatabase: LoginDatabase
    private val categorylist = arrayListOf("E-Commerce","Work","Social","Others")
  private val args by navArgs<UpdateLoginArgs>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
         val v = inflater.inflate(R.layout.fragment_update_login, container, false)

         v.uloginEmailEt.setText(args.currentItem.loginId)
         v.uloginPasswordEt.setText(args.currentItem.loginPassword)
         v.uloginWebsiteEt.setText(args.currentItem.loginwebsite)
         v.ucategory.text=args.currentItem.category
         return v
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUPSpinner()
        cardDatabase = CardDatabase.getDatabase(requireContext())
        loginDatabase = LoginDatabase.getDatabase(requireContext())
        rp = Repository(cardDatabase, loginDatabase)
        vm = ViewModelProvider(this, DetailsViewModelFactory(rp)).get(DetailsViewModel::class.java)
        updateBtn.setOnClickListener {
                   if(valid(uloginEmailEt.text.toString(),uloginPasswordEt.text.toString(),uloginWebsiteEt.text.toString())){
                       Log.i("Fragment",uloginWebsiteEt.toString())
                       val sdf= SimpleDateFormat("MM/dd/yyy")
                       val currentd=sdf.format(Date())
                       val curr=Login(uloginEmailEt.text.toString(),uloginPasswordEt.text.toString(),uloginWebsiteEt.text.toString(),uadd_login_spinner.selectedItem.toString(),currentd,uloginNoteEt.text.toString(),args.currentItem.id)
                       vm.updatelogin(curr)
                       findNavController().navigate(R.id.loginFragment)
                   }
            else{
                Toast.makeText(requireContext(),"Empty boxes are present",Toast.LENGTH_LONG).show()
             }
        }
    }
    private fun valid(loginName: String, loginEmail: String, loginPassword: String): Boolean {

        return !(loginName.isEmpty() || loginEmail.isEmpty() || loginPassword.isEmpty())
    }
    private fun setUPSpinner() {
        val adapter = ArrayAdapter<String>(requireContext(), R.layout.support_simple_spinner_dropdown_item, categorylist)
        categorylist.sort()
        uadd_login_spinner.adapter = adapter
    }

}