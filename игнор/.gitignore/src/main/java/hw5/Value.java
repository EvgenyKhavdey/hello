public class Value {
// задание 5
    public static void value (String [] args){
        int a = 20;
        System.out.println(positive());
    }
    public static boolean positive(){
        if(a >= 0 ){
            return "Положительное число";
        } else {
            return "Отрицателеное число";
        }
    }
}
