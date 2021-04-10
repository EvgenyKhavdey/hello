package Testing;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Comparator;

public class TestsHandler {
    private static Object obj;

    public static void start(Class aClass) {
        if (!areBeforeAfterAnnotationsCorrect(aClass)) {
            throw new RuntimeException();
        }

        try {
            obj = aClass.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }


        Method beforeM = null;
        Method afterM = null;
        ArrayList<Method> testMethods = new ArrayList<>();
        Method[] objMethods = aClass.getDeclaredMethods();

        for (Method method : objMethods) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                beforeM = method;
            } else if (method.getAnnotation(AfterSuite.class) != null) {
                afterM = method;
            } else if (method.getAnnotation(Test.class) != null) {
                testMethods.add(method);
            }
        }

        testMethods.sort(Comparator.comparingInt(o -> o.getAnnotation(Test.class).priority()));

        if (beforeM != null) {
            testMethods.add(0, beforeM);
        }

        if (afterM != null) {
            testMethods.add(afterM);
        }

        try {
            for (Method testMethod : testMethods) {
                if (Modifier.isPrivate(testMethod.getModifiers())) {
                    testMethod.setAccessible(true);
                }
                testMethod.invoke(obj);
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    private static boolean areBeforeAfterAnnotationsCorrect(Class aClass) {
        int beforeAnnotationCount = 0;
        int afterAnnotationCount = 0;

        for (Method method : aClass.getDeclaredMethods()) {
            if (method.getAnnotation(BeforeSuite.class) != null) {
                beforeAnnotationCount++;
            }
            if (method.getAnnotation(AfterSuite.class) != null) {
                afterAnnotationCount++;
            }
        }

        return (beforeAnnotationCount < 2) && (afterAnnotationCount < 2);
    }
}
