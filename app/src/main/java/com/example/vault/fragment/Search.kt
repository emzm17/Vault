package com.example.vault.fragment


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.vault.R
import com.example.vault.adapter.SearchAdapter
import com.example.vault.database.CardDatabase
import com.example.vault.database.LoginDatabase
import com.example.vault.model.Login
import com.example.vault.repository.Repository
import com.example.vault.utils.LoginDialog
import com.example.vault.viewmodel.DetailsViewModel
import com.example.vault.viewmodel.DetailsViewModelFactory
import kotlinx.android.synthetic.main.fragment_search.*



class Search : Fragment(),SearchAdapter.OnItemClickListener,SearchAdapter.OnEditListener{
    private lateinit var vm: DetailsViewModel
    private lateinit var rp: Repository
    private lateinit var cardDatabase: CardDatabase
    private lateinit var loginDatabase: LoginDatabase

    private lateinit var searchAdapter:SearchAdapter
    private  var searchList=arrayListOf<Login>()
    val temp= arrayListOf<Login>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        cardDatabase = CardDatabase.getDatabase(requireContext())
        loginDatabase = LoginDatabase.getDatabase(requireContext())

        rp = Repository(cardDatabase, loginDatabase)
        vm = ViewModelProvider(this, DetailsViewModelFactory(rp)).get(DetailsViewModel::class.java)
        searchAdapter= SearchAdapter(requireContext(),searchList,this,this )
        rcview_search.layoutManager = LinearLayoutManager(requireContext())
        rcview_search.adapter = searchAdapter
        searchItem.isSubmitButtonEnabled=true
        searchItem.setOnQueryTextListener(object :androidx.appcompat.widget.SearchView.OnQueryTextListener{
          override fun onQueryTextSubmit(query: String?): Boolean {
                return false
          }
          override fun onQueryTextChange(newText: String?): Boolean {
             if(!newText.isNullOrEmpty()){
                  getItems(newText)
             }
              return true
          }
      })
    }
    private fun getItems(query:String){
          var searchText=query
          searchText="%$searchText%"

          vm.searchForResult(website = searchText).observe(viewLifecycleOwner) { it ->
                   searchList.clear()
                   searchList.addAll(it)

          }
        searchAdapter.notifyDataSetChanged()


    }

    override fun onItemClick(position: Int) {
        val d= LoginDialog(searchList[position])
        d.show(requireActivity().supportFragmentManager,"dialog")
    }

    override fun onEditListener(position: Int) {
        val action=SearchDirections.actionSearchfragmentToUpdateLogin(searchList[position])
        findNavController().navigate(action)
    }


}