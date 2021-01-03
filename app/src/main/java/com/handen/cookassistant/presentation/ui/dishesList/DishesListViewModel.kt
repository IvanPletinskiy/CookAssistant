package com.handen.cookassistant.presentation.ui.dishesList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.handen.cookassistant.di.ServiceLocator
import com.handen.cookassistant.usecases.GetAllDishesUseCase

class DishesListViewModel(application: Application) : AndroidViewModel(application) {
    private val getAllDishesUseCase: GetAllDishesUseCase = ServiceLocator.resolve()

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text

    val dishes = getAllDishesUseCase()
}