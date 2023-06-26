import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

/**
 * Some more tests.
 *
 * @author Dante
 * @version 1.0
 */
public class SortingTests {

    private static final int ITERATIONS = 300;

    private static final int TIMEOUT = ITERATIONS * 3;

    private TeachingAssistant[] tas;
    private TeachingAssistant[] tasByName;
    private ComparatorPlus<TeachingAssistant> comp;

    private ComparatorPlus<Integer> intComp;

    @Before
    public void setUp() {
        /*
            Unsorted Names:
                index 0: Alex
                index 1: Ivan
                index 2: Miguel
                index 3: Paige
                index 4: Brooke
                index 5: Sanjana
                index 6: Yotam
                index 7: Nick
                index 8: Reece
                index 9: Destini
         */

        /*
            Sorted Names:
                index 0: Alex
                index 1: Brooke
                index 2: Destini
                index 3: Ivan
                index 4: Miguel
                index 5: Nick
                index 6: Paige
                index 7: Reece
                index 8: Sanjana
                index 9: Yotam
         */

        tas = new TeachingAssistant[10];
        tas[0] = new TeachingAssistant("Alex");
        tas[1] = new TeachingAssistant("Ivan");
        tas[2] = new TeachingAssistant("Miguel");
        tas[3] = new TeachingAssistant("Paige");
        tas[4] = new TeachingAssistant("Brooke");
        tas[5] = new TeachingAssistant("Sanjana");
        tas[6] = new TeachingAssistant("Yotam");
        tas[7] = new TeachingAssistant("Nick");
        tas[8] = new TeachingAssistant("Reece");
        tas[9] = new TeachingAssistant("Destini");
        tasByName = new TeachingAssistant[10];
        tasByName[0] = tas[0];
        tasByName[1] = tas[4];
        tasByName[2] = tas[9];
        tasByName[3] = tas[1];
        tasByName[4] = tas[2];
        tasByName[5] = tas[7];
        tasByName[6] = tas[3];
        tasByName[7] = tas[8];
        tasByName[8] = tas[5];
        tasByName[9] = tas[6];

        comp = TeachingAssistant.getNameComparator();
        intComp = MyInteger.getNumComparator();
    }

    @Test(timeout = TIMEOUT)
    public void testSelectionSort() {
        Sorting.selectionSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 45 && comp.getCount() != 0);



        Integer[] arr = new Integer[10];
        Integer[] sortedArr = new Integer[10];
        ComparatorPlus<Integer> intComp;
        intComp = MyInteger.getNumComparator();

        // list with repeat
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (int) Math.pow(-1, i) * 10;
            if (i == 3 || i == 6) {
                arr[i] = arr[i - 1];
            }
        }
        sortedArr = arr;
        Arrays.sort(sortedArr);
        Sorting.mergeSort(arr, intComp);
        assertArrayEquals(sortedArr, arr);



    }

    @Test(timeout = TIMEOUT)
    public void testInsertionSort() {
        Sorting.insertionSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 24 && comp.getCount() != 0);



        Integer[] arr = new Integer[10];
        Integer[] sortedArr = new Integer[10];
        ComparatorPlus<Integer> intComp;
        intComp = MyInteger.getNumComparator();

        // list with repeat
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (int) Math.pow(-1, i) * 10;
            if (i == 3 || i == 6) {
                arr[i] = arr[i - 1];
            }
        }
        sortedArr = arr;
        Arrays.sort(sortedArr);
        Sorting.mergeSort(arr, intComp);
        assertArrayEquals(sortedArr, arr);

    }

    @Test(timeout = TIMEOUT)
    public void testBubbleSort() {
        Sorting.bubbleSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 44 && comp.getCount() != 0);


        Integer[] arr = new Integer[10];
        Integer[] sortedArr = new Integer[10];
        ComparatorPlus<Integer> intComp;
        intComp = MyInteger.getNumComparator();

        // list with repeat
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (int) Math.pow(-1, i) * 10;
            if (i == 3 || i == 6) {
                arr[i] = arr[i - 1];
            }
        }
        sortedArr = arr;
        Arrays.sort(sortedArr);
        Sorting.mergeSort(arr, intComp);
        assertArrayEquals(sortedArr, arr);

    }


    @Test(timeout = TIMEOUT)
    public void testMergeSort() {
        Sorting.mergeSort(tas, comp);
        assertArrayEquals(tasByName, tas);
        assertTrue("Number of comparisons: " + comp.getCount(),
                comp.getCount() <= 21 && comp.getCount() != 0);


        Integer[] arr = new Integer[10];
        Integer[] sortedArr = new Integer[10];
        ComparatorPlus<Integer> intComp;
        intComp = MyInteger.getNumComparator();

        // list with repeat
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = (int) Math.pow(-1, i) * 10;
            if (i == 3 || i == 6) {
                arr[i] = arr[i - 1];
            }
        }
        sortedArr = arr;
        Arrays.sort(sortedArr);
        Sorting.mergeSort(arr, intComp);
        assertArrayEquals(sortedArr, arr);

    }


    @Test(timeout = TIMEOUT)
    public void testLsdRadixSort() {
        int[] unsortedArray = new int[] {54, 28, 58, 84, 20, 122, -85, 3};
        int[] sortedArray = new int[] {-85, 3, 20, 28, 54, 58, 84, 122};
        Sorting.lsdRadixSort(unsortedArray);
        assertArrayEquals(sortedArray, unsortedArray);

        // Integer.MIN_VALUE and Integer.MAX_VALUE test
        int[] unsorted = new int[] {Integer.MIN_VALUE, 28, Integer.MAX_VALUE, 84, 20, 122, -85, 3};
        int[] sorted = new int[] {Integer.MIN_VALUE, -85, 3, 20, 28, 84, 122, Integer.MAX_VALUE};
        Sorting.lsdRadixSort(unsorted);
        assertArrayEquals(sorted, unsorted);
    }


    @Test(timeout = TIMEOUT)
    public void testHeapSort() {
        int[] unsortedArray = new int[] {54, 28, 58, 84, 20, 122, -85, 3};
        List<Integer> unsortedList = new ArrayList<>();
        for (int i : unsortedArray) {
            unsortedList.add(i);
        }
        int[] sortedArray = new int[] {-85, 3, 20, 28, 54, 58, 84, 122};
        int[] actualArray = Sorting.heapSort(unsortedList);
        assertArrayEquals(sortedArray, actualArray);


        // already sorted array
        int[] preSortArr = new int[] {-85, -54, -28, 0, 3, 20, 84, 122};
        List<Integer> preSortList = new ArrayList<>();
        for (int i : preSortArr) {
            preSortList.add(i);
        }
        int[] sortedArr = new int[] {-85, -54, -28, 0, 3, 20, 84, 122};
        int[] actualArr = Sorting.heapSort(preSortList);
        assertArrayEquals(sortedArr, actualArr);
    }

    /**
     * Class for testing integer sorting
     */
    private static class MyInteger {
        private int num;

        /**
         * Gets num
         * @param num integer input
         */
        public MyInteger(int num) {
            this.num = num;
        }

        /**
         * Create a comparator that compares integers.
         *
         * @return comparator that compares integers
         */
        public static ComparatorPlus<Integer> getNumComparator() {
            return new ComparatorPlus<Integer>() {
                private int count = 0;
                @Override
                public int compare(Integer num1, Integer num2) {
                    ++count;
                    return num1 - num2;
                }
                /**
                 * Get the number of comparisons.
                 *
                 * @return number of comparisons
                 */
                public int getCount() {
                    return count;
                }
            };
        }
    }

    /**
     * Class for testing proper sorting.
     */
    private static class TeachingAssistant {
        private String name;

        /**
         * Create a teaching assistant.
         *
         * @param name name of TA
         */
        public TeachingAssistant(String name) {
            this.name = name;
        }

        /**
         * Get the name of the teaching assistant.
         *
         * @return name of teaching assistant
         */
        public String getName() {
            return name;
        }

        /**
         * Create a comparator that compares the names of the teaching
         * assistants.
         *
         * @return comparator that compares the names of the teaching assistants
         */
        public static ComparatorPlus<TeachingAssistant> getNameComparator() {
            return new ComparatorPlus<TeachingAssistant>() {
                @Override
                public int compare(TeachingAssistant ta1,
                                   TeachingAssistant ta2) {
                    incrementCount();
                    return ta1.getName().compareTo(ta2.getName());
                }
            };
        }

        @Override
        public String toString() {
            return "Name: " + name;
        }

        @Override
        public boolean equals(Object other) {
            if (other == null) {
                return false;
            }
            if (this == other) {
                return true;
            }
            return other instanceof TeachingAssistant
                    && ((TeachingAssistant) other).name.equals(this.name);
        }
    }

    /**
     * Inner class that allows counting how many comparisons were made.
     */
    private abstract static class ComparatorPlus<T> implements Comparator<T> {
        private int count;

        /**
         * Get the number of comparisons made.
         *
         * @return number of comparisons made
         */
        public int getCount() {
            return count;
        }

        /**
         * Increment the number of comparisons made by one. Call this method in
         * your compare() implementation.
         */
        public void incrementCount() {
            count++;
        }
    }
}
