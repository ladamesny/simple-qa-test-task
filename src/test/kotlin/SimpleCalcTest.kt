import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SimpleCalcTest {

    @Test
    fun testAdd() {
        assertEquals(5, SimpleCalc.add(2, 3))
        assertEquals(-1, SimpleCalc.add(2, -3))
        assertEquals(0, SimpleCalc.add(0, 0))
    }

    @Test
    fun testMultiply() {
        assertEquals(6.0, SimpleCalc.multiply(2.0, 3.0))
        assertEquals(-6.0, SimpleCalc.multiply(2.0, -3.0))
        assertEquals(0.0, SimpleCalc.multiply(0.0, 0.0))
        assertEquals(0.0, SimpleCalc.multiply(0.0, 2.0))
    }

    @Test
    fun testSumOfEvens() {
        assertEquals(6, SimpleCalc.sumOffEvens(intArrayOf(1, 2, 3, 4)))
        assertEquals(0, SimpleCalc.sumOffEvens(intArrayOf(1, 3, 5)))
        assertEquals(0, SimpleCalc.sumOffEvens(intArrayOf()))
    }
}