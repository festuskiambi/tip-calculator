package com.example.billcalculator.viewmodel

import android.util.Log
import androidx.databinding.BaseObservable
import com.example.billcalculator.model.RestuarantTipCalculator
import com.example.billcalculator.model.TipCalculation

/**
 * Created by Festus Kiambi on 2/6/19.
 */
class RestuarantViewModel(
    val restuarantTipCalculator: RestuarantTipCalculator = RestuarantTipCalculator()
) : BaseObservable() {

    var inputCheckAmount = ""
    var inputTipPercentage = ""
    var calculation = TipCalculation()

    fun calculateTip() {
        val checkAmount = inputCheckAmount.toDoubleOrNull()
        val tipPercentage = inputTipPercentage.toIntOrNull()

        if (checkAmount != null && tipPercentage != null) {
            calculation = restuarantTipCalculator.calculateTip(checkAmount, tipPercentage)
            clearinputs()
        }
    }

    private fun clearinputs() {
        inputTipPercentage = ""
        inputCheckAmount = ""
        notifyChange()
    }
}