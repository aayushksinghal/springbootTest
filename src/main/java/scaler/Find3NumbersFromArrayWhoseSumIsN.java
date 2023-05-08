package scaler;

import java.util.HashMap;

public class Find3NumbersFromArrayWhoseSumIsN {
    public static void main(String args[]){
        int[] arr = {2,3,5,4,7,8,1,12,15,57,58,-12,-23,-34,16};
        int num = 24;

        find3NumsSumIsNum(arr,num);

    }

    private static void find3NumsSumIsNum(int[] arr, int num) {
        HashMap<Integer,Integer> imap = new HashMap();
        for(int i=0;i<arr.length;i++){
            imap.put(arr[i],i);
            HashMap<Integer,Integer> jmap = (HashMap<Integer, Integer>) imap.clone();
            for(int j=i+1;j<arr.length;j++){
                if(jmap.containsKey(num-arr[i]-arr[j])){
                    System.out.println("Numbers are - " + arr[i]  + " , " + arr[j] + " , "+arr[jmap.get(num-arr[i]-arr[j])]);
                }
                jmap.put(arr[j],j);
            }

        }

    }
}
