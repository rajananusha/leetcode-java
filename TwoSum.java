/*
Two sum

Problem Statement: Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
*/
import java.util.HashMap;
import java.util.Arrays;

public class TwoSum {
    public static int[] twoSumfunction(int[] numList, int sum) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int ans[] = {-1, -1};
        for(int i = 0; i < numList.length; i++){
            int complement = sum - numList[i];
            if(hm.containsKey(complement)){
                ans[0] = hm.get(complement);
                ans[1] =  i;
                break;
            }
            else{
                hm.put(numList[i], i);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] numList = {1, 2, 3, 4, 5};
        int target =6;
        int answer[] = twoSumfunction(numList,target);
        int expected[] = {1, 3}; 
        System.out.println(Arrays.equals(answer, expected));

    }
}