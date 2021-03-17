import com.sun.org.apache.xerces.internal.impl.dv.DatatypeException;


public class Main {

    public static void main(String[] args) {
        String[][] arm = new String[][]{{"a", "3", "4", "3"}, {"1", "3", "2", "1"}, {"2", "1", "3", "4"}, {"3", "2", "1", "2"}};
        try {
            try {
                check(arm);
            } catch (MyArreySizeException e) {
                System.out.println("Размер массива превышен");
            }
        }catch (MyArreyDataException e){
            System.out.println("Не правельное значение массива");
            System.out.println("Ошибка в ячейке" + e. i + " " + e. j);
        }
    }

    public static int check (String[][] arr) throws MyArreySizeException, MyArreyDataException {
        int s = 0;
        if (arr.length != 4){
            throw new MyArreySizeException();
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].length != 4){
                throw new MyArreySizeException();
            }
            for (int j = 0; j < arr[i].length; j++) {
               try {
                   s = s + Integer.parseInt(arr[i][j]);
               } catch (NumberFormatException e){
                   throw new MyArreyDataException(i,j);
               }
            }
        }
        return s;

    }

}
