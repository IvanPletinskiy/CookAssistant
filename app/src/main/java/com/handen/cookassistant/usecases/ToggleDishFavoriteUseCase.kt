package com.handen.cookassistant.usecases

import com.handen.cookassistant.data.models.Dish

interface ToggleDishFavoriteUseCase {
    operator fun invoke(dish: Dish)
}