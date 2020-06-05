import java.util.ArrayList;

public class NextFit implements Fit {
    @Override
    public String toString() {
        return "NextFit";
    }
    @Override
    public void fit(ArrayList<Bin> arrayList, Item item) {
        if(arrayList.size() != 0) {
            Bin lastBin = arrayList.get(arrayList.size() - 1);
            if (lastBin.check(item)) {
                lastBin.update(item);
                return;
            }
        }
        Bin newBin = new Bin();
        newBin.update(item);
        arrayList.add(newBin);
    }
}
