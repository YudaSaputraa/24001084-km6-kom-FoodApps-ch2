package com.example.foodapps.data.datasource

import com.example.foodapp.model.Category
import com.example.foodapps.R

interface CategoryDataSource {
    fun getCategoryData(): List<Category>
}

class CategoryDataSourceImpl() : CategoryDataSource {
    override fun getCategoryData(): List<Category> {
        return mutableListOf(
            Category(
                image = R.drawable.img_rice,
                name = "Nasi"
            ),
            Category(
                image = R.drawable.img_noodle,
                name = "Mie"
            ),
            Category(
                image = R.drawable.img_snack,
                name = "Snack"
            ),
            Category(
                image = R.drawable.img_drink,
                name = "Minuman"
            ),
            Category(
                image = R.drawable.img_vegetables,
                name = "Sayuran"
            ),
        )
    }

}