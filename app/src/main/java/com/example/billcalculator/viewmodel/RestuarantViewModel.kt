package com.example.billcalculator.viewmodel

import android.util.Log
import com.example.billcalculator.model.RestuarantTipCalculator
import com.example.billcalculator.model.TipCalculation

/**
 * Created by Festus Kiambi on 2/6/19.
 */
class RestuarantViewModel(val restuarantTipCalculator: RestuarantTipCalculator = RestuarantTipCalculator()) {

    var inputCheckAmount = ""
    var inputTipPercentage = ""
    var calculation = TipCalculation()

    fun calculateTip(): TipCalculation{
        val checkAmount = inputCheckAmount.toDoubleOrNull()
        val tipPercentage = inputTipPercentage .toIntOrNull()

        if(checkAmount != null && tipPercentage !=null) {

            calculation = restuarantTipCalculator.calculateTip(checkAmount, tipPercentage)
        }
        return this.calculation
    }
}