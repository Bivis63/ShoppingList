package com.example.shoppinglist.presentation

import androidx.recyclerview.widget.DiffUtil
import com.example.shoppinglist.domain.model.ShopItem

class ShopListDiffCallBack(
    private val oldList: List<ShopItem>,
    private val newList: List<ShopItem>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldShopItem = oldList[oldItemPosition]
        val newShopItem = newList[newItemPosition]
        return oldShopItem.id == newShopItem.id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldShopItem = oldList[oldItemPosition]
        val newShopItem = newList[newItemPosition]
        return oldShopItem == newShopItem
    }
}