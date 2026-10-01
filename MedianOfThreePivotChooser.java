package assign05;

import java.util.ArrayList;

/**
 * A PivotChooser that selects the median element out of the first, middle, and last elements being sorted
 * @param <E> the object type of the ArrayList being handled
 * @authors Camden Lyon & Ibrahim Alasady
 * @version 2026-10-01
 */
public class MedianOfThreePivotChooser <E extends Comparable<? super E>> implements PivotChooser<E>  {

	@Override
	public int getPivotIndex(ArrayList<E> list, int leftIndex, int rightIndex) {
		if (list == null || leftIndex < 0 || rightIndex >= list.size() || leftIndex > rightIndex) {
            throw new IllegalArgumentException("Invalid indecies");
        }
        if (rightIndex - leftIndex < 2) {
            return leftIndex;
        }

        int midIndex = leftIndex + (rightIndex - leftIndex) / 2;

        E a = list.get(leftIndex);
        E b = list.get(midIndex);
        E c = list.get(rightIndex);

        int cmpAB = a.compareTo(b);
        int cmpBC = b.compareTo(c);
        int cmpAC = a.compareTo(c);
        if ((cmpAB >= 0 && cmpAC <= 0) || (cmpAB <= 0 && cmpAC >= 0)) {
            return leftIndex;
        }
        if ((cmpAB <= 0 && cmpBC <= 0) || (cmpAB >= 0 && cmpBC >= 0)) {
            return midIndex;
        }
        return rightIndex;
	}

}
