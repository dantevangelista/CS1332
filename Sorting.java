import java.util.Comparator;
import java.util.List;
import java.util.LinkedList;
import java.util.PriorityQueue;

/**
 * Your implementation of various sorting algorithms.
 *
 * @author Dante Evangelista
 * @version 1.0
 * @userid devangelista8
 * @GTID 903573767
 *
 * Collaborators:
 *
 * Resources:
 */
public class Sorting {

    /**
     * Implement selection sort.
     *
     * It should be:
     * in-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n^2)
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void selectionSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("array or comparator cannot be null");
        }
        for (int i = arr.length - 1; i > 0; --i) {
            int maxIdx = i;
            for (int j = 0; j < i; ++j) {
                if (comparator.compare(arr[j], arr[maxIdx]) > 0) {
                    maxIdx = j;
                }
            }
            T temp = arr[i];
            arr[i] = arr[maxIdx];
            arr[maxIdx] = temp;
        }
    }

    /**
     * Implement insertion sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n)
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void insertionSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("array or comparator cannot be null");
        }
        for (int i = 1; i < arr.length; ++i) {
            int j = i;
            while (j > 0 && comparator.compare(arr[j], arr[j - 1]) < 0) {
                T temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                --j;
            }
        }
    }

    /**
     * Implement bubble sort.
     *
     * It should be:
     * in-place
     * stable
     * adaptive
     *
     * Have a worst case running time of:
     * O(n^2)
     *
     * And a best case running time of:
     * O(n)
     *
     * NOTE: See pdf for last swapped optimization for bubble sort. You
     * MUST implement bubble sort with this optimization
     *
     * @param <T>        data type to sort
     * @param arr        the array that must be sorted after the method runs
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("array or comparator cannot be null");
        }
        int stopIndex = arr.length - 1;
        while (stopIndex != 0) {
            int i = 0;
            int lastSwapped = 0;
            while (i < stopIndex) {
                if (comparator.compare(arr[i], arr[i + 1]) > 0) {
                    T temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    lastSwapped = i;
                }
                ++i;
            }
            stopIndex = lastSwapped;
        }
    }

    /**
     * Implement merge sort.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(n log n)
     *
     * And a best case running time of:
     * O(n log n)
     *
     * You can create more arrays to run merge sort, but at the end, everything
     * should be merged back into the original T[] which was passed in.
     *
     * When splitting the array, if there is an odd number of elements, put the
     * extra data on the right side.
     *
     * Hint: If two data are equal when merging, think about which subarray
     * you should pull from first
     *
     * @param <T>        data type to sort
     * @param arr        the array to be sorted
     * @param comparator the Comparator used to compare the data in arr
     * @throws java.lang.IllegalArgumentException if the array or comparator is
     *                                            null
     */
    public static <T> void mergeSort(T[] arr, Comparator<T> comparator) {
        if (arr == null || comparator == null) {
            throw new IllegalArgumentException("array or comparator cannot be null");
        }
        if (arr.length <= 1) {
            return;
        }
        int len = arr.length;
        int midIndex = len / 2;

        T[] left = (T[]) new Object[midIndex];
        for (int i = 0; i < midIndex; ++i) {
            left[i] = arr[i];
        }

        T[] right = (T[]) new Object[len - midIndex];
        int idx = 0;
        for (int j = midIndex; j < len; ++j) {
            right[idx] = arr[j];
            ++idx;
        }
        mergeSort(left, comparator);
        mergeSort(right, comparator);

        int k = 0;
        int m = 0;
        while (k < left.length && m < right.length) {
            if (comparator.compare(left[k], right[m]) <= 0) {
                arr[k + m] = left[k];
                ++k;
            } else {
                arr[k + m] = right[m];
                ++m;
            }
        }

        while (k < left.length) {
            arr[k + m] = left[k];
            ++k;
        }
        while (m < right.length) {
            arr[k + m] = right[m];
            ++m;
        }
    }

    /**
     * Implement LSD (least significant digit) radix sort.
     *
     * Make sure you code the algorithm as you have been taught it in class.
     * There are several versions of this algorithm and you may not get full
     * credit if you do not implement the one we have taught you!
     *
     * Remember you CANNOT convert the ints to strings at any point in your
     * code! Doing so may result in a 0 for the implementation.
     *
     * It should be:
     * out-of-place
     * stable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(kn)
     *
     * And a best case running time of:
     * O(kn)
     *
     * You are allowed to make an initial O(n) passthrough of the array to
     * determine the number of iterations you need.
     *
     * At no point should you find yourself needing a way to exponentiate a
     * number; any such method would be non-O(1). Think about how how you can
     * get each power of BASE naturally and efficiently as the algorithm
     * progresses through each digit.
     *
     * Refer to the PDF for more information on LSD Radix Sort.
     *
     * You may use ArrayList or LinkedList if you wish, but it may only be
     * used inside radix sort and any radix sort helpers. Do NOT use these
     * classes with other sorts. However, be sure the List implementation you
     * choose allows for stability while being as efficient as possible.
     *
     * Do NOT use anything from the Math class except Math.abs().
     *
     * @param arr the array to be sorted
     * @throws java.lang.IllegalArgumentException if the array is null
     */
    public static void lsdRadixSort(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("array cannot be null");
        }
        // buckets for +/- integers
        LinkedList<Integer>[] buckets = new LinkedList[19];
        for (int i = 0; i < buckets.length; ++i) {
            buckets[i] = new LinkedList<>();
        }
        // find max value and iterations
        int maxValue = arr[0];
        int iter = 1;
        for (int i = 0; i < arr.length; ++i) {
            if (arr[i] == Integer.MIN_VALUE) {
                maxValue = Integer.MAX_VALUE;
            } else if (Math.abs(arr[i]) > maxValue) {
                maxValue = Math.abs(arr[i]);
            }
        }
        while (maxValue >= 10) {
            maxValue = maxValue / 10;
            ++iter;
        }
        // put arr values in buckets
        // avoid divide by 0
        int div = 1;
        for (int j = 0; j < iter; ++j) {
            for (Integer value : arr) {
                buckets[((value / div) % 10) + 9].add(value);
            }
            int currIdx = 0;
            for (int n = 0; n < buckets.length; ++n) {
                while (!(buckets[n].size() == 0)) {
                    arr[currIdx] = buckets[n].remove();
                    ++currIdx;
                }
            }
            // divides exponentially
            div *= 10;
        }
    }

    /**
     * Implement heap sort.
     *
     * It should be:
     * out-of-place
     * unstable
     * not adaptive
     *
     * Have a worst case running time of:
     * O(n log n)
     *
     * And a best case running time of:
     * O(n log n)
     *
     * Use java.util.PriorityQueue as the heap. Note that in this
     * PriorityQueue implementation, elements are removed from smallest
     * element to largest element.
     *
     * Initialize the PriorityQueue using its build heap constructor (look at
     * the different constructors of java.util.PriorityQueue).
     *
     * Return an int array with a capacity equal to the size of the list. The
     * returned array should have the elements in the list in sorted order.
     *
     * @param data the data to sort
     * @return the array with length equal to the size of the input list that
     * holds the elements from the list is sorted order
     * @throws java.lang.IllegalArgumentException if the data is null
     */
    public static int[] heapSort(List<Integer> data) {
        if (data == null) {
            throw new IllegalArgumentException("data cannot be null");
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>(data);
        int[] sorted = new int[data.size()];
        for (int i = 0; i < data.size(); ++i) {
            sorted[i] = queue.remove();
        }
        return sorted;
    }
}