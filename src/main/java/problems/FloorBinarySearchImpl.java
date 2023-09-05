package problems;

import util.Util;

public class FloorBinarySearchImpl implements Floor {

	@Override
	public Integer floor(Integer[] array, Integer x) {

		if (array.length == 0) {return -1;}
		
		sort(array, 0, array.length);
		int idx = 0;

        if (binarySearch(array, x, 0, array.length - 1) == -1) {
            binarySearch(array, x - 1, 0, array.length - 1);
        } else {
            idx = binarySearch(array, x, 0, array.length - 1);
        }

        return array[idx];
	}

	private Integer binarySearch (Integer[] array, Integer x, int left, int right) {

        int middle = left + (right - left) / 2;

        if (right < left) {return -1;}

        if (array[middle] == x) {return middle;}

        else if (array[middle] < x) {
            return binarySearch(array, x, left, middle - 1);
        } else {
            return binarySearch(array, x, middle + 1, right); }

    }

	private void sort(Integer[] array, int left, int right) {
		
		if (array.length > 1 && left < right) {
			int index_pivot = partition(array, left, right);
			sort(array, left, index_pivot - 1);
			sort(array, index_pivot + 1, right);
		}
	}
	private int partition(Integer[] array, int leftIndex, int rightIndex) {

		Integer pivot = array[leftIndex];
		int i = leftIndex;

		for (int j = i + 1; j <= rightIndex; j++) {
			if (array[j].compareTo(pivot) <= 0) {
				i++;
				Util.swap(array, i, j);
			}
		}
		Util.swap(array, leftIndex, i);
		return i;

	}

}
