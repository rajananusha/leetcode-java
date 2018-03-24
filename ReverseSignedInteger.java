/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
*/

public class ReverseSignedInteger {

    public static int reverseSignedInteger (int x) {
    	long answer = 0;
        while(x!=0){
            int temp = x%10;
            answer = answer*10 + temp;
            x = x/10;
            if(answer < Integer.MIN_VALUE || answer > Integer.MAX_VALUE){
            	return 0;
            }
        }
        return (int) answer;
    }


    public static void main(String[] args) {

    	// Testcase 1

        int x = 123;
        int reverse = 321;
        int answer = reverseSignedInteger(x);
        String result = answer == reverse ? "Passed" : "Failed";
        System.out.println(result);
        

        // Testcase 2

        x = 1534236469;
        reverse = 0;
        answer = reverseSignedInteger(x);
        result = answer == reverse ? "Passed" : "Failed";
        System.out.println(result);
    }
}