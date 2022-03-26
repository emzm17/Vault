package com.example.vault.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation.findNavController

import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.vault.R
import com.example.vault.fragment.LoginFragment
import com.example.vault.fragment.LoginFragmentDirections
import com.example.vault.model.Login
import kotlinx.android.synthetic.main.login_list.view.*

class LoginAdapter(private val context: Context, private var data:List<Login>,private val listener:OnItemClickListener,private val editlistener:OnItemEditClickListener)
    : RecyclerView.Adapter<LoginAdapter.LoginViewHolder>() {



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoginViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.login_list, parent, false)

        return LoginViewHolder(v)
    }

    override fun onBindViewHolder(holder: LoginViewHolder, position: Int) {
        holder.bind(data[position])
        holder.itemView.edit_login.setOnClickListener{
            editlistener.OnEditItemClick(position)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun getItemId(position: Int):Long {
       return   data[position].id
    }

    inner class LoginViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init{
            itemView.setOnClickListener(this)
        }
        fun bind(item: Login) = with(itemView) {
            itemTitle.text = item.loginwebsite
            itemid.text = item.loginId
            val i=getItem(item.category)
            when(i){
                "Educational"->itemIcon.setImageResource(R.drawable.educational)
                "Medcial"->itemIcon.setImageResource(R.drawable.medical)
                "Financial"->itemIcon.setImageResource(R.drawable.financial)
                "Social"->itemIcon.setImageResource(R.drawable.social)
            }
        }
        override fun onClick(p0: View?) {
            if (adapterPosition != RecyclerView.NO_POSITION) {
                listener.OnItemClick(adapterPosition)
            }

        }


    }
    interface OnItemClickListener{
        fun OnItemClick(position: Int)
    }

  interface OnItemEditClickListener{
      fun OnEditItemClick(position: Int)
  }

}
private fun getItem(s:String):String {
    val a=arrayListOf("Educational", "Financial", "Medcial", "Social")
    for (i in a){
         if(i==s)return s
    }

    return "random"
}





