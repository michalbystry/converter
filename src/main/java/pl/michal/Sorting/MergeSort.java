package pl.michal.Sorting;


import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;


/**
 * Created by Michał on 2015-02-19.
 */
public class MergeSort extends RecursiveAction {

    private final int[] tab;
    private final int startIndex;
    private final int endIndex;

    public MergeSort(int[] array, int startIndex, int endIndex) {
        this.tab = array;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int[] getTab() {
        return tab;
    }

    public static void main(String[] args) {

        TimeCalculation time = new TimeCalculation();
        TimeCalculation time2 = new TimeCalculation();

        for (int i = 0; i <= 5; i++) {
            int[] array = createArray(1000000, 1000000);
            int[] array2 = Arrays.copyOf(array, array.length);

            MergeSort sorting = new MergeSort(array, 0, array.length - 1);
            MergeSort sorting2 = new MergeSort(array2, 0, array.length - 1);

            //normal sorting
            time.setStart();
            sorting.mergeSort(array);
            time.setFinish();

            //sorting concurrently
            ForkJoinPool pool = new ForkJoinPool(Runtime.getRuntime().availableProcessors());
            time2.setStart();
            pool.invoke(sorting2);
            time2.setFinish();
        }

        System.out.print("Normal sorting: ");
        time.printAverageTime();
        System.out.print("Concurrent sorting: ");
        time2.printAverageTime();
    }

    @Override
    protected void compute() {
        int mid = startIndex + (endIndex - startIndex) / 2;

        if (endIndex - startIndex > 1) {
            //divide problem into smaller ones

            MergeSort leftSort = new MergeSort(tab, startIndex, mid);
            leftSort.fork();
            MergeSort rightSort = new MergeSort(tab, mid + 1, endIndex);

            rightSort.compute();
//            invokeAll(leftSort,rightSort); //alternative
            leftSort.join();
//            rightSort.join(); //alternative
            mergingConcurrently(this.tab, this.startIndex, this.endIndex);
        } else {
            //solve simple problem
            mergingConcurrently(this.tab, this.startIndex, this.endIndex);

        }
    }

    /** Merging wit concurency. Divides input array in two.
     * @param tab - input array
     * @param startIndex
     * @param endIndex
     */
    public void mergingConcurrently( int [] tab, int startIndex, int endIndex) {

//checking input parameters - Marcin czy takie rowziazanie jest ok?
        if (tab == null || startIndex<0 || endIndex<0){ //checking for incorrect inputs
            return;
        }
        int mid = startIndex + (endIndex - startIndex) / 2;
            int[] left = Arrays.copyOfRange(tab, startIndex, mid + 1); //create left tab (mid exclusive)
            int[] right = Arrays.copyOfRange(tab, mid + 1, endIndex + 1);//create right tab (mid inclusive)

            int j = 0;
            int i = 0;
            int k = startIndex;

            while (i < left.length && j < right.length) {//index
                if (left[i] < right[j]) {
                    tab[k] = left[i];
                    i++;
                } else {
                    tab[k] = right[j];
                    j++;
                }
                k++;
            }
            while (i < left.length) {
                tab[k] = left[i];
                k++;
                i++;
            }
            while (j < right.length) {
                tab[k] = right[j];
                k++;
                j++;
            }
        }

    /** Merging without concurency. Divides input array in two.
     * @param tab - input array
     * @param left - left array
     * @param right - right array
     */
    public void merging(int[] tab, int[] left, int[] right) {
        int mid = tab.length / 2;
        int j = 0;
        int i = 0;
        int k = 0;
        int lengthRight = tab.length - mid;

        while (i < mid && j < lengthRight) {
            if (left[i] < right[j]) {
                tab[k] = left[i];
                i++;
            } else {
                tab[k] = right[j];
                j++;
            }
            k++;
        }
        while (i < mid) {
            tab[k] = left[i];
            k++;
            i++;
        }
        while (j < lengthRight) {
            tab[k] = right[j];
            k++;
            j++;
        }
    }

    public void mergeSort(int[] tab) {

        if (tab.length < 2) { //condition to return from recursion and end method
            return;
        }
        int mid = tab.length / 2;
        int lengthRight = tab.length - mid;
        int[] left = new int[mid];
        int[] right = new int[lengthRight];

        for (int i = 0; i < mid; i++) {
            left[i] = tab[i];
        }
        for (int j = 0, i = mid; j < lengthRight && i < tab.length; j++, i++) {
            right[j] = tab[i];
        }

        mergeSort(left);
        mergeSort(right);
        merging(tab, left, right);
    }

    /** Creates array of random int within the numberPool of numbers
     * @param elements size of array
     * @param numberPool pool number of random elements in array
     * @return array with random int
     */
    public static int[] createArray(int elements, int numberPool) {
        if(elements<=0) throw new IllegalArgumentException("Incorrect input parameter");

        Random random = new Random();
        int[] tab = new int[elements];
        for (int i = 0; i < elements; i++) {
            tab[i] = random.nextInt(numberPool) + 1;
        }
        return tab;
    }
}


