package com.example.vault.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vault.R
import com.example.vault.model.Card
import kotlinx.android.synthetic.main.card_list.view.*

import kotlinx.android.synthetic.main.login_list.view.*
import java.util.*


class CardAdapter(private val context: Context,private val data:List<Card>,private val clickListener:OnItemClickListener):RecyclerView.Adapter<CardAdapter.CardViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.card_list, parent, false)
        return CardViewHolder(v)
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
         holder.bind(data[position])

    }

    override fun getItemId(position: Int): Long {
        return data[position].id
    }

    override fun getItemCount(): Int {
      return data.size
    }

 inner class  CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),View.OnClickListener{
      init{
          itemView.setOnClickListener(this)
      }
     @SuppressLint("SetTextI18n")
     fun bind(item:Card)=with(itemView){
         cardTitle.text=item.cardType
         expriryDate.text=item.cardExpiryMonth+"/"+item.cardExpiryYear
      }

     override fun onClick(p0: View?) {
         if(adapterPosition!=RecyclerView.NO_POSITION)
             clickListener.OnItemClicked(adapterPosition)
     }


 }
 interface OnItemClickListener{
     fun OnItemClicked(adapterPosition: Int)
 }



}