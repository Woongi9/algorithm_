## Letter Cominations of a Phone Number

[문제 링크](https://leetcode.com/problems/letter-combinations-of-a-phone-number/?envType=study-plan-v2&envId=top-interview-150)

```java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
	static Map<Integer, List<Character>> numberDigitMap;
	static List<String> result;
	static String dials;
	public List<String> letterCombinations(String digits) {
		putNumberDigitMap();
		result = new ArrayList<>();
		dials = digits;
		if (digits.isEmpty()) {
			return result;
		}

		makeString(0, "");
		return result;
	}

	private static void putNumberDigitMap() {
		numberDigitMap = new HashMap<>();
		numberDigitMap.put(2, List.of('a', 'b', 'c'));
		numberDigitMap.put(3, List.of('d', 'e', 'f'));
		numberDigitMap.put(4, List.of('g', 'h', 'i'));
		numberDigitMap.put(5, List.of('j', 'k', 'l'));
		numberDigitMap.put(6, List.of('m', 'n', 'o'));
		numberDigitMap.put(7, List.of('p', 'q', 'r', 's'));
		numberDigitMap.put(8, List.of('t', 'u', 'v'));
		numberDigitMap.put(9, List.of('w', 'x', 'y', 'z'));
	}

	private static void makeString(int index, String string) {
		 int dial = dials.charAt(index) - '0';
		 List<Character> digitList = numberDigitMap.get(dial);

		for (Character character : digitList) {
			String newString = string + character;
			if (index + 1 == dials.length()) {
				result.add(newString);
			} else {
				makeString(index + 1, newString);
			}
		}
	}
}
```
