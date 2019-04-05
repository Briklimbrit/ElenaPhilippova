package hw1.testsJunit;

import com.epam.tat.module4.Calculator;
import org.junit.*;
import org.junit.experimental.categories.Category;

@Category(hw1.suites.SumSubTestsCategory.class)
public class AdditionTest {

    Calculator calculator;

    @BeforeClass
    public static void classInit() {
        System.out.println("hw1.testsJunit.AdditionTest init");
    }

    @Before
    public void setUps(){
        calculator = new Calculator();
    }

    @Test
    public void testSumDoubleMethod(){
        double result = calculator.sum(9.89,11.1);
        Assert.assertEquals(20.99, result, 0.1);
    }

    @Test
    public void testSumLongMethod(){
        long result = calculator.sum(0, 21);
        Assert.assertEquals(21, result);
    }

    @After
    public void tearDown() {
        System.out.println("Test complete");
    }

    @AfterClass
    public static void classTearDown() {
        System.out.println("hw1.testsJunit.AdditionTest tear down");
    }

}
