package com.example.shoppinglist.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.shoppinglist.R
import com.example.shoppinglist.domain.model.ShopItem
import com.example.shoppinglist.presentation.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel :MainViewModel
    private lateinit var llShopList: LinearLayout



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        llShopList = findViewById(R.id.ll_shoplist)
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]
        viewModel.shopList.observe(this){
            Log.d("MainAct",it.toString())
            showShopList(it)
        }
    }

    private fun showShopList(list: List<ShopItem>){
        llShopList.removeAllViews()
        for (shopItem in list){
            val layoutId = if (shopItem.enable){
                R.layout.item_shop_enable
            }else{
                R.layout.item_shop_disabled
            }
            val view = LayoutInflater.from(this).inflate(layoutId,llShopList,false)
            view.setOnLongClickListener {
                viewModel.editShopItem(shopItem)
                true
            }
            val tvName = view.findViewById<TextView>(R.id.tv_name)
            val tvCount = view.findViewById<TextView>(R.id.tv_count)
            tvName.text = shopItem.name
            tvCount.text = shopItem.count.toString()
            llShopList.addView(view)
        }

    }
}