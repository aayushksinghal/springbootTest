package scaler;

import java.util.HashMap;


// here assumption is there is no repeating element in array
public class Find2NumbersFromArrayWhoseSumIsN {

    public static void main(String args[]){
        int[] arr = {2,3,5,4,7,8,1,12,15,57,58,-12,-23,-34,16};
        int num = 24;

        find2NumsSumIsNum(arr,num);

    }

    private static void find2NumsSumIsNum(int[] arr, int num) {
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(num-arr[i])){
                System.out.println("Numbers are - " + arr[map.get(num-arr[i])]  + " , " + arr[i]);
            }
                map.put(arr[i],i);

        }

    }
}
