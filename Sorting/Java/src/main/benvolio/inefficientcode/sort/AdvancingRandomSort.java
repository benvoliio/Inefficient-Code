package benvolio.inefficientcode.sort;

import java.util.Random;

import org.apache.commons.lang3.Validate;

import benvolio.inefficientcode.sort.helper.ArrayInstCounter;

/**
 * Implements a 'random' sort. For each element, it checks if the element is the
 * minimum of the array. If it is not, it takes another one at random in the
 * unsorted part of the array, and swaps them (it can be the same element). If
 * the element is the minimum, it gets to the next unsorted element.
 *
 * @author Kardyne
 *
 */
public class AdvancingRandomSort extends InefficientSort {

	@Override
	protected void doSort(final ArrayInstCounter array) {
		Validate.notNull(array);
		final Random rand = new Random();
		for (int i = 0; i < array.length(); i++) {
			while (!array.isMin(array.get(i), i, array.length())) {
				final int randIndex = i + rand.nextInt(array.length() - i);
				final int randValue = array.get(randIndex);
				array.set(randIndex, array.get(i));
				array.set(i, randValue);
			}
		}
	}
}
