package com.example.budgetapp.repository.model

import androidx.room.Embedded
import androidx.room.Relation

data class CategoryWithLabels(
    @Embedded val category: Category,
    @Relation(
        parentColumn = "categoryId",
        entityColumn = "categoryNameId"
    )
    val labels: List<Label>
)