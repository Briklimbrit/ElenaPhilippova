package hw1.testsJunit;

import com.epam.tat.module4.Calculator;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
@RunWith(Parameterized.class)
public class ParametrizedTest {

    private long correctA;
    private long correctB;
    private long expectedNumber;
    Calculator calculator;

    @BeforeClass
    public static void classInit() {
        System.out.println("ParametrizedMultTest init");
    }

    @Before
    public void setUps(){
        calculator = new Calculator();
    }

    public ParametrizedTest(long corA, long corB, long expNumber){
        this.correctA = corA;
        this.correctB = corB;
        this.expectedNumber = expNumber;
    }

    @Parameterized.Parameters
    public static Iterable<Object[]> testData(){
        return Arrays.asList(new Object[][]{
                {0, 1, 0},
                {12, 83, 996},
                {-1, 780, -780},
                {-12, -2, 24}
        });
    }

    @Test
    public void testMultLongMethod(){
        long result = calculator.mult(correctA, correctB);
        Assert.assertEquals(expectedNumber, result);
    }

    @After
    public void tearDown() {
        System.out.println("Test complete");
    }

    @AfterClass
    public static void classTearDown() {
        System.out.println("ParametrizedMultTest tear down");
    }
}
