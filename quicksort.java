package assign05;

import java.util.ArrayList;


public class QuickSorter<E extends Comparable<? super E>> implements sorter<E> {
    private PivotChooser<E> chooser;

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
    private void quicksort(ArrayList<E> list, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotIndex = partition(list, left, right);

        quicksort(list, left, pivotIndex - 1);
        quicksort(list, pivotIndex + 1, right);
        }

        private int partition(ArrayList<E> list, int left, int right) {
        int chosenPivotIdx  = chooser.getPivotIndex(list, left, right);
        swap(list, chosenPivotIdx, right);

        E pivotValue = list.get(right);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            if (list.get(i).compareTo(pivotValue) < = 0) {
                swap(list, i, storeIndex);
                storeIndex++;
            }
        }
        swap(list, storeIndex, right);
        return storeIndex;
    }

    private void swap(ArrayList<E> list, int i, int j) {
        E temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
}
