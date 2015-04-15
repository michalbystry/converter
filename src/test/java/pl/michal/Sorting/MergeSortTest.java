package pl.michal.Sorting;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeSortTest {


    @Test
    public void merging2elements () {
        int[] array = {5, 1};
        MergeSort sort = new MergeSort(array, 0, array.length - 1);
        sort.mergingConcurrently(sort.getTab(), 0, sort.getTab().length - 1);
        assertArrayEquals("sorting 2 element", new int[]{1, 5}, sort.getTab());
    }
    @Test
    public void mergingMultipleElements () {
        int [] array = {3,7,4,8};
        MergeSort sort = new MergeSort(array, 0, array.length-1);
        sort.mergingConcurrently(sort.getTab(), 0, sort.getTab().length - 1);
        assertArrayEquals("sorting more elements", new int[]{3,4,7,8}, array);
    }
    @Test
    public void mergingEmptyArray () {
        int[] array = {};
        try {
            MergeSort sort = new MergeSort(array, 0, array.length - 1);
            sort.mergingConcurrently(sort.getTab(), 0, sort.getTab().length - 1);
            assertTrue(true);
        } catch (RuntimeException e) {
            fail("Exception should not have been thrown");
        }
    }
    @Test
    public void createNegativeArray(){
            try{
                MergeSort.createArray(-1,1);
                MergeSort.createArray(1,-1);
                assertTrue(true);
        }
            catch (Exception e){
                fail ("Exception should not have been thrown");
            }
    }
}
//    @Test
//    public void mergingWithNull () {
//        int [] array = null;
//        try {
//            MergeSort sort = new MergeSort(array, 0, 2);
//            sort.merging(array, 0, 2);
//            assert (true);
//        }
//        catch (RuntimeException e) {
//            fail ("thrown NPE");
//        }
