package com.example.billcalculator.viewmodel

import android.app.Application
import androidx.databinding.BaseObservable
import com.example.billcalculator.R
import com.example.billcalculator.model.RestuarantTipCalculator
import com.example.billcalculator.model.TipCalculation

/**
 * Created by Festus Kiambi on 2/6/19.
 */
class RestuarantViewModel @JvmOverloads constructor(
     app: Application,
    val restuarantTipCalculator: RestuarantTipCalculator = RestuarantTipCalculator()
) : ObservableViewModel(app) {

    var inputCheckAmount = ""
    var inputTipPercentage = ""
    var outputCheckAmount = ""
    var outputTipAmount = ""
    var outputTotalAmount = ""

    init {
        updateOutputs(TipCalculation())
    }

    private fun updateOutputs(tipCalculation: TipCalculation) {
        outputCheckAmount = getApplication<Application>().getString(R.string.dollar_amount, tipCalculation.checkAmount)
        outputTipAmount =  getApplication<Application>().getString(R.string.dollar_amount, tipCalculation.tipAmount)
        outputTotalAmount =  getApplication<Application>().getString(R.string.dollar_amount, tipCalculation.grandTotal)
    }

    fun calculateTip() {
        val checkAmount = inputCheckAmount.toDoubleOrNull()
        val tipPercentage = inputTipPercentage.toIntOrNull()

        if (checkAmount != null && tipPercentage != null) {
            updateOutputs(restuarantTipCalculator.calculateTip(checkAmount, tipPercentage))
            clearInputs()
        }
    }

    private fun clearInputs() {
        inputTipPercentage = ""
        inputCheckAmount = ""
        notifyChange()
    }
}