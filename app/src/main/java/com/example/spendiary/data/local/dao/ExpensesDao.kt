package com.example.spendiary.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.OnConflictStrategy
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import com.example.spendiary.data.local.entities.Expense

@Dao
interface ExpensesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExpense(expense: Expense)

    @Update
    suspend fun updateExpense(expense: Expense)

    @Delete
    suspend fun deleteExpense(expense: Expense)

    @Query("SELECT * FROM Expenses ORDER BY date DESC")
    fun getExpensesOrderedByDate(): Flow<List<Expense>>

    @Query("SELECT * FROM Expenses WHERE strftime('%Y-%m', date / 1000, 'unixepoch') = strftime('%Y-%m', 'now')")
    fun getCurrentMonthExpenses(): Flow<List<Expense>>
}
