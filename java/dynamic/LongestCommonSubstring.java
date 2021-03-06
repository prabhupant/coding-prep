public class LongestCommonSubstring{

    public int LCS(char str1[], char str2[]){

        int T[][] = new int[str1.length + 1][str2.length + 1];
        int max = 0;

        for(int i = 1; i < str1.length; i++){
            for(int j = 1; j < str2.length; j++){
                if(str1[i] == str2[j]){
                    T[i][j] = T[i-1][j] + 1;
                    if(max < T[i][j]){
                        max = T[i][j];
                    }
                }
            }
        }
        return max;
    }
}

