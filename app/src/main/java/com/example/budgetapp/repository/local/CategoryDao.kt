package com.example.budgetapp.repository.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.budgetapp.repository.model.Category

interface CategoryDao {
    @Query("SELECT * FROM category")
    fun getAll(): List<Category>

    @Query("SELECT * FROM category WHERE name LIKE :name LIMIT 1")
    fun findCategoryByName(name: String): Category

    @Insert
    fun insertAll(vararg categories: Category)

    @Delete
    fun delete(category: Category)
}