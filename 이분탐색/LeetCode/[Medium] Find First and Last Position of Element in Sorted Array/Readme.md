## Find First and Last Position of Element in Sorted Array

> [문제 링크]([https://leetcode.com/problems/word-pattern/description/?envType=study-plan-v2&envId=top-interview-150](https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150))

``` java

class Solution {
	public int[] searchRange(int[] nums, int target) {

		boolean check = false;
		int targetIndex = 0;
		int l = 0, r = nums.length - 1;
		while (l < r) {
			int mid = (r + l) / 2;
			if (nums[mid] == target) {
				check = true;
				targetIndex = mid;
				l = mid;
				break;
			} else if(nums[mid] < target) {
				l = (l == mid) ? r : mid;
			} else if (nums[mid] > target) {
				r = (r == mid) ? l : mid;
			}
		}

		if (nums.length == 0 || (!check && nums[l] != target)) {
			return new int[]{-1, -1};
		}

		int left = l;
		while(left - 1 >= 0 && nums[left - 1] == target) {
			left--;
		}

		int right = l;
		while(right + 1 < nums.length && nums[right + 1] == target) {
			right++;
		}
		return new int []{left, right};
	}
}
```
