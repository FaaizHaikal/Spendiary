package com.example.spendiary.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.spendiary.data.local.SpendiaryDatabase
import com.example.spendiary.data.local.entities.Saving
import com.example.spendiary.data.repository.SavingsRepository
import kotlinx.coroutines.flow.Flow

class SavingsViewModel(application: Application): AndroidViewModel(application) {
    private val allSavings: Flow<List<Saving>>
    private val repository: SavingsRepository

    init {
        val savingsDao = SpendiaryDatabase.getDatabase(application).savingsDao()
        repository = SavingsRepository(savingsDao)
        allSavings = repository.allSavings
    }
}
