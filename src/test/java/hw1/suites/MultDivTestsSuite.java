package hw1.suites;

import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;


@RunWith(Categories.class)
@Categories.IncludeCategory(MultDivTestsCategory.class)
@Suite.SuiteClasses({hw1.testsJunit.DivisionTest.class, hw1.testsJunit.MultiplicationTest.class})
public class MultDivTestsSuite {
}
