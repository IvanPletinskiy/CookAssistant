package com.handen.cookassistant.usecases

import com.handen.cookassistant.data.models.Dish
import com.handen.cookassistant.data.repositories.DishesRepository

class ToggleDishFavoriteUseCaseImpl(private val dishesRepository: DishesRepository): ToggleDishFavoriteUseCase {
    override fun invoke(dish: Dish) {
        dishesRepository.toggleDishFavorite(dish)
    }
}