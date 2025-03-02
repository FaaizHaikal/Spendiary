package com.example.spendiary.ui.components

import android.widget.DatePicker
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.window.DialogProperties
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.spendiary.ui.theme.PurpleAccent2
import com.example.spendiary.ui.theme.White60
import com.example.spendiary.ui.theme.White87
import com.example.spendiary.utils.CurrencyVisualTransformation
import com.example.spendiary.utils.DecimalFormatter
import java.time.LocalDate

@Composable
fun AddExpenseDialog(
    onDismiss: () -> Unit
) {
    var description by remember { mutableStateOf("") }
    var amount by remember { mutableStateOf("") }
    var date by remember { mutableStateOf(LocalDate.now()) }
    val decimalFormatter = DecimalFormatter()

    AlertDialog(
        onDismissRequest = { onDismiss() },
        properties = DialogProperties(dismissOnClickOutside = true),
        title = { Text("Add Expense", style = MaterialTheme.typography.titleSmall) },
        text = {
            Column {
                OutlinedTextField(
                    value = description,
                    onValueChange = { description = it },
                    label = { Text("Description") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = White87,
                        focusedLabelColor = White87,
                        unfocusedLabelColor = White60,
                        unfocusedBorderColor = White60,
                        cursorColor = White87,
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                OutlinedTextField(
                    value = amount,
                    onValueChange = { amount = decimalFormatter.cleanup(it)
                    },
                    label = { Text("Amount") },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
                    visualTransformation = CurrencyVisualTransformation(decimalFormatter),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = White87,
                        focusedLabelColor = White87,
                        unfocusedLabelColor = White60,
                        unfocusedBorderColor = White60,
                        cursorColor = White87,
                    )
                )

                Spacer(modifier = Modifier.height(8.dp))

                DatePicker(date) { newDate ->
                    date = newDate
                }
            }
        },
        confirmButton = {
            Button(
                onClick = {
                    if (description.isNotBlank() && amount.isNotBlank()) {
                        println("Saving Expense: $description - Rp. $amount")
                        onDismiss()
                    }
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = PurpleAccent2,
                    contentColor = White87
                ),
            ) {
                Text("Save")
            }
        },
        dismissButton = {
            TextButton(
                onClick = { onDismiss() },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = White87
                ),
            ) {
                Text("Cancel")
            }
        }
    )
}
