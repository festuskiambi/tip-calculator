package com.example.billcalculator.model

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * Created by Festus Kiambi on 2/7/19.
 */
class TipCalculculationRepositoryTest {

    val tipCalculationRepository  = TipCalculationRepository()

    fun getCalculation(
        locationName: String = "Nairobi",
        checkAmount: Double = 10.00,
        tipPctg: Int = 25,
        tipAmount: Double = 2.50,
        grandTotal: Double = 12.50
    ) = TipCalculation(
        locationName,
        checkAmount,
        tipPctg,
        tipAmount,
        grandTotal
    )

    @Test
    fun `on get save tip calculation succesfully` () {
        val tipCalculation = getCalculation()

        tipCalculationRepository.saveTipCalculation(tipCalculation)

        assertEquals(tipCalculation, tipCalculationRepository.getTipCalculationByID(tipCalculation.locationname))

    }

    @Test
    fun `on get saved tip calculations successfully` () {
        val tipCalculation = getCalculation(locationName = "Mombasa")
        val tipCalculation1 = getCalculation()

        tipCalculationRepository.saveTipCalculation(tipCalculation)
        tipCalculationRepository.saveTipCalculation(tipCalculation1)

        val result = tipCalculationRepository.getTipcalculations()
    }
}