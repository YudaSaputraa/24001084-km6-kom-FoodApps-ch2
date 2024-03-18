package com.example.foodapps.presentation.menulist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.foodapp.model.Menu
import com.example.foodapps.R
import com.example.foodapps.data.datasource.MenuDataSource
import com.example.foodapps.data.datasource.MenuDataSourceImpl
import com.example.foodapps.databinding.FragmentMenuListBinding
import com.example.foodapps.presentation.menudetail.DetailActivity
import com.example.foodapps.presentation.menulist.adapter.MenuAdapter

class MenuListFragment : Fragment() {
    private lateinit var binding: FragmentMenuListBinding
    private var adapter: MenuAdapter? = null
    private val dataSource: MenuDataSource by lazy {
        MenuDataSourceImpl()
    }
    private var isGridMode: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMenuListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindModeList(true)
        setClickAction()
    }

    private fun bindModeList(isGridMode: Boolean) {
        val listMode =
            if (isGridMode)
                MenuAdapter.MODE_GRID
            else
                MenuAdapter.MODE_LIST
        adapter = MenuAdapter(
            listMode = listMode,
            listener = object : MenuAdapter.OnItemClickedListener<Menu> {
                override fun onItemSelected(item: Menu) {
                    pushToDetail(item)
                }

            }
        )
        binding.rvMenu.apply {
            adapter = this@MenuListFragment.adapter
            layoutManager = GridLayoutManager(
                requireContext(),
                if (isGridMode)
                    2
                else
                    1
            )
        }
        adapter?.submitData(dataSource.getMenuData())
    }

    private fun pushToDetail(item: Menu) {
        DetailActivity.startActivity(
            requireContext(), item
        )
    }

    private fun setClickAction() {
        binding.ivMenuList.setOnClickListener {
            isGridMode = !isGridMode
            if (isGridMode)
                binding.ivMenuList.setImageResource(R.drawable.ic_menu_list)
            else
                binding.ivMenuList.setImageResource(R.drawable.ic_menu_grid)
            bindModeList(isGridMode)
        }
    }

}