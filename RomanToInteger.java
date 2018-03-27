/*
Given a roman numeral, convert it to an integer.
Input is guaranteed to be within the range from 1 to 3999.

*/

class RomanToInteger {
    
    public static int getValue(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;   
        }
    }
    public static int romanToInt(String s) {
        int sum = 0;
        int prev = 0;
        
        for(int i = s.length()-1; i >= 0; i--){
            
            int n = getValue(s.charAt(i));
            if(n >= prev) 
                sum = sum + n;
            else
                sum = sum - n;
            prev = n;
        }
        return sum;
        
    }   

    public static void main(String[] args){

        String x = "DCXXI";
        int value = 621;
        int answer = romanToInt(x);
        String result = answer == value ? "Passed" : "Failed";
        System.out.println(result);
        
    }
}