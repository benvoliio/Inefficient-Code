package benvolio.inefficientcode.sort;

import org.apache.commons.math3.util.CombinatoricsUtils;

import benvolio.inefficientcode.sort.helper.ExtendedArrayInstCounter;

/**
 * Permutes the array until it is sorted.
 * Based on the C++ std function next_permutation.
 * 
 * @author Kardyne
 *
 */

public class PermutationSort extends InefficientSort {

	@Override
	protected void doSort(final ExtendedArrayInstCounter array) {
		while (nextPermutation(array));
	}


	/**
	 * Changes the array to its next permutation. Based on the C++ function of
	 * the same name.
	 * @param array the array to permute
	 * @return true if the array is sorted (side effect of the method)
	 */
	private boolean nextPermutation(ExtendedArrayInstCounter array) {
		int first = 0;
		int last = array.length();
		if (first == last) {
			return false;
		}
		int i = first;
		++i;
		if (i == last) {
			return false;
		}
		i = last;
		--i;

		while(true) {
			int ii = i--;
			if (array.get(i) < array.get(ii)) {
				int j = last;
				while (!(array.get(i) < array.get(--j)));
				array.swap(i, j);
				reverse(array, ii, last);
				return true;
			}
			if (i == first) {
				reverse(array, first, last);
				return false;
			}
		}
	}

	/**
	 * Reverses the array. Based on the C++ function of the same name.
	 * @param array the array to reverse
	 * @param first where to begin the reversal in the array
	 * @param last where to end the reversal in the array
	 */
	private void reverse(ExtendedArrayInstCounter array, int first, int last) {
		while ((first!=last)&&(first!=--last)) {
			array.swap(first, last);
			++first;
		}
	}

	@Override
	public String getWorstCasePerformance() {
		return "O(n!)";
	}

	@Override
	public String getBestCasePerformance() {
		return "O(1)";
	}

	@Override
	public String getAveragePerformance() {
		return "O(n!)";
	}

	@Override
	public String getWorstCaseSpaceComplexity() {
		return "O(n)";
	}

	@Override
	public long getAveragePerformance(final int size) {
		return CombinatoricsUtils.factorial(size);
	}

}
