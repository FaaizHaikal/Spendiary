package com.example.spendiary.data.repository

import com.example.spendiary.data.local.dao.SavingsDao
import com.example.spendiary.data.local.entities.Saving
import kotlinx.coroutines.flow.Flow

class SavingsRepository(private val savingsDao: SavingsDao) {
    val allSavings: Flow<List<Saving>> = savingsDao.getSavingsOrderedByDate()

    suspend fun insertSaving(saving: Saving) {
        savingsDao.insertSaving(saving)
    }

    suspend fun deleteSaving(saving: Saving) {
        savingsDao.deleteSaving(saving)
    }
}
