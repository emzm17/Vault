package com.example.vault.fragment

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.*
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
import com.example.vault.viewmodel.DetailsViewModel
import com.example.vault.viewmodel.DetailsViewModelFactory
import com.example.vault.utils.Dialog
import kotlinx.android.synthetic.main.fragment_login.*

class LoginFragment : Fragment(), LoginAdapter.OnItemClickListener ,LoginAdapter.OnItemEditClickListener{
    private lateinit var vm: DetailsViewModel
    private lateinit var adapter: LoginAdapter
    private lateinit var rp: Repository
    private lateinit var cardDatabase: CardDatabase
    private lateinit var loginDatabase: LoginDatabase
    private val list= arrayListOf<Login>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return inflater.inflate(R.layout.fragment_login, container, false)
    }
    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        cardDatabase = CardDatabase.getDatabase(requireContext())
        loginDatabase = LoginDatabase.getDatabase(requireContext())
        rp = Repository(cardDatabase, loginDatabase)
        vm = ViewModelProvider(this, DetailsViewModelFactory(rp)).get(DetailsViewModel::class.java)
        adapter = LoginAdapter(requireContext(),list,this,this)
        login_rcview.layoutManager = LinearLayoutManager(requireContext())
        login_rcview.adapter = adapter

        vm.allLogin().observe(viewLifecycleOwner) { l ->
             if(!l.isNullOrEmpty()){
                 list.clear()
                 list.addAll(l)
                 adapter.notifyDataSetChanged()
             }
             else{
                 list.clear()
                 adapter.notifyDataSetChanged()
             }
        }
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



        LoginAdd.setOnClickListener {
             val action=LoginFragmentDirections.actionLoginFragmentToAddLoginFragment()
             findNavController().navigate(action)
        }


    }

    override fun OnItemClick(position: Int) {
        val d=Dialog(list[position])
        d.show(requireActivity().supportFragmentManager,"dialog")
    }

    override fun OnEditItemClick(position: Int) {
        val action=LoginFragmentDirections.actionLoginFragmentToUpdateLogin(list[position])
        findNavController().navigate(action)
    }




}
