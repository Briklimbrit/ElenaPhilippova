package hw1.testsJunit;

import com.epam.tat.module4.Calculator;
import org.junit.*;
import org.junit.experimental.categories.Category;
@Category(hw1.suites.MultDivTestsCategory.class)
public class MultiplicationTest {

    Calculator calculator;

    @BeforeClass
    public static void classInit() {
        System.out.println("hw1.testsJunit.MultiplicationTest init");
    }

    @Before
    public void setUps(){
        calculator = new Calculator();
    }

    @Test
    public void testMultDoubleMethod(){
        double result = calculator.mult(0, 0.99);
        Assert.assertEquals(0, result, 0.1);
    }

    @Test
    public void testMultLongMethod(){
        long result = calculator.mult(91, -13);
        Assert.assertEquals(-1183, result);
    }

    @After
    public void tearDown() {
        System.out.println("Test complete");
    }

    @AfterClass
    public static void classTearDown() {
        System.out.println("hw1.testsJunit.MultiplicationTest tear down");
    }
}
