package com.example.billcalculator.viewmodel

import com.example.billcalculator.model.RestuarantTipCalculator
import com.example.billcalculator.model.TipCalculation
import io.mockk.clearMocks
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * Created by Festus Kiambi on 2/6/19.
 */

class RestuarantViewModelTest {

    val restuarantTipCalculator: RestuarantTipCalculator = mockk(relaxed = true)

    val restuarantViewModel: RestuarantViewModel = RestuarantViewModel(restuarantTipCalculator)


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
    fun `calculate tip successfully`() {
        val calculation = getCalculation()
        restuarantViewModel.inputCheckAmount = calculation.checkAmount.toString()
        restuarantViewModel.inputTipPercentage = calculation.tipPctg.toString()

        every { restuarantTipCalculator.calculateTip(calculation.checkAmount, calculation.tipPctg) } returns calculation

        val result = restuarantViewModel.calculateTip()

        verify { restuarantTipCalculator.calculateTip(calculation.checkAmount, calculation.tipPctg) }
        assertEquals(result, calculation)
    }

}