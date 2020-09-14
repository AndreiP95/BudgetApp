package com.example.budgetapp.repository.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "label")
data class Label(
    @PrimaryKey val labelId: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "amount") val amount: Double
)