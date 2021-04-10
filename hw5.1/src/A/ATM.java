package A;


public class ATM {
    private static int t = 0;
    private static int w = 0;

     static synchronized void getSynch() {
        try {
           if (t < 1){
               t ++;
               System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
           }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    static synchronized void getWin(String name){
        try {
            if (w < 1){
                w ++;
                System.out.println(name + " Победил");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
