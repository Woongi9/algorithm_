## 45. Jump Game II

> [문제 링크](https://leetcode.com/problems/jump-game-ii/description/?source=submission-ac)

```java
class Solution {
    public static int jump(int[] nums) {
		int[] counts = new int[nums.length];
		Arrays.fill(counts, Integer.MAX_VALUE);
		counts[0] = 0;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			int count = counts[i];

			for (int j = 1; j <= num; j++) {
				if (i + j < nums.length) {
					counts[i + j] = Math.min(count + 1, counts[i + j]);
				}
			}
		}

		return counts[nums.length - 1];
	}
}
```
