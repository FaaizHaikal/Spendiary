package com.example.spendiary.utils

import java.text.DecimalFormatSymbols
import java.util.Locale

class DecimalFormatter(
    symbols: DecimalFormatSymbols = DecimalFormatSymbols.getInstance(Locale("id", "IDN"))
) {
    private val thousandsSeparator = symbols.groupingSeparator
    private val decimalSeparator = symbols.decimalSeparator

    fun cleanup(text: String): String {
        if (text.matches("\\D".toRegex())) return ""
        if (text.matches("0+".toRegex())) return "0"

        val stringBuilder = StringBuilder()
        var hasDecimalSeparator = false

        for (char in text) {
            if (char.isDigit()) {
                stringBuilder.append(char)
                continue
            }

            if (char == decimalSeparator && !hasDecimalSeparator && stringBuilder.isNotEmpty()) {
                stringBuilder.append(char)
                hasDecimalSeparator = true
            }
        }

        return stringBuilder.toString()
    }

    fun formatVisual(text: String): String {
        val split = text.split(decimalSeparator)

        val intPart = split[0]
            .reversed()
            .chunked(3)
            .joinToString(separator = thousandsSeparator.toString())
            .reversed()

        val fractionPart = split.getOrNull(1)

        return if (fractionPart == null) {
            intPart
        } else {
            intPart + decimalSeparator + fractionPart + fractionPart
        }
    }
}