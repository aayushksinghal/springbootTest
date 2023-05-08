package scaler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindSmallestNumberProductOfDigitsIsN {

    static int[] primeAndTheirProductDigitTill10 = {9,8,7,6,5,4,3,2};

    public static void main(String[] args){
        int n = 1000;
        int m = findNumberDigitProductIsN(n);
        System.out.println( "Number is - " + m);
    }

    private static int findNumberDigitProductIsN(int num) {
        int s = num;
        List<Integer> numList = new ArrayList<>();
        int n = 0;
        for(int i : primeAndTheirProductDigitTill10){
            while( s % i  == 0){
                s = s / i;
                numList.add(i);
            }
        }

        System.out.println("Numbers are - "+ Arrays.toString(numList.toArray()));
        if( s == 1){
            for(int i=numList.size()-1;i>=0;i--){
                n = n*10 + numList.get(i);
            }
            return n;
        }
        else
            return -1;
    }
}
