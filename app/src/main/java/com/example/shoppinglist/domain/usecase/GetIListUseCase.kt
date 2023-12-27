package com.example.shoppinglist.domain.usecase

import com.example.shoppinglist.domain.model.ShopItem
import com.example.shoppinglist.domain.repository.ShopListRepository

class GetIListUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopList():List<ShopItem>{
       return shopListRepository.getShopList()
    }
}