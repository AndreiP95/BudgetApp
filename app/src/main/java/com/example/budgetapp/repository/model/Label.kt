package com.example.budgetapp.repository.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Table for Category Labelsa
 * @property labelId Long
 * @property categoryNameId Long
 * @property name String
 * @property amount Double
 * @constructor
 */

@Entity(tableName = "label")
data class Label(
    @PrimaryKey val labelId: Long,
    val categoryNameId: Long,
    val name: String,
    val amount: Double
)