package com.example.vault.adapter

import android.content.Context
import android.graphics.PostProcessor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vault.fragment.Search
import com.example.vault.model.Login
import kotlinx.android.synthetic.main.login_list.view.*
import java.util.*

class SearchAdapter(private val context: Context, private var list:List<Login>, private val listener: OnItemClickListener,private val editlistener:OnEditListener):
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val v = LayoutInflater.from(context).inflate(com.example.vault.R.layout.login_list, parent, false)
        return SearchViewHolder(v)
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(list[position])
        holder.itemView.edit_login.setOnClickListener {
            editlistener.onEditListener(position)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
    inner class SearchViewHolder(itemView: View):RecyclerView.ViewHolder(itemView),View.OnClickListener{
        init{
            itemView.setOnClickListener(this)
        }
         fun bind(item:Login)=with(itemView)
         {
             itemTitle.text = item.loginwebsite.uppercase()
             val result=itemTitle.text.toString().uppercase()
             itemid.text = item.loginId
             val colors=resources.getIntArray(com.example.vault.R.array.random_color)
             val rColor=colors[Random().nextInt(colors.size)]
             itemIcon.setCardBackgroundColor(rColor)
             itemIconTv.text=result.subSequence(0,1)
         }

        override fun onClick(p0: View?) {
            if(adapterPosition!=RecyclerView.NO_POSITION){
               listener.onItemClick(adapterPosition)

            }
        }


    }
   interface OnItemClickListener{
       fun onItemClick(position: Int)
   }

   interface OnEditListener{
       fun onEditListener(position: Int)
   }


}