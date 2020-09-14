package com.example.budgetapp.repository.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.budgetapp.repository.model.Category
import com.example.budgetapp.repository.model.Label

@Database(
    entities = [
        Category::class,
        Label::class
    ], version = 1
)
abstract class BudgetDatabase : RoomDatabase() {
    abstract fun categoryDao(): CategoryDao
    abstract fun labelDao(): LabelDao
}