import Testing.AfterSuite;
import Testing.BeforeSuite;
import Testing.Test;

public class ClassForTesting {

    @Test(priority = 5)
    public void testMethod1() {
        System.out.println("Тест приоритет B");
    }

    @Test(priority = 1)
    public void testMethod2() {
        System.out.println("Тест приоритет А");
    }

    @Test(priority = 10)
    public void testMethod3() {
        System.out.println("Тест приоритет D");
    }

    @Test(priority = 3)
    private void testMethod4() {
        System.out.println("Тест приоритет C");
    }

    @Test
    public void testMethod5() {
        System.out.println("Тест ");
    }

    @AfterSuite
    public void afterMethod() {
        System.out.println("AfterSuite тест");
    }

    @BeforeSuite
    public void beforeSuiteMethod() {
        System.out.println("BeforeSuite тест");
    }

}
