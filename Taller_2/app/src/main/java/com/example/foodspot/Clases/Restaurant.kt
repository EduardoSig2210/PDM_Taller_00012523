package com.example.foodspot.clases

data class Restaurant(
    val Id: Int,
    val Name: String,
    val Description: String,
    val imgUrl: String,
    val Category: List<String>,
    val Menu: List<Dish>,
)