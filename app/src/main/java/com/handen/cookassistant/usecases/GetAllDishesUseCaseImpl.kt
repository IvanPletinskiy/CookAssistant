package com.handen.cookassistant.usecases

import androidx.lifecycle.LiveData
import com.handen.cookassistant.data.models.Dish
import com.handen.cookassistant.data.repositories.DishesRepository

class GetAllDishesUseCaseImpl(private val repository: DishesRepository) : GetAllDishesUseCase {
    override fun invoke(): LiveData<List<Dish>> {
        return repository.dishes
    }
}