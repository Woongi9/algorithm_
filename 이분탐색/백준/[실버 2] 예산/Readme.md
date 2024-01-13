## 괄호

> [문제 링크](https://www.acmicpc.net/problem/2512)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int n;
	static long maxBudget;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(getStringByBufferedReader(br));
		List<Integer> budgetList = getBudgetList(br);
		long totalBudget = Long.valueOf(getStringByBufferedReader(br));
		getMaxBudget(totalBudget, budgetList);
		System.out.println(maxBudget);
	}

	private static String getStringByBufferedReader(BufferedReader br) {
		try {
			return br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static List<Integer> getBudgetList(BufferedReader br) {
		StringTokenizer st = new StringTokenizer(getStringByBufferedReader(br));
		List<Integer> budgetList = new ArrayList<>();
		while (st.hasMoreTokens()) {
			int budget = Integer.parseInt(st.nextToken());
			budgetList.add(budget);
		}
		Collections.sort(budgetList);
		return budgetList;
	}

	private static void getMaxBudget(long lastBudget, List<Integer> budgetList) {
		int size = budgetList.size();
		long sumBudget = budgetList.stream()
			.mapToLong(Integer::intValue)
			.sum();
		if (lastBudget >= sumBudget) {
			maxBudget = Collections.max(budgetList).longValue();
			return;
		}
		long minPartBudget = lastBudget / size;

		int l = 0;
		int r = size - 1;
		while (l < r-1) {
			int mid = (l + r) / 2;
			if (budgetList.get(mid) > minPartBudget) {
				r = mid;
			} else if (budgetList.get(l) <= minPartBudget) {
				l = mid;
			}
		}

		long smallBudgetSum = budgetList.subList(0, l+1).stream()
			.mapToLong(Integer::longValue)
			.sum();
		if (l != 0) {
			getMaxBudget(lastBudget - smallBudgetSum, budgetList.subList(l + 1, size));
		} else {
			maxBudget = minPartBudget;
		}
	}
}
```
