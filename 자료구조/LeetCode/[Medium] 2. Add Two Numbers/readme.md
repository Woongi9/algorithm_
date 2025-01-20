## 2. Add Two Numbers

[문제 링크](https://leetcode.com/problems/add-two-numbers/description/)

```java
class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		List<Character> l1List = getCharacterArrayByListNode(l1);
		List<Character> l2List = getCharacterArrayByListNode(l2);

		char[] result = new char[Math.max(l1List.size(), l2List.size()) + 1];
		Arrays.fill(result, '0');
		int carry = 0;
		int index = 0;
		while(l1List.size() >= index || l2List.size() >= index) {
			int l1Val = (l1List.size() > index) ? l1List.get(index) : 0;
			int l2Val = (l2List.size() > index) ? l2List.get(index) : 0;
			int sum = l1Val + l2Val + carry;
			result[index] = (char) (sum % 10 + '0');

			carry = sum / 10;
			index++;
		}

		return getListNodeByCharacterArray(result, 0);
	}

	public static List<Character> getCharacterArrayByListNode(ListNode l1) {
		List<Character> characterList = new ArrayList<>();
		while (l1 != null) {
			characterList.add((char) l1.val);
			l1 = l1.next;
		}
		return characterList;
	}

	public static ListNode getListNodeByCharacterArray(char[] chars, int index) {
		if (index < chars.length) {
			if ((chars.length == 1) || !((index == chars.length - 1) && chars[index] == '0')) {
				return new ListNode(Character.getNumericValue(chars[index]),
					getListNodeByCharacterArray(chars, index + 1));
			} else {
				return null;
			}
		} else {
			return null;
		}
	}
}
```
