package com.example.shoppinglist.domain.repository

import androidx.lifecycle.LiveData
import com.example.shoppinglist.domain.model.ShopItem

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun deleteItem(shopItem: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopList(): LiveData<List<ShopItem>>
    fun getShopItem(shopItemId:Int):ShopItem

}