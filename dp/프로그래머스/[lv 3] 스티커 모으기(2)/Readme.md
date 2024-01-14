## 쉬운 계단 수

> [문제 링크](https://school.programmers.co.kr/learn/courses/30/lessons/12971?language=java#)


```java
class Solution {
	public int solution(int sticker[]) {

		int length = sticker.length;
		int max1 = getMaxDp(0, length - 1, sticker);
		int max2 = getMaxDp(1, length, sticker);

		System.out.println(Math.max(max1, max2));
		return Math.max(max1, max2);
	}

	public int getMaxDp(int start, int end, int[] sticker) {
		int length = end - start;
		if (start == end) {
			return sticker[0];
		}
		int[] dp = new int[length+1];
		dp[start] = sticker[start];
		int max = dp[start];
		if (length > 1) {
			dp[start + 1] = sticker[start + 1];
			max = Math.max(max, dp[start + 1]);
		}

		if (length > 2) {
			dp[start + 2] = dp[start] + sticker[start + 2];
			max = Math.max(max, dp[start + 2]);
		}

		for (int i = start + 3; i < end; i++) {
			dp[i] = Math.max(dp[i - 3], dp[i - 2]) + sticker[i];
			max = Math.max(max, dp[i]);
		}

		return max;
	}
}
```
