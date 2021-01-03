package com.handen.cookassistant.data.models

data class Dish(
    val title: String,
    val duration: Int,
    val stepsCount: Int,
    var isFavorite: Boolean
)