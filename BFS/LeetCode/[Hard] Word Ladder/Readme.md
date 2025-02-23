## Word Ladder

[문제 링크](https://leetcode.com/problems/word-ladder/description/?envType=study-plan-v2&envId=top-interview-150)

```java
class Solution {
	static Set<String> wordSet;
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		wordSet = new HashSet<>(wordList);

		Queue<ChangedWord> queue = new java.util.LinkedList<>();
		queue.add(new ChangedWord(beginWord, 1));
		while (!queue.isEmpty()) {
			ChangedWord changedWord = queue.remove();
			String word = changedWord.word;
			int count = changedWord.count;
			if (word.equals(endWord)) {
				return count;
			}

			List<String> setList = wordSet.stream().toList();
			for (String string : setList) {
				int diff = 0;
				for (int i = 0; i < word.length(); i++) {
					if (word.charAt(i) != string.charAt(i)) {
						diff++;
					}
				}

				if (diff == 1) {
					queue.add(new ChangedWord(string, count + 1));
					wordSet.remove(string);
				}
			}
		}

		return 0;
	}
}

class ChangedWord {
	String word;
	int count;

	public ChangedWord(String word, int count) {
		this.word = word;
		this.count = count;
	}
}
```
