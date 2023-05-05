package com.example.shoppinglist.domain

class DeleteFromShopListUseCase(private val shopItemRepository: ShopItemRepository) {

    fun deleteFromShopList(shopItem: ShopItem) {
        shopItemRepository.deleteFromShopList(shopItem)
    }
}