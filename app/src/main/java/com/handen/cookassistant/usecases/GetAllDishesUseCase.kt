package com.handen.cookassistant.usecases

import androidx.lifecycle.LiveData
import com.handen.cookassistant.data.models.Dish

interface GetAllDishesUseCase {
    operator fun invoke(): LiveData<List<Dish>>
}