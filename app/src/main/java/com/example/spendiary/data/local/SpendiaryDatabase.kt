package com.example.spendiary.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.spendiary.data.converter.DateConverter
import com.example.spendiary.data.local.dao.ExpenseDao
import com.example.spendiary.data.local.dao.SavingDao
import com.example.spendiary.data.local.entities.Expense
import com.example.spendiary.data.local.entities.Saving

@Database(entities = [Expense::class, Saving::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class SpendiaryDatabase: RoomDatabase() {
    abstract fun expenseDao(): ExpenseDao
    abstract fun savingDao(): SavingDao

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
