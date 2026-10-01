package assign05;

import java.util.ArrayList;

/**
 * A Sorter subclass that uses mergesort up until the provided threshold then uses insertion sort
 * @param <E> the object type that makes up ArrayList being sorted
 */
public class MergeSorter <E extends Comparable<? super E>> implements Sorter<E> {
	private int threshold;
	
	public MergeSorter (int threshold) {
		if (threshold < 1)
			throw new IllegalArgumentException("Threshold must be positive");
		this.threshold = threshold;
	}
	
	
	@Override
	public void sort(ArrayList<E> list) {
		if (list == null || list.size() <= 1) {
            return;
        }

        ArrayList<E> temp = new ArrayList<>(list.size());
        for (int i = 0; i < list.size(); i++) {
            temp.add(null);
        }

        mergeSort(list, temp, 0, list.size() - 1);
	}
	
	/**
	 * A private recursive method that mergesorts the input list
	 * @param list, the ArrayList to sort
	 * @param temp, the ArrayList
	 * @param first
	 * @param last
	 */
	private void mergeSort(ArrayList<E> list, ArrayList<E> temp, int first, int last) {
        int length = last - first + 1;
        if (length <= this.threshold) {
            insertionSort(list, first, last);
            return;
        }
        int mid = first + (last - first) / 2;
        mergeSort(list, temp, first, mid);
        mergeSort(list, temp, mid + 1, last);
        if (list.get(mid).compareTo(list.get(mid + 1)) <= 0) {
            return;
        }
        merge(list, temp, first, mid, last);
    }
	
	/**
	 * A private helper method that merges
	 * @param list
	 * @param temp
	 * @param first
	 * @param mid
	 * @param last
	 */
	private void merge(ArrayList<E> list, ArrayList<E> temp, int first, int mid, int last) {
        int left = first;
        int right = mid + 1;
        int current = first;
        while (left <= mid && right <= last) {
            if (list.get(left).compareTo(list.get(right)) <= 0) {
                temp.set(current++, list.get(left++));
            } else {
                temp.set(current++, list.get(right++));
            }
        }
        while (left <= mid) {
            temp.set(current++, list.get(left++));
        }
        while (right <= last) {
            temp.set(current++, list.get(right++));
        }
        for (int i = first; i <= last; i++) {
            list.set(i, temp.get(i));
        }
    }

	/**
	 * private helper method to insertion sort a list
	 * @param list, the list to insertion sort
	 * @param first, The start index of the section to insertion sort
	 * @param last, The last index of the section to insertion sort
	 */
	private void insertionSort(ArrayList<E> list, int first, int last) {
		for (int i = first + 1; i <= last; i++) {
            E current = list.get(i);
            int j = i - 1;
            while (j >= first && list.get(j).compareTo(current) > 0) {
                list.set(j + 1, list.get(j));
                j--;
            }
            list.set(j + 1, current);
        }
    }

}
