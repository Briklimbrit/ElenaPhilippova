package hw1.suites;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.IncludeCategory(SumSubTestsCategory.class)
@Suite.SuiteClasses({hw1.testsJunit.AdditionTest.class, hw1.testsJunit.SubstractionTest.class})
public class SumSubTestsSuite {
}
