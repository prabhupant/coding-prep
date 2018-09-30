//video reference - https://www.youtube.com/watch?v=RVIh0snn4Qc
//code reference - https://www.geeksforgeeks.org/largest-rectangle-under-histogram/

import java.util.Stack;

public class RectArea{
    
    static int getMaxArea(int hist[], int n){

        Stack<Integer> s = new Stack<>();
        int max_area = 0;
        int i = 0;
        while(i < n){
            if(s.empty() || hist[s.peek()] <= hist[i]){
                s.push(i++);
            }
            else{
                int area = hist[s.pop()] * (s.empty() ? i : i - s.peek() - 1);
                if(area > max_area){
                    max_area = area;
                }
            }
        }
        while(s.empty() == false){
            int area = hist[s.pop()] * (s.empty() ? i : i - s.peek() - 1);
            if(area > max_area){
                max_area = area;
            }
        }
        return max_area;
    }

    public static void main(String[] args){
        int hist[] = {6, 2, 5, 4, 5, 1, 6};
        System.out.println("Maximum area is " + getMaxArea(hist, hist.length));
    }
}

