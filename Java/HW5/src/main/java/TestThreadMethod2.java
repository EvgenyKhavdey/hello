public class TestThreadMethod2 implements Runnable{
    static final int size = 10000000;
    static final int h = size/2;
    float[] arr = new float[size];
    @Override
    public void run() {
        for (int i = 0; i < arr.length; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();
        System.out.println("Тест 2 = " + a );
        float[] oneArr = new float[h];
        float[] twoArr = new float[h];
        System.arraycopy(arr, 0, oneArr, 0, h);
        System.arraycopy(arr, h, twoArr, 0, h);
        Thread a1 = new Thread(() -> {
            for (int i = 0; i < oneArr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        Thread a2 = new Thread(() -> {
            for (int i = 0; i < twoArr.length; i++) {
                arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        });
        a1.start();
        a2.start();
        System.arraycopy(oneArr, 0, arr, 0, h);
        System.arraycopy(twoArr, 0, arr, h, h);
        System.currentTimeMillis();
        System.out.println("Тест 2 = " + (System.currentTimeMillis() - a));
    }
}
