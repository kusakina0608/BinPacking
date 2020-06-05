public class Bin {
    private int capacity = 10;
    private int current = 0;

    public boolean check(Item item){
        if(item.getWeight() + current <= capacity)
            return true;
        return false;
    }
    public void update(Item item){
        current += item.getWeight();

    }
    public int getRemain(){
        return capacity-current;
    }
    @Override
    public String toString() {
        return (current+"/"+capacity);
    }
}
