package com.example.spendiary.ui.components

import android.app.DatePickerDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.spendiary.ui.theme.DarkBackground
import com.example.spendiary.ui.theme.PurpleAccent
import com.example.spendiary.ui.theme.White87
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.TextStyle

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

    Button(
        onClick = { datePickerDialog.show() },
        colors = ButtonDefaults.buttonColors(
            containerColor = DarkBackground,
            contentColor = White87
        )
    ) {
        Text(
            text = "Date: ${selectedDate.format(DateTimeFormatter.ofPattern("dd MMM yyyy"))}",
            fontSize = 12.sp
        )
    }
}