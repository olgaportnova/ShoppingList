package com.example.shoppinglist.domain

class GetItemFromShopListUseCase (private val shopItemRepository: ShopItemRepository) {

    fun getItemById (shopItemId:Int): ShopItem {
        return shopItemRepository.getItemById(shopItemId)
    }
}