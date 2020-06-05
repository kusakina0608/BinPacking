import java.util.ArrayList;

public class BestFit implements Fit {
    @Override
    public void fit(ArrayList<Bin> arrayList, Item item) {
        Bin bestBin = null;
        int maxCapacity = Integer.MAX_VALUE;
        for(Bin a : arrayList){
            if(a.check(item)){
                if( maxCapacity > a.getRemain()){
                    maxCapacity = a.getRemain();
                    bestBin = a;
                }
            }
        }
        if(bestBin != null){
            bestBin.update(item);
            return;
        }
        Bin newBin = new Bin();
        newBin.update(item);
        arrayList.add(newBin);
    }
}
