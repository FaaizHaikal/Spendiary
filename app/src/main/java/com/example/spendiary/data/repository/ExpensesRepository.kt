package com.example.spendiary.data.repository

import com.example.spendiary.data.local.dao.ExpensesDao
import com.example.spendiary.data.local.entities.Expense
import kotlinx.coroutines.flow.Flow

class ExpensesRepository(private val expensesDao: ExpensesDao) {
    val allExpenses: Flow<List<Expense>> = expensesDao.getExpensesOrderedByDate()

    suspend fun insertExpense(expense: Expense) {
        expensesDao.insertExpense(expense)
    }

    suspend fun deleteExpense(expense: Expense) {
        expensesDao.deleteExpense(expense)
    }
}
