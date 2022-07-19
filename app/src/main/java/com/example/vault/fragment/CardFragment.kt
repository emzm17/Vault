package com.example.vault.fragment

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.PopupMenu
import androidx.core.view.get
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vault.R
import com.example.vault.adapter.CardAdapter
import com.example.vault.database.CardDatabase
import com.example.vault.database.LoginDatabase
import com.example.vault.model.Card
import com.example.vault.repository.Repository
import com.example.vault.utils.CardDialog
import com.example.vault.viewmodel.DetailsViewModel
import com.example.vault.viewmodel.DetailsViewModelFactory
import kotlinx.android.synthetic.main.fragment_card.*
import kotlinx.android.synthetic.main.fragment_login.*


class CardFragment : Fragment(),CardAdapter.OnItemClickListener,CardAdapter.OnItemMenuListener{

    private lateinit var vm: DetailsViewModel
    private lateinit var rp: Repository
    private lateinit var cardDatabase: CardDatabase
    private lateinit var loginDatabase: LoginDatabase

    private  var list= arrayListOf<Card>()
    private lateinit var  adapter:CardAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_card, container, false)
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardDatabase = CardDatabase.getDatabase(requireContext())
        loginDatabase = LoginDatabase.getDatabase(requireContext())
        rp = Repository(cardDatabase, loginDatabase)
        vm = ViewModelProvider(this, DetailsViewModelFactory(rp)).get(DetailsViewModel::class.java)
        list=ArrayList()
        adapter= CardAdapter(requireContext(),list,this,this)
        card_rcview.layoutManager=LinearLayoutManager(requireContext())
        card_rcview.adapter=adapter
        setupType()

        vm.allCard().observe(viewLifecycleOwner) { c ->
                if(!c.isNullOrEmpty()){
                   list.clear()
                    list.addAll(c)
                    adapter.notifyDataSetChanged()
                }
            else{
                list.clear()
                adapter.notifyDataSetChanged()
                }
        }
        CardAdd.setOnClickListener {
          val action=CardFragmentDirections.actionCardFragmentToAddCardFragment()
            findNavController().navigate(action)
        }
    }

    override fun OnItemClicked(adapterPosition: Int) {
        val d = CardDialog(list[adapterPosition])
        d.show(requireActivity().supportFragmentManager, "dialog")
    }
    private fun setupType(){
        credit.setOnClickListener {
            vm.type(
                "Credit"
            ).observe(viewLifecycleOwner){
                adapter.update(it)
            }
        }
        debit.setOnClickListener {
            vm.type(
                "Debit"
            ).observe(viewLifecycleOwner) {
                adapter.update(it)
            }
        }
            forex.setOnClickListener {
                vm.type(
                    "Forex"
                ).observe(viewLifecycleOwner) {
                    adapter.update(it)
                }
            }
                prepaid.setOnClickListener {
                    vm.type(
                        "Prepaid"
                    ).observe(viewLifecycleOwner) {
                        adapter.update(it)
                    }
                }
                     others.setOnClickListener {
                         vm.type(
                             "Others"
                         ).observe(viewLifecycleOwner) {
                             adapter.update(it)
                         }
                     }


    }
    override fun onMenuItem(position: Int) {
        performOptionsMenu(position)
    }

    private fun performOptionsMenu(position: Int){
        val menu= PopupMenu(requireContext(),card_rcview[position].findViewById(R.id.edit_card))
        menu.inflate(R.menu.item_click)
        menu.setOnMenuItemClickListener { p0 ->
            when (p0?.itemId) {
                R.id.delete -> {
                    vm.deletecard(adapter.getItemId(position))
                }
                R.id.edit -> {

                }
            }
            false
        }
        menu.show()
    }
    private fun alertdialog(position: Int){
        val builder = AlertDialog.Builder(requireContext())
        builder.setTitle("Edit")
        builder.setMessage("Are are sure you want to Edit?")
        builder.setPositiveButton("Yes" ){ dialog: DialogInterface, i: Int ->

        }
        builder.setNegativeButton("No"){ dialog: DialogInterface, i:Int->
            dialog.dismiss()
        }
        val alertDialog=builder.create()
        alertDialog.setCancelable(false)
        alertDialog.show()
    }

}


