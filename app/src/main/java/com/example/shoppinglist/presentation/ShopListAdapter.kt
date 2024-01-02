package com.example.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.model.ShopItem

class ShopListAdapter() :
    RecyclerView.Adapter<ShopListAdapter.ShopListViewHolder>() {

    var shopList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    class ShopListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopListViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_shop_enable, parent, false)
        return ShopListViewHolder(view = view)
    }

    override fun getItemCount(): Int {
        return shopList.size
    }

    override fun onBindViewHolder(holder: ShopListViewHolder, position: Int) {
        val shopItem = shopList[position]
        val status = if(shopItem.enable){
            "Active"
        }else{
            "Not Active"
        }

        if (shopItem.enable){
            holder.tvName.setTextColor(ContextCompat.getColor(holder.itemView.context,android.R.color.holo_red_dark))
            holder.tvName.text = "${shopItem.name} $status"
            holder.tvCount.text = shopItem.count.toString()
        }
    }

    override fun onViewRecycled(holder: ShopListViewHolder) {
        super.onViewRecycled(holder)
        holder.tvName.text = ""
        holder.tvCount.text = ""
        holder.tvName.setTextColor(ContextCompat.getColor(holder.itemView.context,android.R.color.white))
    }
}