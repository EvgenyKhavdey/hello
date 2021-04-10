import org.junit.*;
import org.junit.rules.Timeout;


public class ToodClassTest {
    private static ToodClass toodClass;

    @BeforeClass
    public static void initTest() {
        toodClass = new ToodClass();
        System.out.println("init suite");
    }

    @AfterClass
    public static void destroy() { toodClass = null;
    }

    @Test
    public void testMass11() {
        int[] t = {1, 2, 4, 5, 6};
        int[] t1 = toodClass.mass1(t);
        int[] m = {5, 6};
        for (int i = 0; i < m.length; i++) {
            Assert.assertEquals(m[i], t1[i]);
        }
    }
    @Test
    public void testMass12() {
        int[] t = {4, 4, 2, 4, 5};
        int[] t1 = toodClass.mass1(t);
        int[] m = {5};
        for (int i = 0; i < m.length; i++) {
            Assert.assertEquals(m[i], t1[i]);
        }
    }
    @Test
    public void testMass13() {
        int[] t = {0, 11, 6, 8, 4, 4, 9, 14};
        int[] t1 = toodClass.mass1(t);
        int[] m = {9, 14};
        for (int i = 0; i < m.length; i++) {
            Assert.assertEquals(m[i], t1[i]);
        }
    }
    @Test
    public void testMass14() {
        int[] t = {1, 2, 4, 5, 6, 4, 1, 8, 2};
        int[] t1 = toodClass.mass1(t);
        int[] m = {1, 8, 2};
        for (int i = 0; i < m.length; i++) {
            Assert.assertEquals(m[i], t1[i]);
        }
    }

    @Test
    public void testMass21() {
        int[] t = {1, 2, 4, 5, 6};
        Assert.assertEquals(true, toodClass.mass2(t));

    }
    @Test
    public void testMass22() {
        int[] t = {0, 2, 8, 5, 6};
        Assert.assertEquals(false, toodClass.mass2(t));

    }
    @Test
    public void testMass23() {
        int[] t = {3, 2, 5, 5, 6};
        Assert.assertEquals(false, toodClass.mass2(t));

    }
    @Test
    public void testMass24() {
        int[] t = {1, 2, 0, 5, 6};
        Assert.assertEquals(true, toodClass.mass2(t));

    }
}
