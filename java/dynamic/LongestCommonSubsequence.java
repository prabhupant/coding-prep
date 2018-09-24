public class LongestCommonSubsequence{

    public int LCS(char str1[], char str2[]){

        int T[][] = new int[str1.length + 1][str2.length + 1];
        int max = 0;
        for(int i = 1; i < str1.length; i++){
            for(int j = 1; j < str2.length; j++){
                if(str1[i-1] == str2[j-1]){
                    T[i][i] = T[i-1][j-1] + 1;
                }
                else{
                    T[i][j] = Math.max(T[i][j-1], T[i-1][j-1]);
                }
            }
        }
        return T[str1.length-1][str2.length-1];
    }

    public static void main(String args[]){
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        String str1 = "abcdaf";
        String str2 = "acbcf";

        int result = lcs.LCS(str1.toCharArray(), str2.toCharArray());
        System.out.println(result);
    }
}

