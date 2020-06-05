import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        int[] items = {7, 5, 6, 4, 2, 3, 7, 5};
        ArrayList<Bin> arrayList = new ArrayList<>();
        Fit fit = new FirstFit();
        for(int item : items){
            fit.fit(arrayList, new Item(item));
        }
        int i = 1;
        System.out.println(fit);
        for(Bin bin : arrayList){
            System.out.println("Bin " + i++ + ": " + bin);
        }
    }
}
