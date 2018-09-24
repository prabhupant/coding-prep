public class CuttingRod{

    public int maxValue(int price_list[], int length){

        int T[][] = new int[length + 1][price_list.length];
        for(int i = 1; i <= price_list.length; i++){
            for(int j = 0; j <= length; j++){
                if(j>=i){
                    T[i][j] = Math.max(T[i-1][j], price_list[i] + T[i][j-1]);
                }
                else{
                    T[i][j] = T[i-1][j];
                }
            }
        }
        return T[length][price_list.length];
    }

    public static void main(String args[]){
        CuttingRod rod = new CuttingRod();
        int len = 5;
        int prices[] = {2, 5, 7, 8};
        int profit = rod.maxValue(prices, len);
        System.out.println(profit);
    }
}


