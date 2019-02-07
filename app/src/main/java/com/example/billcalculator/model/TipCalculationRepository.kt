package com.example.billcalculator.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * Created by Festus Kiambi on 2/7/19.
 */
class TipCalculationRepository {

    private val savedTipCalculations = mutableMapOf<String, TipCalculation>()

    fun saveTipCalculation(tipCalculation: TipCalculation) {

        savedTipCalculations[tipCalculation.locationname] = tipCalculation

    }

    fun getTipCalculationByID(locationName: String): TipCalculation? {

        return savedTipCalculations[locationName]
    }

    fun getTipcalculations(): LiveData<List<TipCalculation>> {

        val livedata = MutableLiveData<List<TipCalculation>>()

        livedata.value = savedTipCalculations.values.toList()

        return livedata
    }


}