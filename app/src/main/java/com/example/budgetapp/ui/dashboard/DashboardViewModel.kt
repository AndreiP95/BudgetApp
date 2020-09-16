package com.example.budgetapp.ui.dashboard

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.budgetapp.repository.local.LocalRepository
import com.example.budgetapp.repository.model.Category
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardViewModel @ViewModelInject constructor(
    private val localRepo: LocalRepository
) : ViewModel() {

    fun initData(categoryData: Array<Category>) {
        viewModelScope.launch(Dispatchers.IO) {
            val result = getAllCategories()
            if (!result.isNullOrEmpty())
                saveData(categoryData)
        }
    }

    suspend fun saveData(categoryData: Array<Category>) = localRepo.insertCategory(categoryData)

    suspend fun getAllCategories(): List<Category> = localRepo.getAllCategories()

}