## Merge k Sorted Lists


> [문제 링크](https://leetcode.com/problems/merge-k-sorted-lists/description/?envType=study-plan-v2&envId=top-interview-150)

``` java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
	ListNode result;
	public ListNode mergeKLists(ListNode[] lists) {
		result = (lists.length == 0) ? null : lists[0];

		for (int i = 1; i < lists.length; i++) {
			ListNode listNode = lists[i];
			if (listNode == null) {
				continue;
			}

			if (result == null) {
				result = listNode;
				continue;
			}

			ListNode prevNode = null;
			ListNode resultNode = result;
			while (listNode != null) {
				int listNodeVal = listNode.val;
				int resultNodeVal = resultNode.val;

				if (listNodeVal >= resultNodeVal) {
					prevNode = resultNode;
					resultNode = resultNode.next;
					if (resultNode == null) {
						prevNode.next = listNode;
						listNode = null;
					}
				} else {
					if (prevNode == null) {
						result = new ListNode(listNodeVal, resultNode);
						prevNode = result;
						listNode = listNode.next;
					} else {
						ListNode middleListNode = new ListNode(listNodeVal, resultNode);
						prevNode.next = middleListNode;
						prevNode = middleListNode;
						listNode = listNode.next;
					}
				}
			}
		}

		return result;
	}
}
```
