package com.example.budgetapp.repository.local.room

import androidx.room.*
import com.example.budgetapp.repository.model.Category
import com.example.budgetapp.repository.model.CategoryWithLabels

@Dao
interface CategoryDao {
    @Query("SELECT * FROM category")
    suspend fun getAll(): List<Category>

    @Query("SELECT * FROM category WHERE name LIKE :name LIMIT 1")
    suspend fun findCategoryByName(name: String): Category

    @Insert
    suspend fun insertAll(vararg categories: Category)

    @Transaction
    @Query("SELECT * FROM category")
    suspend fun getLabelsForCategory(): List<CategoryWithLabels>

    @Delete
    suspend fun delete(category: Category)
}