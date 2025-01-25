## 274. H-Index

> [문제 링크](https://leetcode.com/problems/h-index/description/?envType=study-plan-v2&envId=top-interview-150)

```java
public static int hIndex(int[] citations) {
		Arrays.sort(citations);
		Map<Integer, Integer> countMap = getCountMap(citations);
		int h = citations.length;
		for (int i = h - 1; i >= 0; i--) {
			int count = 0;
			for (Integer num : countMap.keySet()) {
				if (num >= h) {
					count += countMap.get(num);
				}
			}

			if (count >= h) {
				return h;
			} else {
				h--;
			}
		}

		return 0;
	}

	private static Map<Integer, Integer> getCountMap(int[] citations) {
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int i = 0; i < citations.length; i++) {
			if (countMap.containsKey(citations[i])) {
				countMap.put(citations[i], countMap.get(citations[i]) + 1);
			} else {
				countMap.put(citations[i], 1);
			}
		}
		return countMap;
	}
}
```
