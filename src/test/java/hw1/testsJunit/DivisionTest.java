package hw1.testsJunit;

import com.epam.tat.module4.Calculator;
import org.junit.*;
import org.junit.experimental.categories.Category;

@Category(hw1.suites.MultDivTestsCategory.class)
public class DivisionTest {

    Calculator calculator;

    @BeforeClass
    public static void classInit() {
        System.out.println("hw1.testsJunit.DivisionTest init");
    }

    @Before
    public void setUps(){
        calculator = new Calculator();
    }

    @Test
    public void testDivDoubleMethod(){
        double result = calculator.div(0, 12);
        Assert.assertEquals(0, result, 0.1);
    }

    @Test
    public void testDivLongMethod(){
        long result = calculator.div(85, 3);
        Assert.assertEquals(28, result);
    }

    @After
    public void tearDown() {
        System.out.println("Test complete");
    }

    @AfterClass
    public static void classTearDown() {
        System.out.println("hw1.testsJunit.DivisionTest tear down");
    }
}
