package com.example.shoppinglist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.shoppinglist.data.ShopListRepositoryImp
import com.example.shoppinglist.domain.DeleteFromShopListUseCase
import com.example.shoppinglist.domain.EditShopItemUseCase
import com.example.shoppinglist.domain.GetShopListUseCase
import com.example.shoppinglist.domain.ShopItem

class MainViewModel:ViewModel() {

    private val repository = ShopListRepositoryImp

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteFromShopListUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

   val shopList = getShopListUseCase.getShopList()



    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteFromShopList(shopItem)

    }

    fun changeEnableState (shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled =  !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)

    }
}