package com.example.billcalculator.model

/**
 * Created by Festus Kiambi on 2/6/19.
 */

data class TipCalculation(
    val locationname: String = "",
    val checkAmount: Double = 0.0,
    val tipPctg: Int = 0,
    val tipAmount: Double = 0.0,
    val grandTotal: Double = 0.0
)