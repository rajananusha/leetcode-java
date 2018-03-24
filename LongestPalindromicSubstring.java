/*
Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example:

Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
 

Example:

Input: "cbbd"

Output: "bb"
*/
import java.util.HashMap;

public class LongestPalindromicSubstring {

    public static int extendPalindrome(String str, int left, int right){

        while(left >= 0 && right < str.length() && str.charAt(left)==str.charAt(right)){
            left--;
            right++;
        }

        return right - left - 1;

    } 

    public static String longestPalindrome (String str) {
        int n = str.length();
        int maxlen = 0;
        int start = 0;
        int end = 0;

        for(int i =0 ; i< n; i++){
            int len1 = extendPalindrome(str, i, i);
            int len2 = extendPalindrome(str, i, i + 1);
            int len = Math.max(len1, len2);

            if(len > maxlen){
                maxlen = len;
                start = i - ((len-1)/2);
                end = i + (len/2);
            }

        }
        return str.substring(start, end+1);

    }


    public static void main(String[] args) {

    	// Testcase 1

        String str = "babad";
        String answer = longestPalindrome(str);
        String result = answer.equals("aba") || answer.equals("bab") ? "Passed" : "Failed";
        System.out.println(result);

        // Testcase 2

        str = "cbbd";
        answer = longestPalindrome(str);
        result = answer.equals("bb") ? "Passed" : "Failed";
        System.out.println(result);

        // // Testcase 3

        // str = "pwwkew";
        // substring = "wke";
        // answer = longestPalindrome(str);
        // result = answer.equals(substring) ? "Passed" : "Failed";
        // System.out.println(result);
        

    }
}