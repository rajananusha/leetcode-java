/*
Determine whether an integer is a palindrome. Do this without extra space.

click to show spoilers.

Some hints:
Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.
*/

class PalindromeInteger {
    public static boolean isPalindrome(int x) {
        int rev = 0;
        if(x >= 0 && x < 10){
            return true;
        }

        if(x < 0 || (x%10 == 0)){
            return false;
        }
        while(x>rev){
            rev = (rev*10) + (x%10);
            x = x / 10;
        }
        return (x==rev || x==rev/10);
        
    }
    public static void main(String[] args) {

    	// Testcase 1

        int x = 1221;
        boolean answer = isPalindrome(x);
        String result = answer == true ? "Passed" : "Failed";
        System.out.println(result);
        

        // Testcase 2

        x = -1221;
        answer = isPalindrome(x);
        result = answer == false ? "Passed" : "Failed";
        System.out.println(result);

        // Testcase 3

        x = 10;
        answer = isPalindrome(x);
        result = answer == false ? "Passed" : "Failed";
        System.out.println(result);
    }
}