package self.mik;

import self.mik.interviewbit.microsoft.*;
import self.mik.self.mik.sorting.SortingAlgorithms;


public class Main {

    public static void main(String[] args) {
        // write your code here
        MajorityElement obj = new MajorityElement();
        obj.testMajorityElement();
        /***********************************************/
        MaxSubMatrix obj2 = new MaxSubMatrix();
        obj2.testMaximumSubMatrix();
        /**********************************************/

        CountingIsland obj3 = new CountingIsland();
        obj3.testCountingIsland();
        /**********************************************/
        SortingAlgorithms obj4 = new SortingAlgorithms();
        obj4.testSorting();

        LeetCodeProblem28 probObj = new LeetCodeProblem28();
        probObj.teststrStr();

        EditDist eObj = new EditDist();
        eObj.testEditDistance();
    }
}
