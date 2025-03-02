package com.example.spendiary.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.spendiary.ui.components.AddExpenseDialog
import com.example.spendiary.ui.components.BarChart
import com.example.spendiary.ui.components.RoundButton
import com.example.spendiary.ui.theme.BlueAccent
import com.example.spendiary.ui.theme.GreenAccent
import com.example.spendiary.ui.theme.RedAccent

@Composable
fun HomeScreen(
) {
    var showAddExpenseDialog by remember { mutableStateOf(false) }

    Column (
        modifier = Modifier.padding(horizontal = 24.dp, vertical = 72.dp)
    ) {
        ThisMonthExpenses()
        Spacer(modifier = Modifier.height(16.dp))
        TotalSavings()
        Spacer(modifier = Modifier.height(32.dp))
        ButtonGroup(
            onAddExpense = { showAddExpenseDialog = true }
        )
    }

    if (showAddExpenseDialog) {
        AddExpenseDialog(
            onDismiss = { showAddExpenseDialog = false }
        )
    }
}

@Composable
fun ButtonGroup(
    onAddExpense: () -> Unit
) {
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        RoundButton(
            icon = Icons.Default.Star,
            text = "Add Savings",
            color = GreenAccent,
            onClick = { println("Add Savings") }
        )

        RoundButton(
            icon = Icons.Default.DateRange,
            text = "Logs",
            color = BlueAccent,
            onClick = { println("Logs") }
        )

        RoundButton(
            icon = Icons.Default.ShoppingCart,
            text = "Add Expense",
            color = RedAccent,
            onClick = { onAddExpense() }
        )
    }
}

@Composable
fun ThisMonthExpenses() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(16.dp)
    ) {
        Text(
            text = "This Month Expenses",
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Rp. 1.000.000,00",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Transaction Count", style = MaterialTheme.typography.bodySmall)
            Text(text = "100", style = MaterialTheme.typography.bodySmall)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Remaining Balance", style = MaterialTheme.typography.bodySmall)
            Text(text = "Rp. 1.500.000,00", style = MaterialTheme.typography.bodySmall)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Status", style = MaterialTheme.typography.bodySmall)
            Text(text = "On Track", style = MaterialTheme.typography.bodySmall, color = GreenAccent)
        }

        Spacer(modifier = Modifier.height(16.dp))

        BarChart(
            data = listOf(
                "1st March" to 150f,
                "2nd March" to 200f,
                "3rd March" to 180f,
                "4th March" to 150f,
                "5th March" to 200f,
                "6th March" to 180f,
                "7th March" to 150f,
                "8th March" to 200f,
                "9th March" to 180f,
                "10th March" to 150f,
                "12th March" to 200f,
                "13th March" to 180f,
                "14th March" to 150f,
                "15th March" to 200f,
                "16th March" to 180f,
                "17th March" to 150f,
                "18th March" to 200f,
                "19th March" to 180f,
                "20th March" to 150f,
                "21st March" to 150f,
                "22nd March" to 200f,
                "23rd March" to 180f,
                "24th March" to 150f,
                "25th March" to 200f,
                "26th March" to 180f,
                "27th March" to 150f,
                "28th March" to 200f,
                "29th March" to 180f,
                "30th March" to 150f,
                "31th March" to 180f,
            ),
            chartHeight = 120f
        )
    }
}

@Composable
fun TotalSavings() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                color = MaterialTheme.colorScheme.primary,
                shape = RoundedCornerShape(4.dp)
            )
            .padding(16.dp)
    ) {
        Text(
            text = "Total Savings",
            style = MaterialTheme.typography.bodySmall
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Rp. 1.000.000,00",
            style = MaterialTheme.typography.bodyMedium
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Savings Count", style = MaterialTheme.typography.bodySmall)
            Text(text = "10", style = MaterialTheme.typography.bodySmall)
        }

        Spacer(modifier = Modifier.height(8.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = "Monthly Status", style = MaterialTheme.typography.bodySmall)
            Text(text = "Done", style = MaterialTheme.typography.bodySmall, color = GreenAccent)
        }

        Spacer(modifier = Modifier.height(16.dp))

        BarChart(
            data = listOf(
                "1st March" to 150f,
                "2nd March" to 200f,
                "3rd March" to 180f,
                "4th March" to 150f,
                "5th March" to 200f,
                "6th March" to 180f,
                "7th March" to 150f,
                "8th March" to 200f,
                "9th March" to 180f,
                "10th March" to 150f,
                "12th March" to 200f,
                "13th March" to 180f,
                "14th March" to 150f,
                "15th March" to 200f,
                "16th March" to 180f,
                "17th March" to 150f,
                "18th March" to 200f,
                "19th March" to 180f,
                "20th March" to 150f,
                "21st March" to 150f,
                "22nd March" to 200f,
                "23rd March" to 180f,
                "24th March" to 150f,
                "25th March" to 200f,
                "26th March" to 180f,
                "27th March" to 150f,
                "28th March" to 200f,
                "29th March" to 180f,
                "30th March" to 150f,
                "31th March" to 180f,
            ),
            chartHeight = 120f
        )
    }
}