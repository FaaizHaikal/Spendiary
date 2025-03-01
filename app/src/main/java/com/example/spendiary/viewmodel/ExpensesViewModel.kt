package com.example.spendiary.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.spendiary.data.local.SpendiaryDatabase
import com.example.spendiary.data.local.entities.Expense
import com.example.spendiary.data.repository.ExpensesRepository
import kotlinx.coroutines.flow.Flow

class ExpensesViewModel(application: Application): AndroidViewModel(application) {
    private val allExpenses: Flow<List<Expense>>
    private val repository: ExpensesRepository

    init {
        val expensesDao = SpendiaryDatabase.getDatabase(application).expensesDao()
        repository = ExpensesRepository(expensesDao)
        allExpenses = repository.allExpenses
    }
}
