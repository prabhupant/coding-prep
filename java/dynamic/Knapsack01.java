import java.util.HashMap;
import java.util.Map;

public class Knapsack01{

    public int bottomUpDP(int val[], int wt[], int w){

        int T[][] = new int[val.length][w+1];
        for(int i = 0; i < val.length; i++){
            for(int j = 0; j <= w; j++){
                if(i == 0 || j == 0){
                    T[i][j] = 0;
                    continue;
                }
                if(j < wt[i]){
                    T[i][j] = T[i-1][j];
                }
                else
                {
                    T[i][j] = Math.max(T[i-1][j], val[i-1] + T[i-1][j - wt[i]]);
                }
            }
        }
        return T[val.length-1][w];
    }

    public static void main(String args[]){
        Knapsack01 k = new Knapsack01();
        int val[] = {22, 20, 15, 30, 24, 54, 21, 32, 18, 25};
        int wt[] = {4, 2, 3, 5, 5, 6, 9, 7, 8, 10};
        int r = k.bottomUpDP(val, wt, 10);
        System.out.println(r);
    }
}

