package com.example.budgetapp.repository.model

data class Category(
    val name: String,
    val amount: Double,
    val labels: List<Label>?
)