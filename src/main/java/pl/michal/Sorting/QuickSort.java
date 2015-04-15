package pl.michal.Sorting;

import java.util.Arrays;

/**
 * Created by Michał on 2015-02-09.
 */
public class QuickSort {
    void quickSort(int tab[], int left, int right){
        if(left<right){
            int m=left;
            outer:	for(int i=left+1;i<=right;i++){
                m=i-1;
                if(tab[left]<tab[i]){
                    for(int j=right;j>=i;j--){
                        if(tab[left]>tab[j]){
                            swap(tab, i, j);
                            continue outer;
                        }
                        else if(i==j){
                            swap(tab,--i, left);
                            break outer;
                        }
                    }
                }
                else if (i==right){
                    swap(tab,left,i);
                    m=i;
                }
            }
            quickSort(tab,left,m-1);
            quickSort(tab,m+1,right);
        }
    }
    public void swap(int [] tab, int smaller, int bigger){
        int temp = tab[smaller];
        tab[smaller]=tab[bigger];
        tab[bigger]=temp;
    }
    public static void main(String[] args)
    {
        QuickSort quickS = new QuickSort();
        int [] tab = {2,0,8,2,9,11,23,19};
        System.out.println(Arrays.toString(tab));
        quickS.quickSort(tab,0,(tab.length-1));
        System.out.println(Arrays.toString(tab));
    }

}
