package self.mik.algorithm;
/*
* the maximum subarray problem is the task of finding a contiguous subarray with the largest sum,
* within a given one-dimensional array A[1...n] of numbers.
* Formally, the task is to find indices and with, such that the sum is as large as possible.
 * */
public class MaxSumSubArray {

    private static int maxSumSubArrayIncludingNegative(int[] arr) {
        int max_so_far = arr[0];
        int max_ending_here = arr[0];
        int start = 0;
        int s = 0;
        int end = 0;
        for (int i = 1; i < arr.length; i++) {
            if (max_ending_here + arr[i] < arr[i]) {
                max_ending_here = arr[i];
                s = i;
            } else {
                max_ending_here += arr[i];
            }
            if (max_so_far <= max_ending_here) {

                max_so_far = max_ending_here;
                start = s;
                end = i;
            }
        }
        System.out.println("Start: " + start + " End: " + end + " Max Sum: " + max_so_far);
        return max_so_far;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{-4, -3, -2, -2, 3, 1, 0, 2, 3, -4, -2, -6, 3, 1, 2, 2};
        System.out.println(maxSumSubArrayIncludingNegative(arr));
    }
}
