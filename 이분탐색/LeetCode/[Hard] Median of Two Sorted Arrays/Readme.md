## Find First and Last Position of Element in Sorted Array

> [문제 링크](https://leetcode.com/problems/median-of-two-sorted-arrays/description/?envType=study-plan-v2&envId=top-interview-150)

``` java
class Solution {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int [] nums = new int[nums1.length + nums2.length];
		int x = 0, y = 0, k = 0;
		while(k < nums.length) {
			if (x >= nums1.length) {
				nums[k] = nums2[y];
				y++;
			} else if(y >= nums2.length) {
				nums[k] = nums1[x];
				x++;
			} else if (nums1[x] >= nums2[y]) {
				nums[k] = nums2[y];
				y++;
			} else if (nums1[x] < nums2[y]) {
				nums[k] = nums1[x];
				x++;
			}

			k++;
		}

		return (nums.length % 2 == 1) ? nums[nums.length / 2] : (double)(nums[nums.length / 2 - 1] + nums[nums.length
			/ 2]) / 2;
	}
}
```
