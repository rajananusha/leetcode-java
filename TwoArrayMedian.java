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

	public static double findMedianSortedArrays(int[] A, int[] B){
		int[] smaller = null;
		int[] bigger = null;
		int m = 0;
		int n = 0;

		if(A.length <= B.length){
			m = A.length;
			smaller= A;
			n = B.length;
			bigger = B;
		}  else {
			m = B.length;
			smaller= B;
			n = A.length;
			bigger = A;
		}
		int left = 0;
		int right = m;

		int mid = (m + n + 1)/2;

		while(left<=right){
			int i = (left + right)/2;
			int j = mid - i; 

			if(i < right && smaller[i] < bigger[j-1]){
				// i is too small. We need to move right.
				left = i + 1;
			} else if(i > left && smaller[i-1] > bigger[j]){
				// i is too large. We need to move left.
				right = i - 1;
			} else {
				// i is just right.
				int maxLeft = 0;
				int minRight = 0;
				if(i==0){
					maxLeft = bigger[j-1];
				}
				else if(j==0){
					maxLeft = smaller[i-1];
				} else{
					maxLeft = Math.max(smaller[i-1], bigger[j-1]);
				}

				if ( (m + n) % 2 == 1 ) { return maxLeft; }

				if(i==m){
					minRight = bigger[j];
				}
				else if(j==n){
					minRight = smaller[i];
				} else{
					minRight = Math.min(smaller[i], bigger[j]);
				}
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