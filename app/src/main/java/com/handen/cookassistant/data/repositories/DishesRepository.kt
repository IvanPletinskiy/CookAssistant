package com.handen.cookassistant.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.handen.cookassistant.data.models.Dish

class DishesRepository {
    private val dishesList = listOf(
        Dish("Сосиски", 15 * 60, 2, false),
        Dish("Пельмени", 25 * 60, 3, true),
        Dish("Рис", 20 * 60, 2, false)
    )

    private val _dishes = MutableLiveData<List<Dish>>(dishesList)
    val dishes: LiveData<List<Dish>>
        get() = _dishes
}