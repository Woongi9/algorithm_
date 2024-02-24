## Best Time to Buy and Sell Stock

> [문제 링크](https://leetcode.com/problems/best-time-to-buy-and-sell-stock/submissions/1184588610/?envType=study-plan-v2&envId=top-interview-150)

``` java
class Solution {
	static int length;
	public int maxProfit(int[] prices) {
		length = prices.length;

		int sum, l, r;
		sum = l = 0;
		r = 1;
		while (r < length) {
			int lValue = prices[l];
			int rValue = prices[r];
			if (lValue < rValue) {
				int profit = rValue - lValue;
				if (Math.max(profit, sum) == profit) {
					sum = profit;
				}
			}

			if (lValue > rValue) {
				l = r;
			}
			r++;
		}

		return sum;
	}
}
> ```
