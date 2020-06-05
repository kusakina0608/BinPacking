import java.util.ArrayList;

public class WorstFit implements Fit {
    @Override
    public String toString() {
        return "WorstFit";
    }
    @Override
    public void fit(ArrayList<Bin> arrayList, Item item) {
        Bin worstBin = null;
        int maxCapacity = 0;
        for(Bin a : arrayList){
            if(a.check(item)){
                if( maxCapacity < a.getRemain()){
                    maxCapacity = a.getRemain();
                    worstBin = a;
                }
            }
        }
        if(worstBin != null){
            worstBin.update(item);
            return;
        }
        Bin newBin = new Bin();
        newBin.update(item);
        arrayList.add(newBin);
    }
}
