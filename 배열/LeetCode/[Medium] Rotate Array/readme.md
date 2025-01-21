## 189. Rotate Array

> [문제 링크](https://leetcode.com/problems/rotate-array/?envType=study-plan-v2&envId=top-interview-150)

``` java
class Solution {
    public void rotate(int[] nums, int k) {
		k = k % nums.length;
		int [] result = new int[k];
		for (int i = 0; i < k; i++) {
			result[i] = nums[nums.length - k + i];
		}

		for (int i = nums.length - 1; i >= k; i--) {
			nums[i] = nums[i - k];
		}

		for (int i = 0; i < k; i++) {
			nums[i] = result[i];
		}
		System.out.println(nums);
	}
}
```
