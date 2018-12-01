package self.mik.interviewbit.microsoft;

/*  Easy
28. Implement strStr().

Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

Example 1:

Input: haystack = "hello", needle = "ll"
Output: 2

Example 2:

Input: haystack = "aaaaa", needle = "bba"
Output: -1

Clarification:

What should we return when needle is an empty string? This is a great question to ask during an interview.

For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf()
* */
public class LeetCodeProblem28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        for (int i = 0; i < haystack.length(); i++) {
            int k = i;
            int j = 0;
            while (j < needle.length() && k < haystack.length() && haystack.charAt(k) == needle.charAt(j)) {
                j++;
                k++;
            }
            if (j == needle.length()) {
                return i;
            }
        }
        return -1;
    }

    public void teststrStr() {
        String h1 = "hello";
        String n1 = "ll";
        System.out.println("Haystack-- " + h1 + " ,Needle--\'" + n1 +"\' "+strStr(h1,n1));
        String h2 = "hello";
        String n2 = "";
        System.out.println("Haystack-- " + h2 + " ,Needle--\'" + n2 +"\' "+strStr(h2,n2));
        String h3 = "missipi";
        String n3 = "a";
        System.out.println("Haystack-- " + h3 + " ,Needle--\'" + n3 +"\' "+strStr(h3,n3));
        String h4 = "aaaa";
        String n4 = "aaaaaa";
        System.out.println("Haystack-- " + h4 + " ,Needle--\'" + n4 +"\' "+strStr(h4,n4));
        String h5 = "abbaba";
        String n5 = "cda";
        System.out.println("Haystack-- " + h5 + " ,Needle-- \'" + n5 +"\' "+strStr(h5,n5));

    }
}
