package work1;


public class Hw1 <T>{
    private T[] obj;

    public Hw1(T... obj) {
        this.obj = obj;
    }

    public T[] getObj() {
        return obj;
    }


    public T[] replacement(){
        if (obj.length >= 2){
            T a = obj[0];
            obj[0] = obj[1];
            obj[1] = a;
        }
        return obj;
    }
}
