/*
The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

P   A   H   N
A P L S I I G
Y   I   R
And then read line by line: "PAHNAPLSIIGYIR"
Write the code that will take a string and make this conversion given a number of rows:

string convert(string text, int nRows);
convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
*/
public class ZigZagString {

    public static String convertToZigZagString (String str, int nRows) {

    	if ( nRows == 1){
            return str;
        } 
        if (nRows == 0 || str == "") {
            return "";
        }
        
    	int row = 0;
    	boolean zig = false;
    	StringBuilder[] sb = new StringBuilder[nRows];
    	for (int i = 0; i < nRows; i++) sb[i] = new StringBuilder();

    	for(int i = 0; i < str.length(); i++){
    		if (row == 0 || row == nRows-1){
    			zig = !zig;
    		}
    		sb[row].append(str.charAt(i));
    		row = zig ? ++row : --row;
    		
    	}
    	for (int i=1; i< nRows; i++){
    		sb[0].append(sb[i]);
    	}
    	return sb[0].toString();
    	
    }


    public static void main(String[] args) {

    	// Testcase 1

        String str = "PAYPALISHIRING";
        String zigzag = "PAHNAPLSIIGYIR";
        String answer = convertToZigZagString(str, 3);
        String result = answer.equals(zigzag) ? "Passed" : "Failed";
        System.out.println(result);

        // Testcase 2

        str = "PAYPALISHIRING";
        zigzag = "PAYPALISHIRING";
        answer = convertToZigZagString(str, 1);
        result = answer.equals(zigzag) ? "Passed" : "Failed";
        System.out.println(result);
    }
}