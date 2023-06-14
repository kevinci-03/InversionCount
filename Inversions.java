 import java.util.Arrays;

public class Inversions {

    public static void main(String[] args) {

        int[] list1 = {6, 4, 3, 1};
        int[] list2 = {2, 3, 8, 6, 1};
        int[] list3 = {};
        int[] list4 = {42};
        int[] list5 = {5, 4, 3, 2, 1};
        int[] list6 = {1, 1, 1, 1, 1, 1, 1};
        int[] list7 = {3, 1, 4, 1, 5, 9, 2, 6, 5, 3}; 
        System.out.println(invCounter(list1));
        System.out.println(invCounter(list2));
        System.out.println(invCounter(list3));
        System.out.println(invCounter(list4));
        System.out.println(invCounter(list5));
        System.out.println(invCounter(list6));
        System.out.println(invCounter(list7));

    }

    // Input: int[] list that is at least of size 2 that includes only positive integers
    // Output: A non-negative integer with the number of inversions in the input list
    public static int invCounter(int[] array) {

        return mergeSort(array, 0, array.length - 1);

    }

    private static int mergeSort(int[] array, int left, int right) {
        int invCount = 0;
        if (left < right) {  // check to make sure there are at least two elements in the array to do calls
            int mid = (left + right) / 2; 
            invCount += mergeSort(array, left, mid);  // do recursive call on leftArray and count inversions
            invCount += mergeSort(array, mid + 1, right);  // do recursive call on rightArray and count inversions
            invCount += merge(array, left, mid, right);  // merge call to merge everything and count the inversions
        }

        return invCount;

    }

    private static int merge(int[] array, int left, int mid, int right) {

        int invCount = 0;
        int[] leftArray = Arrays.copyOfRange(array, left, mid + 1);
        int[] rightArray = Arrays.copyOfRange(array, mid + 1, right + 1);
        int i = 0;
        int j = 0; 
        int k = left;
        while (i < leftArray.length && j < rightArray.length) {  // while loop used instead of for to account for uneven lists
            if (leftArray[i] <= rightArray[j]) {  // check if there are inversions step here
                array[k] = leftArray[i];
                k++;
                i++;
            } 
            else {
                array[k] = rightArray[j];
                k++;
                j++;
                invCount += mid - (left + i) + 1;  // we count inversions here
            }
        }

        while (i < leftArray.length) {  // these two while loops are made to add anything that was't merged due to coming out of the last while loop with uneven indices
            array[k++] = leftArray[i++];
        }

        while (j < rightArray.length) {  // same as above
            array[k++] = rightArray[j++];
        }

        return invCount;

    }

}