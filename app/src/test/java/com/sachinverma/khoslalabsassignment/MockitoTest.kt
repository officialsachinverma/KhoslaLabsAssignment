package com.sachinverma.khoslalabsassignment

import com.sachinverma.khoslalabsassignment.network.APIInterface
import org.mockito.Mock
import org.mockito.junit.MockitoJUnit


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class MockitoTest {

    @Mock
    lateinit var apiInterface: APIInterface

    @Rule
    var mockitoRule = MockitoJUnit.rule()

    @Test
    fun testConvertFahrenheitToCelsius() {
        val actual: Float = ConverterUtil.convertCelsiusToFahrenheit(100)
        // expected value is 212
        val expected = 212f
        // use this method because float is not precise
        assertEquals(
            "Conversion from celsius to fahrenheit failed",
            expected.toDouble(),
            actual.toDouble(), 0.001
        )
    }

    @Test
    fun testConvertCelsiusToFahrenheit() {
        val actual: Float = ConverterUtil.convertFahrenheitToCelsius(212)
        // expected value is 100
        val expected = 100f
        // use this method because float is not precise
        assertEquals(
            "Conversion from celsius to fahrenheit failed",
            expected.toDouble(),
            actual.toDouble(), 0.001
        )
    }
}
