package com.example.shoppinglist.presentation

import android.app.Application
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.model.ShopItem

class ShopListAdapter() :
    RecyclerView.Adapter<ShopListAdapter.ShopListViewHolder>() {

    val list = listOf<ShopItem>()
    var layoutId = 0

    class ShopListViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName = view.findViewById<TextView>(R.id.tv_name)
        val tvCount = view.findViewById<TextView>(R.id.tv_count)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopListViewHolder {
        for (shopItem in list) {
            layoutId = if (shopItem.enable) {
                R.layout.item_shop_enable
            } else {
                R.layout.item_shop_disabled
            }
        }
        val view = LayoutInflater.from(parent.context).inflate(layoutId, parent, false)
        return ShopListViewHolder(view = view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ShopListViewHolder, position: Int) {
        val shopItem = list[position]
        holder.tvName.text = shopItem.name
        holder.tvCount.text = shopItem.count.toString()

    }
}