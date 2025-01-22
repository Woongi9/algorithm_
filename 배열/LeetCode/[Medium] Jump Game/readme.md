## 55. Jump Game

> [문제 상황](https://leetcode.com/problems/jump-game/description/?envType=study-plan-v2&envId=top-interview-150)

```java
class Solution {
    public boolean canJump(int[] nums) {
		boolean[] reachCheck = new boolean[nums.length];
		reachCheck[0] = true;
		for (int i = 0; i < nums.length - 1; i++) {
			if (reachCheck[i]) {
				int x = nums[i];
				for (int j = 1; j <= x; j++) {
                    if(i + j < nums.length){
                        reachCheck[i + j] = true;
                    }
					
				}
			}
		}
		return reachCheck[nums.length - 1];
	}
}
```
