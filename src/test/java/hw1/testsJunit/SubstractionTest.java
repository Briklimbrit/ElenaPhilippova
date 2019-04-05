package hw1.testsJunit;

import com.epam.tat.module4.Calculator;
import org.junit.*;
import org.junit.experimental.categories.Category;
// TODO Проверить работу на не используемые импорты
@Category(hw1.suites.SumSubTestsCategory.class)
public class SubstractionTest {

    Calculator calculator;

    @BeforeClass
    public static void classInit() {
        System.out.println("hw1.testsJunit.SubstractionTest init");
    }

    @Before
    public void setUps(){
        calculator = new Calculator();
    }

    @Test
    public void testSubDoubleMethod(){
        double result = calculator.sub(1, 0.99);
        Assert.assertEquals(0.01, result, 0.1);
    }

    @Test
    public void testSubLongMethod(){
        long result = calculator.sub(0, -13);
        Assert.assertEquals(13, result);
    }

    @After
    public void tearDown() {
        System.out.println("Test complete");
    }

    @AfterClass
    public static void classTearDown() {
        System.out.println("hw1.testsJunit.SubstractionTest tear down");
    }

}