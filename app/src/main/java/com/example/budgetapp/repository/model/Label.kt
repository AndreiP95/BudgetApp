package com.example.budgetapp.repository.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "label")
data class Label(
    @PrimaryKey val labelId: Long,
    val categoryNameId: Long,
    val name: String,
    val amount: Double
)