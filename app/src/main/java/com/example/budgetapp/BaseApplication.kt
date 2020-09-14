package com.example.budgetapp

import android.app.Application
import androidx.room.Room
import com.example.budgetapp.repository.local.BudgetDatabase

class BaseApplication : Application() {

    private lateinit var categoryDatabase: BudgetDatabase

    fun getDatabase(): BudgetDatabase {
        if (!::categoryDatabase.isInitialized)
            categoryDatabase = Room.databaseBuilder(
                applicationContext,
                BudgetDatabase::class.java,
                "budget-database"
            ).build()
        return categoryDatabase
    }

}