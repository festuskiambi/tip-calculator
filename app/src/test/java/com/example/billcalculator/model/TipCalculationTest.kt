package com.example.billcalculator.model

import io.mockk.clearMocks
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * Created by Festus Kiambi on 2/6/19.
 */
class TipCalculationTest {

    val restuarantTipCalculator: RestuarantTipCalculator = RestuarantTipCalculator()

    fun getCalculation(
         checkAmount: Double = 10.00,
         tipPctg: Int = 25,
         tipAmount: Double = 2.50,
         grandTotal: Double = 12.50
    ) = TipCalculation(
        checkAmount,
        tipPctg,
        tipAmount,
        grandTotal
    )

    @BeforeEach
    fun setUpRedundantMocks() {
        clearMocks()
    }

    @Test
    fun`calculate tip successfully` () {
        val tipCalcalculation = getCalculation()

        val result = restuarantTipCalculator.calculateTip(
            tipCalcalculation.checkAmount,
            tipCalcalculation.tipPctg
        )

        assertEquals(result,tipCalcalculation)
    }
}