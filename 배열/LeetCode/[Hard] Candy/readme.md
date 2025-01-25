## Candy

> [문제 링크](https://leetcode.com/problems/candy/description/?envType=study-plan-v2&envId=top-interview-150)

``` java
class Solution {
    public int candy(int[] ratings) {
		int[][] result = new int[2][ratings.length];
		Arrays.fill(result[0], 1);
		Arrays.fill(result[1], 1);

		insertCandyByAsc(ratings, result);
		insertCandyByDesc(ratings, result);

		return getCandySum(result);
	}

	private static void insertCandyByAsc(int[] ratings, int[][] result) {
		int prevIndex = 0;

		for (int i = 1; i < ratings.length; i++) {
			int rating = ratings[i];
			int prev = ratings[prevIndex];
			if (prev < rating) {
				result[0][i] = result[0][prevIndex] + 1;
				prevIndex = i;
			} else {
				result[0][i] = 1;
				prevIndex = i;
			}
		}
	}

	private static void insertCandyByDesc(int[] ratings, int[][] result) {
		int prevIndex = ratings.length - 1;

		for (int i = prevIndex; i >= 0; i--) {
			int rating = ratings[i];
			int prev = ratings[prevIndex];
			if (prev < rating) {
				result[1][i] = result[1][prevIndex] + 1;
				prevIndex = i;
			}else {
				result[1][i] = 1;
				prevIndex = i;
			}
		}
	}

	private static int getCandySum(int[][] result) {
		int sum = 0;
		for (int i = 0; i < result[0].length; i++) {
			sum += Math.max(result[0][i], result[1][i]);
		}
		return sum;
	}
}
```
