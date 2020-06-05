> ## 통 채우기(Bin Packing) 문제

n 개의 물건이 주어지고, 통의 용량이 C일 때, 주어진 모든 물건을 가장 적은 수의 통에 채우는 문제이다.

그리디 알고리즘을 사용하여 통 채우기 문제를 해결한다면 다음과 같이 4가지 방법이 있을 수 있다.



> ### 최초 적합(Fitst Fit)

첫 번째 통부터 차례로 살펴보며, 가장 먼저 여유가 있는 통에 새 물건을 넣는 방식이다.

그대로 구현하면 된다.

[_FitstFit.java_](https://github.com/kusakina0608/BinPacking/blob/master/src/FirstFit.java)

```java
public class FirstFit implements Fit{
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
```

실행 결과는 다음과 같다.

<img src="https://raw.githubusercontent.com/kusakina0608/BinPacking/master/img/FirstFit.png" alt="FirstFit" style="zoom:50%;" />

> ### 다음 적합(Next Fit)

직전에 물건을 넣은 통에 여유가 있으면 그 통에 물건을 넣고, 여유가 없을 경우에는 새로운 통에 물건을 넣는다.

[_NextFit.java_](https://github.com/kusakina0608/BinPacking/blob/master/src/NextFit.java)

```java
public class NextFit implements Fit {
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
```

실행 결과는 다음과 같다.

<img src="https://raw.githubusercontent.com/kusakina0608/BinPacking/master/img/NextFit.png" alt="NextFit" style="zoom:50%;" />

> ### 최선 적합(Best Fit)

기존의 통 중에서 새 물건이 들어가면 **남는 부분이 가장 적은** 통에 새 물건을 넣는다.

[_BestFit.java_](https://github.com/kusakina0608/BinPacking/blob/master/src/BestFit.java)

```java
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
```

실행 결과는 다음과 같다.

<img src="https://raw.githubusercontent.com/kusakina0608/BinPacking/master/img/BestFit.png" alt="BestFit" style="zoom:50%;" />

> ### 최악 적합(Worst Fit)

기존의 통 중에서 새 물건이 들어가면 **남는 부분이 가장 큰** 통에 새 물건을 넣는다.

[_WorstFit.java_](https://github.com/kusakina0608/BinPacking/blob/master/src/WorstFit.java)

```java
public class WorstFit implements Fit {
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
```

실행 결과는 다음과 같다.

<img src="https://raw.githubusercontent.com/kusakina0608/BinPacking/master/img/WorstFit.png" alt="WorstFit" style="zoom:50%;" />