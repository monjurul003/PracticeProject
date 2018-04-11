package self.mik.interviewbit.microsoft;

import java.util.Arrays;

public class MajorityElement {
    public int findMajorElement(int[] arr) {
        int len = arr.length;
        if (len == 2) {
            if (arr[0] == arr[1]){
                return arr[0];
            }else{
                return -999999;
            }
        } else if (len == 1) {
            return arr[0];
        } else {
            int firstElement = findMajorElement(Arrays.copyOfRange(arr, 0, len/2));
            int secondElement = findMajorElement(Arrays.copyOfRange(arr, len/2, len));
            if(firstElement == secondElement){
                return  firstElement;
            }else if (firstElement == -999999){
                return secondElement;
            }else {
                return firstElement;
            }
        }
    }

    public void testMajorityElement(){
        int[] arr = {2,1,2,3,4,4,4,3,3,3,3,4,4,4,2,3,2,2,2,2};
        System.out.println(findMajorElement(arr));
    }

}
