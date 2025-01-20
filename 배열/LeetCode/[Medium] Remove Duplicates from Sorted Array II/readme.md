## 80. Remove Duplicates from Sorted Array II

> [문제 링크](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description/?envType=study-plan-v2&envId=top-interview-150)

```java
class Solution {
    private static int[] getIntArray(List<Integer> list) {
		int size = list.size();
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = list.get(i);
		}
		return array;
	}

	public static int removeDuplicates(int[] nums) {
		Map<Integer, Integer> numberAndCountMap = new HashMap<>();
		int k = putMapAndGetK(nums, numberAndCountMap);
		arrangeNums(nums, numberAndCountMap);
		return k;
	}

	private static int putMapAndGetK(int[] nums, Map<Integer, Integer> map) {
		int k = 0;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (map.containsKey(num)) {
				Integer numCount = map.get(num);
				if (numCount > 1) {
					continue;
				} else {
					map.put(num, numCount + 1);
				}
			} else {
				map.put(num, 1);
			}

			k++;
		}
		return k;
	}

	private static void arrangeNums(int[] nums, Map<Integer, Integer> numberAndCountMap) {
		List<Integer> numberList = numberAndCountMap.keySet()
			.stream()
			.sorted()
			.toList();

		int listIndex = 0;
		int arrayIndex = 0;
		while(arrayIndex < nums.length) {
			if (listIndex >= numberList.size()) {
				nums[arrayIndex] = Integer.MAX_VALUE;
			} else {
				Integer number = numberList.get(listIndex);
				nums[arrayIndex] = number;
				Integer count = numberAndCountMap.get(number);
				numberAndCountMap.put(number, count - 1);
				if (count - 1 == 0) {
					listIndex++;
				}
			}

			arrayIndex++;
		}
	}
}
```
