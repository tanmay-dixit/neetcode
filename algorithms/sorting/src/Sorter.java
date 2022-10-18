import java.util.Arrays;

public class Sorter {

    public static void main(String[] args) {
        int[] array = {4, 2, 6, 5, 1, 3};
        System.out.println("Array before sort: " + Arrays.toString(array));
        insertionSort(array);
    }

    public static void bubbleSort(int[] array) {


        for (int i = array.length - 1; i > 0; i--) {

            for (int j = 0; j < i; j++) {

                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                    System.out.println("\tSwapped " + array[j + 1] + " & " + array[j] + " : " + Arrays.toString(array));
                }

            }

            System.out.println("Array after iteration: " + Arrays.toString(array));
        }

    }

    public static void selectionSort(int[] array) {

        for (int i = 0; i < array.length - 1; i++) {

            int minIndex = i;

            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }

            if (i != minIndex) {
                int temp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = temp;
            }

            System.out.println("Array after iteration: " + Arrays.toString(array));

        }

    }

    public static void insertionSort(int[] array) {

        for (int i = 1; i < array.length; i++) {

            for (int j = i; j > 0; j--) {
                System.out.println("\t Checking " + array[j - 1] + " & " + array[j]);
                if (array[j] < array[j - 1]) {
                    System.out.println("\t \t ->  Swapping " + array[j - 1] + " & " + array[j]);
                    int temp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = temp;
                }
            }
            System.out.println("Array after iteration: " + Arrays.toString(array));

        }

    }

    public static void mergeSort(int[] array) {

    }

    public static void merge(int[] array1, int[] array2) {
        int[] combined = new int[array1.length + array2.length];

        for (int i = 0, j = 0, index = 0; i < array1.length && j < array2.length; ) {
            if (array1[i] < array2[j]) {
                combined[index] = array1[i];
                i++;
            } else if (array2[j] < array1[i]) {
                combined[index] = array2[j];
                j++;
            } else {
                combined[index] = array1[i];
                i++;
                index++;
                combined[index] = array2[j];
                j++;
            }
            index++;
        }
    }

}
