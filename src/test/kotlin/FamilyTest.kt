import org.junit.Test
import kotlin.test.assertEquals

class FamilyTest {

    @Test
    fun paysFlatRate(){
        val family = Family(9)
        assertEquals(9, family.getPay(17))
    }

    @Test
    fun paysFlatRateIfNoRuleApplies(){
        val family = Family(10)
        assertEquals(10, family.getPay(10))
    }

    @Test
    fun paysPriceBeforeRuleHour(){
        val rules = mutableMapOf<Int, Int>()
        rules[17] = 5
        val family = Family(10, rules)
        assertEquals(5, family.getPay(16))
    }

    @Test
    fun paysPriceBeforeEarliestRuleHour(){
        val rules = mutableMapOf<Int, Int>()
        rules[18] = 6
        rules[17] = 5
        val family = Family(10, rules)
        assertEquals(5, family.getPay(16))
    }

    @Test
    fun paysPriceOfEarliestAppropriateRule(){
        val rules = mutableMapOf<Int, Int>()
        rules[18] = 6
        rules[14] = 5
        val family = Family(10, rules)
        assertEquals(6, family.getPay(16))
    }

    @Test
    fun whenNoAppropriateRuleUseBasePay(){
        val rules = mutableMapOf<Int, Int>()
        rules[18] = 6
        rules[14] = 5
        val family = Family(10, rules)
        assertEquals(10, family.getPay(20))
    }

}