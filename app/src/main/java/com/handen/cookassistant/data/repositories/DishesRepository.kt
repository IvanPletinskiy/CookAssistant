package com.handen.cookassistant.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.handen.cookassistant.data.models.Dish

class DishesRepository {
    private val dishesList = listOf(
        Dish(0, "Сосиски", 15 * 60, 2, false),
        Dish(1, "Пельмени", 25 * 60, 3, true),
        Dish(2, "Рис", 20 * 60, 2, false)
    )

    fun toggleDishFavorite(dish: Dish) {
        val listDish = dishesList.first { it.id == dish.id }
        listDish.isFavorite = !listDish.isFavorite
        _dishes.value = _dishes.value
    }

    private val _dishes = MutableLiveData<List<Dish>>(dishesList)
    val dishes: LiveData<List<Dish>>
        get() = _dishes
}