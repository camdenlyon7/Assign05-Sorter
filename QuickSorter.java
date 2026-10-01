package assign05;

import java.util.ArrayList;

/**
 * A Sorter subclass that uses quicksort with the specified PivotChooser
 * @param <E> the object type that makes up ArrayList being sorted
 * @authors Camden Lyon & Ibrahim Alasady
 * @version 2026-10-01
 */
public class QuickSorter<E extends Comparable<? super E>> implements Sorter<E> {
    private PivotChooser<E> chooser;

    /**
     * Constructor
     */
    public QuickSorter(PivotChooser<E> chooser) {
        this.chooser = chooser;
    }

    @Override
    public void sort(ArrayList<E> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        quicksort(list, 0, list.size() - 1);
        }

    /**
     * private recursive quicksort method called by sort
     * @param list, the ArrayList<E> to sort
     * @param left, index to start at    
     * @param right, index to stop at
     */
    private void quicksort(ArrayList<E> list, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(list, left, right);

        quicksort(list, left, pivotIndex - 1);
        quicksort(list, pivotIndex + 1, right);
    }

    /**
     * private helper method called by quicksort to partition the list
     * @param list, the ArrayList<E> to sort
     * @param left, index to start at    
     * @param right, index to stop at
     */
    private int partition(ArrayList<E> list, int left, int right) {
        int chosenPivotIdx  = chooser.getPivotIndex(list, left, right);
        swap(list, chosenPivotIdx, right);

        E pivotValue = list.get(right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (list.get(i).compareTo(pivotValue) <= 0) {
                swap(list, i, storeIndex);
                storeIndex++;
            }
        }
        swap(list, storeIndex, right);
        return storeIndex;
    }

    /**
     * private helper method to swap the values at to indecies
     * @param list, the ArrayList<E> to swap in
     * @param i, index to swap    
     * @param j, index to swap with
     */
    private void swap(ArrayList<E> list, int i, int j) {
        E temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
