package com.example.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.domain.ShopItem
import com.example.shoppinglist.domain.ShopItemRepository
import java.lang.RuntimeException
import kotlin.random.Random

object ShopListRepositoryImp:ShopItemRepository {

    private val shopListLD = MutableLiveData<List<ShopItem>>()
    private val shopList = sortedSetOf<ShopItem>({ o1, o2 -> o1.id.compareTo(o2.id) })
    private var autoIncrementId = 0

    init {
        for (i in 0 until 1000 ) {
            val item =ShopItem ("Name$i", i , Random.nextBoolean())
        addToShopList(item)
        }
    }


    override fun addToShopList(shopItem: ShopItem) {
        if (shopItem.id ==ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementId++
        }
        shopList.add(shopItem)
        updateList()
    }

    override fun deleteFromShopList(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldElement = getItemById(shopItem.id)
        shopList.remove(oldElement)
        addToShopList(shopItem)


    }

    override fun getItemById(shopItemId: Int): ShopItem {
        return shopList.find {it.id ==shopItemId
        } ?: throw RuntimeException("Element with id  $shopItemId not found ")
    }

    override fun getShopList(): LiveData<List<ShopItem>> {
        return shopListLD
    }

    private  fun updateList() {
        shopListLD.value= shopList.toList()
    }
}