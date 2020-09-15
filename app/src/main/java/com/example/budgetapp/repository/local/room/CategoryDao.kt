package com.example.budgetapp.repository.local.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.budgetapp.repository.model.Category

interface CategoryDao {
    @Query("SELECT * FROM category")
    suspend fun getAll(): List<Category>

    @Query("SELECT * FROM category WHERE name LIKE :name LIMIT 1")
    suspend fun findCategoryByName(name: String): Category

    @Insert
    suspend fun insertAll(vararg categories: Category)

    @Delete
    suspend fun delete(category: Category)
}