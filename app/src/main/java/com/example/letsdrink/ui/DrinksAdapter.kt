package com.example.letsdrink.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.letsdrink.data.entities.DrinksModel
import com.example.letsdrink.databinding.DrinksItemBinding

class DrinksAdapter(private val listener: ItemListener) :
    RecyclerView.Adapter<DrinksViewHolder>() {

    private val items = ArrayList<DrinksModel>()

    interface ItemListener {
        fun onClicked(drinks: String)
    }

    fun setItems(items: ArrayList<DrinksModel>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DrinksViewHolder {
        val binding: DrinksItemBinding =
            DrinksItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return DrinksViewHolder(binding, listener)
    }

    override fun onBindViewHolder(holder: DrinksViewHolder, position: Int) {
        return holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}

class DrinksViewHolder(
    private val itemBinding: DrinksItemBinding,
    private val listener: DrinksAdapter.ItemListener
) : RecyclerView.ViewHolder(itemBinding.root), View.OnClickListener {

    private lateinit var drinks: DrinksModel

    init {
        itemBinding.root.setOnClickListener(this)
    }


    fun bind(item: DrinksModel) {
        val circularProgressDrawable = CircularProgressDrawable(itemBinding.drinksItemThumb.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        this.drinks = item
        itemBinding.drinksItemTitle.text = drinks.strDrink
        Glide.with(itemBinding.root)
            .load(drinks.strDrinkThumb)
            .centerCrop()
            .placeholder(circularProgressDrawable)
            .into(itemBinding.drinksItemThumb)
    }

    override fun onClick(v: View?) {
        listener.onClicked(drinks.strDrink)
    }
}



