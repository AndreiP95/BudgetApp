package com.example.budgetapp.repository.local

import com.example.budgetapp.repository.local.room.CategoryDao
import com.example.budgetapp.repository.model.Category
import javax.inject.Inject

class LocalRepository @Inject constructor(
    private val categoryDao: CategoryDao
) {
    suspend fun getAllCategories() = categoryDao.getAll()

    suspend fun findCategory(categoryName: String) = categoryDao.findCategoryByName(categoryName)

    suspend fun insertCategory(categories: Array<Category>) = categoryDao.insertAll(*categories)

    suspend fun deleteCategory(category: Category) = categoryDao.delete(category)

}
