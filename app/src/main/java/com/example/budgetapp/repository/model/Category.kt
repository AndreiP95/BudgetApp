package com.example.budgetapp.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category")
data class Category(
    @PrimaryKey val categoryId: Long = 0,
    @ColumnInfo(name = "name") val name: String = "",
    @ColumnInfo(name = "amount") val amount: Double = 0.0,
    @ColumnInfo(name = "status") val status: String = ""
)