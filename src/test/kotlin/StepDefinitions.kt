import io.cucumber.java8.En
import org.junit.Assert.assertEquals
import SimpleCalc

class StepDefinitions : En {
    private lateinit var numbers: IntArray
    private var number1: Double = 0.0
    private var number2: Double = 0.0
    private var result: Double = 0.0
    private var intResult: Int = 0

    init {
        Before { scenario ->
            // This will run before each Scenario
            println("Starting scenario: ${scenario.name}")
        }

        After { scenario ->
            // This will run after each Scenario
            println("Finished scenario: ${scenario.name}")
        }

        Given("the numbers {double} and {double}") { num1: Double, num2: Double ->
            number1 = num1
            number2 = num2
        }

        Given("an array of numbers") { docString: String ->
            numbers = docString.split(",").map { it.trim().toInt() }.toIntArray()
        }

        When("I calculate the sum of even numbers") {
            intResult = SimpleCalc.sumOffEvens(numbers)
        }

        When("I add them") {
            result = SimpleCalc.add(number1.toInt(), number2.toInt()).toDouble()
        }

        When("I multiply them") {
            result = SimpleCalc.multiply(number1, number2).toDouble()
        }

        Then("I should get {double}") { expected: Double ->
            assertEquals(expected, result, 0.001)
        }

        Then("I should get an int result of {int}") { expected: Int ->
          assertEquals(expected, intResult)
        }
    }
}