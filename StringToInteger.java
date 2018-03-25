/*
Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

 

Requirements for atoi:

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
*/

public class StringToInteger {

    public static int atoi (String x) {
        String num = x.trim();
        if(num.length() == 0){
            return 0;
        }
    	long val = 0;
        int i = 0;
        int sign = 1;
        if(num.charAt(i) == '+'){
            i++;

        } else if (num.charAt(i) == '-'){
            sign = -1;
            i++;
        }

        while(i < num.length()){
            int digit = Character.getNumericValue(num.charAt(i));
            if (digit < 0 || digit > 9){
                break;
            }
            val = (val * 10) + digit;
            if (val > Integer.MAX_VALUE){
                int max = sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                return max;
            }
            i++;
        }
        return (int)val * sign;
    }


    public static void main(String[] args) {

    	// Testcase 1

        String x = "          123";
        int value = 123;
        int answer = atoi(x);
        String result = answer == value ? "Passed" : "Failed";
        System.out.println(result);
        

        // Testcase 2

        x = "123";
        value = 123;
        answer = atoi(x);
        result = answer == value ? "Passed" : "Failed";
        System.out.println(result);

        // Testcase 3

        x = "     -123a45";
        value = -123;
        answer = atoi(x);
        result = answer == value ? "Passed" : "Failed";
        System.out.println(result);

        x = "-96463243500";
        value = -2147483648;
        answer = atoi(x);
        result = answer == value ? "Passed" : "Failed";
        System.out.println(result);


    }
}