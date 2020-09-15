package com.example.budgetapp.repository.local

import com.example.budgetapp.repository.local.room.CategoryDao
import javax.inject.Inject

class LocalRepository @Inject constructor(
    private val categoryDao: CategoryDao
) {
    suspend fun getAllCategories() = categoryDao.getAll()
}