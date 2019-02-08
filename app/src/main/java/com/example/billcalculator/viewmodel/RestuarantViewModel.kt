package com.example.billcalculator.viewmodel

import android.app.Application
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

    private var lastTipCalculation = TipCalculation()

    var inputCheckAmount = ""
    var inputTipPercentage = ""

    val outputCheckAmount
        get() = getApplication<Application>().getString(R.string.dollar_amount, lastTipCalculation.checkAmount)

    val outputTipAmount
        get() = getApplication<Application>().getString(R.string.dollar_amount, lastTipCalculation.tipAmount)

    val outputTotalAmount
        get() = getApplication<Application>().getString(R.string.dollar_amount, lastTipCalculation.grandTotal)

    val locationName get() = lastTipCalculation.locationName

    init {
        updateOutputs(TipCalculation())
    }

    private fun updateOutputs(tipCalculation: TipCalculation) {
        lastTipCalculation = tipCalculation
        notifyChange()
    }

    fun calculateTip() {
        val checkAmount = inputCheckAmount.toDoubleOrNull()
        val tipPercentage = inputTipPercentage.toIntOrNull()

        if (checkAmount != null && tipPercentage != null) {
            updateOutputs(restuarantTipCalculator.calculateTip(checkAmount, tipPercentage))
        }
    }


    fun saveCurrentTip(name: String) {
        val tipToSave = lastTipCalculation.copy(locationName = name)

        restuarantTipCalculator.saveTipCalculation(tipToSave)

        updateOutputs(tipToSave)
    }


}