package assign05;

import java.util.ArrayList;

/**
 * A PivotChooser that always selects the first element of the range being sorted
 * @param <E> the object type of the ArrayList being handled
 * @authors Camden Lyon & Ibrahim Alasady
 * @version 2026-10-01
 */
public class FirstPivotChooser <E extends Comparable<? super E>> implements PivotChooser<E> {

	@Override
	public int getPivotIndex(ArrayList<E> list, int leftIndex, int rightIndex) {
		return leftIndex;
	}

}
