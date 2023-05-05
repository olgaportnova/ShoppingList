package com.example.shoppinglist.domain

import androidx.lifecycle.LiveData

interface ShopItemRepository {

    fun addToShopList(shopItem: ShopItem)

    fun deleteFromShopList(shopItem: ShopItem)

    fun editShopItem (shopItem: ShopItem)

    fun getItemById (shopItemId:Int): ShopItem

    fun getShopList(): LiveData<List<ShopItem>>
}