package com.example.spendiary.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.spendiary.data.converter.DateConverter
import com.example.spendiary.data.local.dao.ExpensesDao
import com.example.spendiary.data.local.dao.SavingsDao
import com.example.spendiary.data.local.entities.Expense
import com.example.spendiary.data.local.entities.Saving

@Database(entities = [Expense::class, Saving::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class SpendiaryDatabase: RoomDatabase() {
    abstract fun expensesDao(): ExpensesDao
    abstract fun savingsDao(): SavingsDao

    companion object {
        @Volatile
        private var INSTANCE: SpendiaryDatabase? = null

        fun getDatabase(context: Context): SpendiaryDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    SpendiaryDatabase::class.java,
                    "spendiary_db"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }
}
