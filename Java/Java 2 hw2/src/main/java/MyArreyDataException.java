public class MyArreyDataException extends Exception{

    public int i;
    public int j;

    public MyArreyDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }
}
