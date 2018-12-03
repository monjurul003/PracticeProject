package self.mik.interviewbit.microsoft;

public class EditDist {
    private int getEditDistance(String word1, String word2){
        int m = word1.length();
        int n = word2.length();
        int[][] d = new int[m+1][n+1];
        for (int i = 0; i < m+1 ; i++) {
            d[i][0] = i;
        }
        for (int i = 0; i < n+1 ; i++) {
            d[0][i] = i;
        }
        for (int i = 1; i < m+1; i++) {
            for (int j = 1; j < n+1; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    d[i][j] = 1 + Math.min(d[i-1][j], Math.min(d[i][j-1], d[i-1][j-1]-1));
                }else{
                    d[i][j] = 1 + Math.min(d[i-1][j], Math.min(d[i][j-1], d[i-1][j-1]));
                }
            }
        }
        return d[m][n];
    }
    public void testEditDistance(){
        System.out.println(getEditDistance("HORSE", "ROS"));
    }
}
