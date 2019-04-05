package hw1.suites;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
@Suite.SuiteClasses({hw1.testsJunit.AdditionTest.class, hw1.testsJunit.SubstractionTest.class, hw1.testsJunit.MultiplicationTest.class, hw1.testsJunit.DivisionTest.class, hw1.testsJunit.ParametrizedTest.class})
@RunWith(Suite.class)
public class AllTestsSuite {
}
