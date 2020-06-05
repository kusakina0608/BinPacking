import java.util.ArrayList;

public class FirstFit implements Fit{
    @Override
    public String toString() {
        return "FirstFit";
    }

    @Override
    public void fit(ArrayList<Bin> arrayList, Item item) {
        boolean pushed = false;
        for(Bin a : arrayList){
            if(a.check(item)){
                a.update(item);
                pushed = true;
                break;
            }
        }
        if(!pushed){
            Bin newBin = new Bin();
            newBin.update(item);
            arrayList.add(newBin);
        }
    }
}
