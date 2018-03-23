/*
There are two sorted arrays nums1 and nums2 of size m and n respectively.

Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

Example 1:
nums1 = [1, 3]
nums2 = [2]

The median is 2.0
Example 2:
nums1 = [1, 2]
nums2 = [3, 4]


The median is (2 + 3)/2 = 2.5
*/

class TwoArrayMedian {

    public static double findMedianSortedArrays(int[] A, int[] B) {
    	int m = A.length;
        int n = B.length;
        if (m > n) {
            // Smaller array is always A of size m.
            int[] temp = A; 
            A = B; 
            B = temp;
            
            int tmp = m; 
            m = n; 
            n = tmp;
        }

        int iMin = 0; 
        int iMax = m; 
        int mid = (m + n + 1) / 2;
        while (iMin <= iMax) {
            int i = (iMin + iMax) / 2;
            int j = mid - i;

            if (i < iMax && A[i]< B[j-1]){
                iMin = iMin + 1; // i is too small
            }
            else if (i < iMin && A[i-1] > B[j]) {
                iMax = iMax - 1; // i is too big
            }
            else { // i is perfect
                int maxLeft = 0;
                if (i == 0) { maxLeft = B[j-1]; }
                else if (j == 0) { maxLeft = A[i-1]; }
                else { maxLeft = Math.max(A[i-1], B[j-1]); }
                if ( (m + n) % 2 == 1 ) { return maxLeft; }

                int minRight = 0;
                if (i == m) { minRight = B[j]; }
                else if (j == n) { minRight = A[i]; }
                else { minRight = Math.min(B[j], A[i]); }

                return (maxLeft + minRight) / 2.0;
            }
        }
        return 0.0;
    }

    public static void main(String[] args) {

    	// Testcase 1
        int[] nums1 = {1,3,5,7};
        int[] nums2 = {2,4,6};
        double answer = findMedianSortedArrays(nums1, nums2);
        String result = answer == 4 ? "Passed" : "Failed";
        System.out.println(result);

        // Testcase 2

        int[] nums3 = {1,3,5,7};
        int[] nums4 = {2,4};
        answer = findMedianSortedArrays(nums3, nums4);
        result = answer == 3.5 ? "Passed" : "Failed";
        System.out.println(result);

        // Testcase 3

        int[] nums5 = {1,3};
        int[] nums6 = {2};
        answer = findMedianSortedArrays(nums5, nums6);
        result = answer == 2 ? "Passed" : "Failed";
        System.out.println(result);
    }
}