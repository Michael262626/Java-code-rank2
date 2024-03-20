package TodayTask;

import java.util.Arrays;

public class Task {
    public static int[] elements(int[] arrays){
        int counterNum = 0;
        int occurNum = 0;
        for (int count = 0; count< arrays.length;count++){
            for(int counter = 0; counter< count;counter++){
                if(arrays[count]==arrays[counter]){
                    counterNum++;
                }
                if(arrays[count]>=occurNum){
                    occurNum = count;
                }
        }
     }
        return new int[]{counterNum, occurNum};
    }
    public static void main(String[] args) {
        int[] numbers = {1,2,2,3,4,2};
        System.out.println(Arrays.toString(elements(numbers)));
    }
}
