package com.example.budgetapp.ui.dashboard

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.example.budgetapp.repository.local.LocalRepository
import com.example.budgetapp.repository.model.Category

class DashboardViewModel @ViewModelInject constructor(
    private val localRepo: LocalRepository
) : ViewModel() {

    suspend fun getAllCategories(): List<Category> = localRepo.getAllCategories()
}