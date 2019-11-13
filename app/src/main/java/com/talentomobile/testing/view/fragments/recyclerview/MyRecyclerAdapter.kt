package com.talentomobile.testing.view.fragments.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.talentomobile.testing.R
import com.talentomobile.testing.model.Account

class MyRecyclerAdapter(private var mData: ArrayList<Account>) :
    RecyclerView.Adapter<MyRecyclerAdapter.AccountViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = AccountViewHolder(
        LayoutInflater.from(parent.context).inflate(
            R.layout.account_item,
            parent,
            false
        )
    )

    override fun getItemCount(): Int = mData.size

    override fun onBindViewHolder(holder: AccountViewHolder, position: Int) {
        holder.currency.text = mData[holder.adapterPosition].currency
        holder.balance.text = (mData[holder.adapterPosition].balanceInCents / 100).toString()
        holder.number.text = mData[holder.adapterPosition].number
        holder.type.text = mData[holder.adapterPosition].type
    }

    class AccountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val currency = itemView.findViewById<TextView>(R.id.txt_currency)
        val balance = itemView.findViewById<TextView>(R.id.txt_balance)
        val number = itemView.findViewById<TextView>(R.id.txt_number)
        val type = itemView.findViewById<TextView>(R.id.txt_type)
    }

}