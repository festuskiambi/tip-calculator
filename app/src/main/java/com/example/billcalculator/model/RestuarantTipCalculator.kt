package com.example.billcalculator.model

import androidx.lifecycle.LiveData
import java.math.RoundingMode

/**
 * Created by Festus Kiambi on 2/6/19.
 */

class RestuarantTipCalculator(val tipCalculationRepository: TipCalculationRepository = TipCalculationRepository()) {

    fun calculateTip(checkAmount: Double, tipPctg: Int): TipCalculation {
        val tipAmount = (checkAmount * (tipPctg.toDouble() / 100))
            .toBigDecimal()
            .setScale(2, RoundingMode.HALF_UP)
            .toDouble()

        val grandTotal = checkAmount + tipAmount

        return TipCalculation("", checkAmount, tipPctg, tipAmount, grandTotal)
    }

    fun saveTipCalculation(tipCalculation: TipCalculation) {
        tipCalculationRepository.saveTipCalculation(tipCalculation)
    }

    fun getTipCalCulationById(locationname: String): TipCalculation? {

        return tipCalculationRepository.getTipCalculationByID(locationname)
    }

    fun getTipCalCulations() : LiveData<List<TipCalculation>> {
        return tipCalculationRepository.getTipcalculations()
    }
}