/*
Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
*/

class RegexMatch {
    public static boolean isMatch(String str, String regex) {
    	if (str.length() == 0 || regex.length() == 0) return false;
    	int i = 0, j = 0;
    	char prev = regex.charAt(j);


    	while(i<str.length() && j<regex.length()){

    		if(str.charAt(i) == regex.charAt(j) || regex.charAt(j) == '.'){
    			prev = regex.charAt(j);
    			i++;
    			j++;
    		} else if(regex.charAt(j) == '*'){
    			while(str.charAt(i) == prev || prev == '.'){
    				i++;
    				if(i==str.length()){
    					j++;
    					break;
    				}
    			}
    		} else {
    			return false;
    		}
    	}
    	if(i<str.length() || j<regex.length()) {

    		System.out.println(i);
    		System.out.println(j);
    		return false;
    	}
    	return true;

    }
    public static void main(String[] args) {

    	// Testcase 1
        boolean answer = isMatch("aa", "a");
        String result = answer == false ? "Passed" : "Failed";
        System.out.println(result);
        

        // Testcase 2

        answer = isMatch("aaaaa", "a*");
        result = answer == true ? "Passed" : "Failed";
        System.out.println(result);

        // Testcase 3

        answer = isMatch("ab", ".*c");
        result = answer == false ? "Passed" : "Failed";
        System.out.println(result);
    }
}