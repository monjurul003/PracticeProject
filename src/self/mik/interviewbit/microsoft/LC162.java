package self.mik.interviewbit.microsoft;
/*
162. Find Peak Element
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
*/
public class LC162 {
    public int search(int[] nums, int begin, int end){
        if(begin<end){
            int mid = (begin+end)/2;
            if((mid-1) >= 0 && (mid+1) < nums.length){
                if(nums[mid-1] < nums[mid] && nums[mid] > nums[mid+1]){
                    return mid;
                }
            }
            int leftHalf = search(nums, begin, mid);
            int rightHalf = search(nums, mid+1, end);
            if(leftHalf == -1 && rightHalf != -1){
                return rightHalf;
            }else if(leftHalf != -1 && rightHalf == -1){
                return leftHalf;
            }else{
                return leftHalf;
            }
        }
        return -1;
    }
    public int findPeakElement(int[] nums) {
        int n = nums.length;
        if(n == 0){
            return -1;
        }else if(n ==1 ){
            return 0;
        }else if(n == 2){
            if(nums[0] == nums[1]){
                return -1;
            }else{
                return nums[0] > nums[1] ? 0: 1;
            }
        }

        int search = search(nums, 0, nums.length);
        if(search == -1){
            if(nums[0]>nums[1])
                search = 0;
            if(nums[n-1]>nums[n-2])
                search = n-1;

        }
        return search;

    }

}
