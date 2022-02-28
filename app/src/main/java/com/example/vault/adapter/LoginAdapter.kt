package com.example.vault.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vault.R
import com.example.vault.model.Login
import kotlinx.android.synthetic.main.login_list.view.*

class LoginAdapter(private val context: Context, private val listener:OnItemClickListener)
    : RecyclerView.Adapter<LoginAdapter.LoginViewHolder>() {

    private var data = ArrayList<Login>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoginViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.login_list, parent, false)

        return LoginViewHolder(v)
    }

    override fun onBindViewHolder(holder: LoginViewHolder, position: Int) {
        holder.bind(data[position])


    }

    override fun getItemCount(): Int {
        return data.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun update(list:List<Login>){
        data.clear()
        data.addAll(list)
        notifyDataSetChanged()
    }


    inner class LoginViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        init{
            itemView.setOnClickListener(this)
        }
        fun bind(item: Login) = with(itemView) {
            itemTitle.text = item.loginwebsite
            itemid.text = item.loginId
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


}




