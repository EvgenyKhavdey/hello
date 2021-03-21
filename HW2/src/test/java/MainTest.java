import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MainTest {

    @Test
    public void off() {

        int[] arrN4 = {1, 2, 3, 4, 5};
        int[] afterArrN4 = {2, 3, 4, 5, 1};
        int n = 4;
        int[] testArrN4 = arr(arrN4, n);

        for (int i = 0; i < arrN4.length; i++) {
            assertEquals(afterArrN4[i], testArrN4[i]);
        }

        int[] arrN3 = {1, 2, 3, 4, 5, 6};
        int[] afterArrN3 = {4, 2, 3, 1, 1, 2};
        n = 3;
        int[] testArrN3 = arr(arrN3, n);

        for (int i = 0; i < arrN3.length; i++) {
            assertEquals(afterArrN3[i], testArrN3[i]);
        }

        int[] arrN2 = {1, 2, 3, 4};
        int[] afterArrN2 = {3, 4, 1, 2};
        n = 2;
        int[] testArrN2 = arr(arrN2, n);

        for (int i = 0; i < arrN2.length; i++) {
            assertEquals(afterArrN2[i], testArrN2[i]);
        }
    }

    private int[] arr(int[] arr, int n) {
        int temp = arr[0];
        int currentIndex = n;
        int jumps = 1;

        while(jumps <= arr.length) {
            int swap = arr[currentIndex % arr.length];
            arr[currentIndex % arr.length] = temp;
            temp = swap;
            if ((jumps * n) % arr.length == 0) {
                currentIndex++;
                temp = arr[currentIndex % arr.length];
            }
            currentIndex += n;
            jumps++;
        }
        return arr;
    }




    @Test
    public void summ() {
        int arr[] = {1, 1, 3, 1, 1, 3};
        int arr1[] = {1, 1, 3, 4, 2, 2, 1, 1, 3};
        int arr2[] = {1, 2, 2, 2, 2, 2};
        int arr3[] = {1, 1, 2, 3, 2, 3, 0, 2, 3};

        assertEquals(foo(arr), true);
        assertEquals(foo(arr1), true);
        assertEquals(foo(arr2), false);
        assertEquals(foo(arr3), false);

    }

    private boolean foo(int[] arr) {
        int sumLeft = arr[0] + arr[1];
        int sumRight;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        for (int i = 2; i < arr.length - 2; i++) {
            sumRight = sum - sumLeft;
            if (sumLeft == sumRight) {
                return true;
            }
            sumLeft += arr[i];
        }

        return false;
    }
}

