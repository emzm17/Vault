package com.example.vault.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.vault.R
import com.example.vault.model.Card
import com.example.vault.model.Login
import kotlinx.android.synthetic.main.card_item.view.*
import kotlinx.android.synthetic.main.fragment_add_card.view.*


class CardAdapter(private val context: Context,private val data:List<Card>):RecyclerView.Adapter<CardAdapter.CardViewHolder>(){


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewHolder {
        val v = LayoutInflater.from(context).inflate(R.layout.card_item, parent, false)
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

 inner class  CardViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
      @SuppressLint("SetTextI18n")
      private val back=itemView.debitCardItemCardBack
      private val front=itemView.debitCardItemCardFront
      private val card=itemView.flipView
     init{
         back.setOnClickListener {
             card.flipDuration=1000
             card.flipTheView()
         }
         front.setOnClickListener {
             card.flipDuration=1000
             card.flipTheView()
         }


     }
      fun bind(item:Card)=with(itemView){
            CardCVV.text=item.cardCvv.toString()
            cardHolder.text=item.cardHolder
            cardNumberPart1.text = item.cardNumber.subSequence(0,4).toString()
            cardNumberPart2.text=item.cardNumber.subSequence(5,9).toString()
            cardNumberPart3.text=item.cardNumber.subSequence(10,14).toString()
            cardNumberPart4.text=item.cardNumber.subSequence(15,19).toString()
            CardName.text=item.cardType
            when(item.cardType){
                "MasterCard"->{
                            cardIssuer.setImageResource(R.drawable.ic_mc_symbol)
                }
                "Visa"->{
                        cardIssuer.setImageResource(R.drawable.ic_visa)
                }
                "Maestro"->{
                     cardIssuer.setImageResource(R.drawable.ic_mastercard)
                }
            }
      }


 }



}