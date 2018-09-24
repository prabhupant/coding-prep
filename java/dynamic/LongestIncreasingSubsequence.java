public class LongestIncreasingSubsequence{

    public int LIS(int arr[]){

        int T[] = new int[arr.length];
        int result[] = new int[arr.length];
        
        for(int i =0; i < arr.length; i++){
            T[i] = 1;
            result[i] = i;
        }

        for(int i = 1; i < arr.length; i++){
            for(int j = 0; j < i; j++){
                if(arr[i] > arr[j]){
                    T[i] = Math.max(T[i], T[j]+1);
                    result[i] = j;
                }
            }
        }

        //find the index of max number in T
        int maxIndex = 0;
        for(int i = 0: i < T.length; i++){
            if(T[i] > T[maxIndex]){
                maxIndex = i;
            }
        }

        //print the actual palindromic sequence
        int t = maxIndex;
        int newT = maxIndex;
        do{
            t = newT;
            System.out.print(arr[t] + " ");
            newT = result[t];
        }while(t != newT);
        System.out.println();

        return T[maxIndex];
    }
}

