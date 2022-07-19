package com.example.vault.fragment

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.app.AlertDialog.*
import android.content.DialogInterface
import android.os.Bundle
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vault.R
import com.example.vault.adapter.LoginAdapter
import com.example.vault.database.CardDatabase
import com.example.vault.database.LoginDatabase
import com.example.vault.model.Login
import com.example.vault.repository.Repository
import com.example.vault.viewmodel.DetailsViewModel
import com.example.vault.viewmodel.DetailsViewModelFactory
import com.example.vault.utils.Dialog
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.view.*
import kotlinx.android.synthetic.main.password_dialog.*

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
        setupCategory()



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
          performOptionsMenu(position)
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

   private fun performOptionsMenu(position: Int){
       val menu=PopupMenu(requireContext(),login_rcview[position].findViewById(R.id.edit_login))
       menu.inflate(R.menu.item_click)
       menu.setOnMenuItemClickListener { p0 ->
           when (p0?.itemId) {
               R.id.delete -> {
                   passwordCheck(position)
                   //vm.deletelogin(adapter.getItemId(position))
               }
               R.id.edit -> {
                   alertdialog(position)
               }
               R.id.archive->{

               }
           }
           false
       }
       menu.show()
   }
    private fun passwordCheck(position: Int){
        val view=LayoutInflater.from(requireContext()).inflate(R.layout.password_dialog,null,false)
        val builder=AlertDialog.Builder(requireContext())
        with(builder){
            setTitle("Enter your Pin")
            setPositiveButton("Ok"){dialog,which->
                     if(pin_text.text.toString()=="1234"){
                         Toast.makeText(requireContext(),"Right Pin",Toast.LENGTH_LONG).show()
                     }
                     else{
                         pin_text.requestFocus()
                         pin_text.error="Incorrect"
                     }
            }
            setCancelable(false)
            setNegativeButton("Cancel"){dialog,which->
                 dialog.dismiss()
            }
            setView(view)
            show()
        }
    }


}
