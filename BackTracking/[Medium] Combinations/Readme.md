## Combinations


> [문제 링크](https://leetcode.com/problems/combinations/description/?envType=study-plan-v2&envId=top-interview-150)

``` java
import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		Solution solution = new Solution();
		System.out.println(solution.combine(4, 2));
		System.out.println(solution.combine(1, 1));
	}
}

class Solution {
	static int length, combinationSize;
	static boolean[] usedCheck;
	static List<List<Integer>> combinationList;
	public List<List<Integer>> combine(int n, int k) {
		length = n;
		usedCheck = new boolean[n + 1];
		combinationSize = k;
		combinationList = new ArrayList<List<Integer>>();

		makeNumber(new ArrayList<Integer>(), 1, 0);
		return combinationList;
	}

	public static void makeNumber(List<Integer> numberList, int start, int combination) {
		for (int i = start; i <= length; i++) {
			if (!usedCheck[i]) {
				usedCheck[i] = true;
				numberList.add(i);
				if (numberList.size() == combinationSize) {
					combinationList.add(numberList.stream().toList());
				} else {
					makeNumber(numberList, i + 1, combination + 1);
				}
				numberList.remove(numberList.size() - 1);
				usedCheck[i] = false;
			}
		}
	}
}
```
