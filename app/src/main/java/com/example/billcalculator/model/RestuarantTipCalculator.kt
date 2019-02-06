package com.example.billcalculator.model

import java.math.RoundingMode

/**
 * Created by Festus Kiambi on 2/6/19.
 */

class RestuarantTipCalculator {

    fun calculateTip(checkAmount: Double, tipPctg: Int): TipCalculation {
        val tipAmount = (checkAmount * (tipPctg.toDouble() / 100))
            .toBigDecimal()
            .setScale(2, RoundingMode.HALF_UP)
            .toDouble()

        val grandTotal = checkAmount + tipAmount

        return TipCalculation(checkAmount, tipPctg, tipAmount, grandTotal)
    }
}