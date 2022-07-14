package com.example.vault.adapter

import android.content.Context
import android.graphics.PostProcessor
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vault.R
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
             itemid.text = item.loginId
             when(item.loginwebsite.uppercase()){
                 "AMAZON"->{ itemIcon.setImageResource(R.drawable.amazon) }
                 "FACEBOOK"-> { itemIcon.setImageResource(R.drawable.facebook)}
                 "FLIPKART"->{ itemIcon.setImageResource(R.drawable.flipkart)}
                 "GITHUB"->{ itemIcon.setImageResource(R.drawable.github)}
                 "GMAIL"->{ itemIcon.setImageResource(R.drawable.gmail)}
                 "INSTAGRAM"->{ itemIcon.setImageResource(R.drawable.instagram)}
                 "LINKEDIN"->{ itemIcon.setImageResource(R.drawable.linkedin)}
                 "PINTEREST"->{ itemIcon.setImageResource(R.drawable.pinterest)}
                 "REDDIT"->{ itemIcon.setImageResource(R.drawable.reddit)}
                 "SLACK"->{ itemIcon.setImageResource(R.drawable.slack)}
                 "SPOTIFY"->{ itemIcon.setImageResource(R.drawable.spotify)}
                 "TWITTER"->{ itemIcon.setImageResource(R.drawable.twitter)}
                 "TEAMS"->{ itemIcon.setImageResource(R.drawable.team)}
                 else ->{
                     itemIcon.setImageResource(R.drawable.user_1)
                 }
             }
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