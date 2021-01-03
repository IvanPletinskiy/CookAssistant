package com.handen.cookassistant.presentation.ui.dishesList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.handen.cookassistant.data.models.Dish
import com.handen.cookassistant.di.ServiceLocator
import com.handen.cookassistant.usecases.GetAllDishesUseCase
import com.handen.cookassistant.usecases.ToggleDishFavoriteUseCase

class DishesListViewModel(application: Application) : AndroidViewModel(application) {
    private val getAllDishesUseCase: GetAllDishesUseCase = ServiceLocator.resolve()
    private val toggleDisheFavoriteUseCase: ToggleDishFavoriteUseCase = ServiceLocator.resolve()

    val dishes = getAllDishesUseCase()

    fun toggleDishFavorite(dish: Dish) {
        toggleDisheFavoriteUseCase(dish)
    }
}