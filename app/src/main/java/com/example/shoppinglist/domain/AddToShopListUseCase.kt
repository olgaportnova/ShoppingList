package com.example.shoppinglist.domain

class AddToShopListUseCase (private val shopListRepository: ShopItemRepository) {
    
    fun addToShopList(shopItem: ShopItem){
        shopListRepository.addToShopList(shopItem)
    }
}