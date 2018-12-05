package self.mik.interviewbit.microsoft;

public class LeetCodeEasyProblems {

    //151. Reverse Words in a String (Medium)
   public String reverseString() {

        String s = "The   sky   is  blue";
        String[] parseStr = s.trim().split("\\s+");
        s = "";
        int i = parseStr.length - 1;
        while (i >= 0) {
            s += parseStr[i--] + " ";
        }
        return s.trim();
    }
}
