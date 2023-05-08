package leetCode;

import java.util.List;

class Solution {
    public static int ladderLength(String beginWord, String endWord, String[] words) {

        int length = words.length;
        int i =0;
        while( wordDiff(beginWord, words[i]) <= 1 && i < length){
           i++;
        }
        int j=length-1;
        if(!endWord.equals(words[j]))
            return 0;
        while( wordDiff(endWord, words[j]) <= 1 && j> 0){
            j--;
        }
        return j-i+3;
    }

    public static int wordDiff(String word1, String word2){
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int diff = 0;
        for(int i=0; i< word1.length() && i < word2.length(); i++){
            if(w1[i] != w2[i])
                diff++;
        }
        return diff;
    }

    public static void main(String [] args){
        String[] words = {"a","b","c"};
        System.out.println(ladderLength("a", "c", words));
    }
}
