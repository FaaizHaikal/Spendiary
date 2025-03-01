package com.example.spendiary.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.spendiary.data.local.entities.Saving
import kotlinx.coroutines.flow.Flow

@Dao
interface SavingDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSaving(saving: Saving)

    @Update
    suspend fun updateSaving(saving: Saving)

    @Delete
    suspend fun deleteSaving(saving: Saving)

    @Query("SELECT * FROM Savings ORDER BY date DESC")
    fun getAllSavings(): Flow<List<Saving>>

    @Query("SELECT * FROM Savings WHERE strftime('%Y', date / 1000, 'unixepoch') = strftime('%Y', 'now')")
    fun getCurrentYearSavings(): Flow<List<Saving>>
}