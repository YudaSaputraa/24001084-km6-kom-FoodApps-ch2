package com.example.foodapps.presentation.menulist.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.foodapp.model.Menu
import com.example.foodapps.base.ViewHolderBinder
import com.example.foodapps.databinding.ItemMenuListBinding
import com.example.foodapps.utils.formatToRupiah

class MenuListViewHolder(
    private val binding: ItemMenuListBinding,
    private val listener: MenuAdapter.OnItemClickedListener<Menu>
) : RecyclerView.ViewHolder(binding.root), ViewHolderBinder<Menu> {
    override fun bind(item: Menu) {
        item.let {
            binding.ivMenuImage.setImageResource(it.image)
            binding.tvMenuName.text = it.name
            binding.tvMenuPrice.text = it.price.formatToRupiah()
            itemView.setOnClickListener{
                listener.onItemSelected(item)
            }
        }
    }
}