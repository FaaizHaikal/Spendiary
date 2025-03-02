package com.example.spendiary.ui.components

import android.app.DatePickerDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@Composable
fun DatePicker(selectedDate: LocalDate, onDateSelected: (LocalDate) -> Unit) {
    val context = LocalContext.current
    val datePickerDialog = DatePickerDialog(
        context,
        { _, year, month, dayOfMonth ->
            onDateSelected(LocalDate.of(year, month + 1, dayOfMonth))
        },
        selectedDate.year,
        selectedDate.monthValue - 1,
        selectedDate.dayOfMonth
    )

    Button(onClick = { datePickerDialog.show() }) {
        Text("Date: ${selectedDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy"))}")
    }
}