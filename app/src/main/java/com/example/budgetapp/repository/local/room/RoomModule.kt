package com.example.budgetapp.repository.local.room

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {
    @Singleton
    @Provides
    fun provideRoomDatabase( // Tell Dagger-Hilt to create a singleton accessible everywhere in ApplicationComponent (i.e. everywhere in the application)
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        BudgetDatabase::class.java,
        "budget"
    ).build()

    // Tell Dagger-Hilt to create a singleton accessible everywhere in ApplicationComponent (i.e. everywhere in the application)

    @Singleton
    @Provides
    fun provideCategoryDao(db: BudgetDatabase) =
        db.categoryDao()

    // Tell Dagger-Hilt to create a singleton accessible everywhere in ApplicationComponent (i.e. everywhere in the application)

    @Singleton
    @Provides
    fun provideLabelDao(db: BudgetDatabase) = db.labelDao()

}