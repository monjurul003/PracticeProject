package self.mik.self.mik.sorting;

import java.util.Arrays;

public class SortingAlgorithms {
    private int[] insertionSort(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        int key, j;
        for (int i = 1; i < arr.length; i++) {
            key = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private int[] bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            boolean isSorted = true;
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    isSorted = false;
                    swap(arr, j, j + 1);
                }
            }
            if (isSorted) {
                break;
            }
        }
        return arr;
    }

    private int[] selectionSort(int[] arr) {
        int minIndex = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
        return arr;
    }

    private int partitionPoint(int[] arr, int leftPointer, int rightPointer, int pivot) {
        int left = leftPointer - 1;
        int right = rightPointer;
        while (true) {
            while (arr[++left] < pivot && left < arr.length) ;
            while (--right >= 0 && arr[right] > pivot) ;
            if (left >= right) {
                break;
            }
            swap(arr, left, right);
        }
        swap(arr, left, rightPointer);
        return left;
    }

    private void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = arr[right];
        int partitionPoint = partitionPoint(arr, left, right, pivot);
        quickSort(arr, left, partitionPoint - 1);
        quickSort(arr, partitionPoint + 1, right);
    }

    private void margeSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int mid = (begin + end) / 2;
            margeSort(arr, begin, mid);
            margeSort(arr, mid + 1, end);
            marge(arr, begin, mid, end);
        }
    }

    private void marge(int[] arr, int begin, int mid, int end) {
        //Find the two sub arrays size for merging
        int firstArrSize = mid - begin + 1;
        int secondArrSize = end - mid;

        /*Create temporary array*/
        int[] leftArray = new int[firstArrSize];
        int[] rightArray = new int[secondArrSize];
        for (int i = 0; i < firstArrSize; i++) {
            leftArray[i] = arr[begin + i];
        }
        for (int i = 0; i < secondArrSize; i++) {
            rightArray[i] = arr[mid + i + 1];
        }
        int leftArrIndex = 0;
        int rightArrIndex = 0;
        int i = begin;
        while(leftArrIndex < firstArrSize && rightArrIndex < secondArrSize){
            if (leftArray[leftArrIndex] <= rightArray[rightArrIndex]) {
                arr[i++] = leftArray[leftArrIndex++];
            }else{
                arr[i++] = rightArray[rightArrIndex++];
            }

        }
        while(leftArrIndex<firstArrSize){
            arr[i++] = leftArray[leftArrIndex++];
        }
        while(rightArrIndex<secondArrSize){
            arr[i++] = rightArray[rightArrIndex++];
        }

    }

    private void printArrray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public void testSorting() {
        int[] arr = {9, 11, 2, 1, 8, 4, 5, 67, 78, 89, 33, 45, 24, 125, 678, 786};
        System.out.println("Selection sort result");
        printArrray(selectionSort(arr));

        int[] arr1 = {9, 11, 2, 1, 8, 4, 5, 67, 78, 89, 33, 45, 24, 125, 678, 786};
        System.out.println("Insertion sort result");
        printArrray(insertionSort(arr1));

        int[] arr2 = {9, 11, 2, 1, 8, 4, 5, 67, 78, 89, 33, 45, 24, 125, 678, 786};
        System.out.println("Bubble sort result");
        printArrray(bubbleSort(arr2));

        int[] arr3 = {9, 11, 2, 1, 8, 4, 5, 67, 78, 89, 33, 45, 24, 125, 678, 786};
        System.out.println("Quick sort result");
        quickSort(arr3, 0, arr.length - 1);
        printArrray(arr3);

        int[] arr4 = {9, 11, 2, 1, 8, 4, 5, 67, 78, 89, 33, 45, 24, 125, 678, 786};
        System.out.println("Marge sort result");
        margeSort(arr4, 0, arr.length-1);
        printArrray(arr4);

    }
}
