package com.example.vault.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vault.R
import com.example.vault.model.Login
import kotlinx.android.synthetic.main.login_list.view.*
import java.util.*


class LoginAdapter(private val context: Context, private var data:List<Login>,private val listener:OnItemClickListener,
                   private val editlistener:OnItemEditClickListener)
    : RecyclerView.Adapter<LoginAdapter.LoginViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoginViewHolder {
        val v = LayoutInflater.from(context).inflate(com.example.vault.R.layout.login_list, parent, false)
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
            itemTitle.text = item.loginwebsite.uppercase()
            val result=itemTitle.text.toString().uppercase()
            itemid.text = item.loginId
            createdtime.text=item.createdAt
            val colors=resources.getIntArray(com.example.vault.R.array.random_color)
            val rColor=colors[Random().nextInt(colors.size)]
            itemIcon.setCardBackgroundColor(rColor)
            itemIconTv.text=result.subSequence(0,1)
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






