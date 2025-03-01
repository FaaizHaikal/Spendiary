package com.example.spendiary.data.converter

import androidx.room.TypeConverter
import java.util.Date

class DateConverter {
    @TypeConverter
    fun fromTimeStamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun toTimeStamp(date: Date?): Long? {
        return date?.time
    }
}
