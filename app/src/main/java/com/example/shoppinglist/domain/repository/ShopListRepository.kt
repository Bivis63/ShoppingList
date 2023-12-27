package com.example.shoppinglist.domain.repository

import com.example.shoppinglist.domain.model.ShopItem

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)
    fun deleteItem(shopItemId: ShopItem)
    fun editShopItem(shopItem: ShopItem)
    fun getShopList():List<ShopItem>
    fun getShopItem(shopItemId:Int):ShopItem

}