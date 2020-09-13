package com.example.budgetapp.repository.model

data class Category(
    val name: String,
    val amount: Double,
    val status: String,
    val labels: List<Label>?
)