package com.example.spendiary.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity(tableName = "Savings")
data class Saving(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: Date,
    val amount: Double
)
