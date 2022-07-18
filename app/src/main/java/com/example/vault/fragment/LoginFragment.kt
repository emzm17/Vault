package com.example.vault.fragment

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.AlertDialog.*
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.util.Log
import android.view.*
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.vault.R
import com.example.vault.adapter.LoginAdapter
import com.example.vault.database.CardDatabase
import com.example.vault.database.LoginDatabase
import com.example.vault.model.Login
import com.example.vault.repository.Repository
import com.example.vault.utils.Constants.Companion.Masterpassword
import com.example.vault.viewmodel.DetailsViewModel
import com.example.vault.viewmodel.DetailsViewModelFactory
import com.example.vault.utils.Dialog
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.password_dialog.*
import java.util.zip.Inflater

class LoginFragment : Fragment(), LoginAdapter.OnItemClickListener ,LoginAdapter.OnItemEditClickListener{
    private lateinit var vm: DetailsViewModel
    private lateinit var adapter: LoginAdapter
    private lateinit var rp: Repository
    private lateinit var cardDatabase: CardDatabase
    private lateinit var loginDatabase: LoginDatabase
    private val loginList= arrayListOf<Login>()
    private lateinit var mpassword:String
    override fun onCreateView(
      inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        mpassword=""

        cardDatabase = CardDatabase.getDatabase(requireContext())
        loginDatabase = LoginDatabase.getDatabase(requireContext())
        rp = Repository(cardDatabase, loginDatabase)
        vm = ViewModelProvider(this, DetailsViewModelFactory(rp)).get(DetailsViewModel::class.java)
        adapter = LoginAdapter(requireContext(),loginList,this,this)
        login_rcview.layoutManager = LinearLayoutManager(requireContext())
        login_rcview.adapter = adapter
        setupCategory()

        vm.allLogin().observe(viewLifecycleOwner) { l ->
             if(!l.isNullOrEmpty()){
                 loginList.clear()
                 loginList.addAll(l)
                 adapter.notifyDataSetChanged()
             }
             else{
                 loginList.clear()
                 adapter.notifyDataSetChanged()
             }
        }
        /*
        val itemTouchHelper=object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.RIGHT
        )
           {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            @SuppressLint("NotifyDataSetChanged")
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
               var position:Int=-1
                when(direction){
                    ItemTouchHelper.RIGHT->{
                        vm.deletelogin(adapter.getItemId(viewHolder.absoluteAdapterPosition))

                    }
                }


            }


        }

        ItemTouchHelper(itemTouchHelper).apply {
            attachToRecyclerView(login_rcview)
        }
        */




        LoginAdd.setOnClickListener {
             val action=LoginFragmentDirections.actionLoginFragmentToAddLoginFragment()
             findNavController().navigate(action)
        }


    }

    override fun OnItemClick(position: Int) {

                val d = Dialog(loginList[position])
                d.show(requireActivity().supportFragmentManager, "dialog")

    }

    override fun OnEditItemClick(position: Int) {
        alertdialog(position)

    }


    private fun alertdialog(position: Int){
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Edit")
        builder.setMessage("Are are sure you want to Edit?")
        builder.setPositiveButton("Yes" ){ dialog: DialogInterface, i: Int ->
            val action=LoginFragmentDirections.actionLoginFragmentToUpdateLogin(loginList[position])
            findNavController().navigate(action)
            dialog.dismiss()

        }
        builder.setNegativeButton("No"){ dialog:DialogInterface,i:Int->
            dialog.dismiss()
        }
        val alertDialog=builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }
    private fun setupCategory(){
         filterECommerceButton.setOnClickListener {
               vm.category(
                   "E-Commerce"
               ).observe(viewLifecycleOwner){
                     adapter.update(it)
               }
         }
         filterSocialButton.setOnClickListener {
             vm.category(
                 "Social"
             ).observe(viewLifecycleOwner){
                 adapter.update(it)
             }
         }
         filterWorkButton.setOnClickListener {

             vm.category(
                 "Work"
             ).observe(viewLifecycleOwner){
                 adapter.update(it)
             }
         }
         filterOtherButton.setOnClickListener {
             vm.category(
                 "Others"
             ).observe(viewLifecycleOwner){
                 adapter.update(it)
             }
         }
        filterAll.setOnClickListener {
               vm.allLogin().observe(viewLifecycleOwner){
                      adapter.update(it)
               }
        }
    }
    private fun PasswordCheck(position: Long){

    }



}
