package com.example.foodapps

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.foodapp.adapter.CategoryAdapter
import com.example.foodapp.adapter.MenuAdapter
import com.example.foodapp.model.Category
import com.example.foodapp.model.Menu
import com.example.foodapps.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val categoryAdapter = CategoryAdapter()
    private val menuAdapter = MenuAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setCategoryList()
        setMenuList()
    }

    private fun setMenuList() {
        val data = listOf(
            Menu(
                image = R.drawable.img_frenchfries_menu,
                name = "Kentang Goreng",
                price = 15000.0
            ),
            Menu(
                image = R.drawable.img_friedrice_menu,
                name = "Nasi Goreng",
                price = 30000.0
            ),
            Menu(
                image = R.drawable.img_noodle_menu,
                name = "Mie Kuah Spesial",
                price = 25000.0
            ),
            Menu(
                image = R.drawable.img_lime_mojito_menu,
                name = "Lime Mojito",
                price = 20000.0
            ),
            Menu(
                image = R.drawable.img_salad_menu,
                name = "Salad",
                price = 23000.0
            ),
        )
        binding.rvMenu.apply {
            adapter = this@MainActivity.menuAdapter
        }
        menuAdapter.submitData(data)
    }

    private fun setCategoryList() {
        val data = listOf(
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
        binding.rvCategory.apply {
            adapter = this@MainActivity.categoryAdapter
        }

        categoryAdapter.submitData(data)
    }


}