package com.example.foodapps.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.foodapps.presentation.category.adapter.CategoryAdapter
import com.example.foodapp.model.Category
import com.example.foodapps.R
import com.example.foodapps.data.datasource.CategoryDataSource
import com.example.foodapps.data.datasource.CategoryDataSourceImpl
import com.example.foodapps.data.datasource.MenuDataSource
import com.example.foodapps.data.datasource.MenuDataSourceImpl
import com.example.foodapps.databinding.ActivityMainBinding
import com.example.foodapps.presentation.menulist.adapter.MenuAdapter

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private var adapter = CategoryAdapter()
    private val dataSource: CategoryDataSource by lazy {
        CategoryDataSourceImpl()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setCategoryList()
    }

    private fun setCategoryList() {
        binding.rvCategory.apply {
            adapter = this@MainActivity.adapter
        }
        adapter.submitData(dataSource.getCategoryData())

    }


}