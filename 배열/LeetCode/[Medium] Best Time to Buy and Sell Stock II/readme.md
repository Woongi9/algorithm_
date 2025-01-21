## 122. Best Time to Buy and Sell Stock II

> [문제 링크](https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/description/?envType=study-plan-v2&envId=top-interview-150)

``` java
class Solution {
    public int maxProfit(int[] prices) {
		int [] profit = new int [prices.length];
		profit[0] = 0;
		int smallestIndex = 0;
		for (int i = 1; i < prices.length; i++) {
			int smallestPrice = prices[smallestIndex];
			if (smallestPrice < prices[i]) {
				profit[i] = profit[smallestIndex] + prices[i] - smallestPrice;
				smallestIndex = i;
			} else {
				profit[i] = profit[i - 1];
				smallestIndex = i;
			}
		}

		return profit[profit.length - 1];
	}
}
```
