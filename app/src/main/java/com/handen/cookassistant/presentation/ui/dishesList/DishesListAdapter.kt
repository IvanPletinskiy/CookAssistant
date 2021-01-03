package com.handen.cookassistant.presentation.ui.dishesList

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.handen.cookassistant.R
import com.handen.cookassistant.data.models.Dish
import com.handen.cookassistant.presentation.ext.viewId

typealias OnFavoriteButtonClickListener = (dish: Dish) -> Unit

class DishesListAdapter: RecyclerView.Adapter<DishesListAdapter.DishHolder>() {
    private var items = listOf<Dish>()
    lateinit var onFavoriteButtonClick: OnFavoriteButtonClickListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DishHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dish, parent, false)
        return DishHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: DishHolder, position: Int) {
        val dish = items[position]
        holder.title.text = dish.title
        holder.description.text = formatDescription(holder.itemView.context, dish)
        if(dish.isFavorite) {
            holder.favoriteButton.setBackgroundResource(R.drawable.ic_star_filled)
        } else {
            holder.favoriteButton.setBackgroundResource(R.drawable.ic_star_outline)
        }
        holder.favoriteButton.setOnClickListener {
            onFavoriteButtonClick.invoke(items[position])
        }
    }

    fun setItems(items: List<Dish>) {
        this.items = items
        notifyDataSetChanged()
    }

    class DishHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title by view.viewId<TextView>(R.id.dish_title)
        val description by view.viewId<TextView>(R.id.dish_description)
        val favoriteButton by view.viewId<ImageButton>(R.id.dish_favorite_button)
    }

    fun formatDescription(context: Context, dish: Dish): String {
        //TODO
        return "${dish.duration / 60} мин, ${dish.stepsCount} шагов"
    }
}