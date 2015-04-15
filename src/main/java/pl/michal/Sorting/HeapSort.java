package pl.michal.Sorting;

import java.util.Arrays;

/**
 * Created by Michał on 2015-02-11.
 */
public class HeapSort {
    public void heapSort(int[] tab, int left, int right){
        int end=right;
        heapify(tab,end);
        swap(tab,left,end);
        end--;
        while(left<end){
            siftDown(tab,left,end);
            swap(tab,left,end);
            --end;
        }
    }
    /**
     * Method restores the order of the heap in the branch where swapping took place
     * @param tab - array of integers
     * @param start - index of element that was swapped with its parent. It will be compared with its children to restore the heap
     * @param end - last index of array
     */
    public void siftDown(int [] tab, int start, int end){
        int root=start;//new variable to be changed in loop
        int child=2*root+1;
        while(child<=end){//while left child exists
            int swap=root;//default swap index variable
            if(tab[swap]<tab[child]){
                swap=child;//left child swap index
            }
            if(child+1<=end && tab[swap]<tab[child+1]){
                swap=child+1;//right child swap index
            }
            if(swap==root){return;}//quits if children didnt change swap
            else{swap(tab,root,swap);}
            root=swap;//assigning current root to the swapped index, anaylizing further down swapped branch
        }
    }

    /**
     * Method creates an aka binary tree with the biggest element at the root index - 0, starting from leaves up to index 0.
     * @param tab - array of integers
     * @param end - last index of array
     */
    public void heapify (int []tab, int end){
        int last=end;
        int parent=(last-1)/2;//parent
        while(parent>=0){//stop if last node is at root index 0
            int child = last;//last child at last index
            if(tab[parent]<tab[child]){//comparing last child with parent
                swap(tab, parent, child);
                siftDown(tab,child, end);//restoring heap structure if child changed
            }
            --last;//iterating to child with smaller index
        }
    }
    public void swap(int [] tab, int smaller, int bigger){
        int temp = tab[smaller];
        tab[smaller]=tab[bigger];
        tab[bigger]=temp;
    }
    public static void main(String[] args)
    {
        HeapSort test = new HeapSort();
        int [] tab ={8,3,12,15,9,7,6,4,1};
        System.out.println(Arrays.toString(tab));
        test.heapSort(tab,0,(tab.length-1));
        System.out.println(Arrays.toString(tab));
    }
}
