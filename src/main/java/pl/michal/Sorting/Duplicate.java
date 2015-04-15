package pl.michal.Sorting;

import com.sun.org.apache.bcel.internal.generic.DUP;

/**
 * Created by Micha³ on 2015-04-02.
 */
public class Duplicate {
    int valMax=0;

    public int getValMax() {
        return valMax;
    }

    public int count (int [] tab){
        int countMax=1;
        int val=0;
        int count=1;

        for (int i=1; i<tab.length; i++){
            if(tab[i]==tab[i-1]){
                ++count;
                val=tab[i];

                if(count>countMax){
                    countMax=count;
                    valMax=val;
                }
            }
            else {
                count=1;
            }
        }
        return countMax;
    }

    public static void main(String[] args) {
        Duplicate counter = new Duplicate();
        System.out.println("number counter: "+counter.count(new int [] {1,3,3,1,2,2,2}));
        System.out.println("duplicate number "+counter.getValMax());
    }
}
