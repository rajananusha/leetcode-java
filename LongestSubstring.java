/*
Given a string, find the length of the longest substring without repeating characters.

Examples:

Given "abcabcbb", the answer is "abc", which the length is 3.

Given "bbbbb", the answer is "b", with the length of 1.

Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring
*/
import java.util.HashMap;

public class LongestSubstring {

    public static int findLongestSubstringLength (String str) {
    	HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
    	int i = 0;
    	int j = 0;
    	int maxLength = 0;
        if (str.length() < 2){
            return str.length();
        }
        
    	while(j<str.length()){
    		char cur = str.charAt(j);
            
    		if(hm.containsKey(cur)){
                i = Math.max(hm.get(cur) + 1, i);
    		}
            maxLength = Math.max(maxLength,(j-i) + 1);
    		hm.put(cur, j);
            j++;

    	}
    	
    	return maxLength;
    }


    public static void main(String[] args) {

    	// Testcase 1

        String str = "abcabcbb";
        String substring = "abc";
        int answer = findLongestSubstringLength(str);
        String result = answer == substring.length() ? "Passed" : "Failed";
        System.out.println(result);

        // Testcase 2

        str = "bbbbb";
        substring = "b";
        answer = findLongestSubstringLength(str);
        result = answer == substring.length() ? "Passed" : "Failed";
        System.out.println(result);

        // Testcase 3

        str = "pwwkew";
        substring = "wke";
        answer = findLongestSubstringLength(str);
        result = answer == substring.length() ? "Passed" : "Failed";
        System.out.println(result);
        

    }
}