package com.example.budgetapp.repository.local.room

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.budgetapp.repository.model.Label

interface LabelDao {

    @Query("SELECT * FROM label")
    fun getAll(): List<Label>

    @Query("SELECT * FROM label WHERE name LIKE :name LIMIT 1")
    fun findLabelByName(name: String): Label

    @Insert
    fun insertAll(vararg categories: Label)

    @Delete
    fun delete(category: Label)
}