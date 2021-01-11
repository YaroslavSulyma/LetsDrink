package com.example.letsdrink.ui.categoriesFragment

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.letsdrink.data.entities.CategoryModel
import com.example.letsdrink.databinding.CategoriesItemBinding

class CategoryAdapter(private val listener: ItemListener) :
    RecyclerView.Adapter<CategoryViewHolder>() {

    interface ItemListener {
        fun onClicked(strCategory: String)
    }

    private val items = ArrayList<CategoryModel>()

    fun setItems(items: ArrayList<CategoryModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val binding: CategoriesItemBinding =
            CategoriesItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        return holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class CategoryViewHolder(
    private val itemBinding: CategoriesItemBinding,
    private val listener: CategoryAdapter.ItemListener
) : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

    private lateinit var category: CategoryModel

    init {
        itemBinding.root.setOnClickListener(this)
    }

    fun bind(item: CategoryModel) {
        this.category = item
        itemBinding.categoriesItemTitle.text = item.strCategory
    }

    override fun onClick(v: View?) {
        listener.onClicked(category.strCategory)
    }
}