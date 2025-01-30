## Text Justification

> [문제 링크](https://leetcode.com/problems/text-justification/?envType=study-plan-v2&envId=top-interview-150)

``` java
class Solution {
	public List<String> fullJustify(String[] words, int maxWidth) {
		List<String> list = new ArrayList<>();
		List<StringBuilder> wordList = new ArrayList<>();
		StringBuilder sentence = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			if (sentence.isEmpty()) {
				wordList.add(getStringBuilder(words[i]));
				sentence.append(words[i]);
			} else if (sentence.length() + 1 + words[i].length() <= maxWidth){
				wordList.add(getStringBuilder(words[i]));
				sentence.append(" ").append(words[i]);
			} else if (sentence.length() + 1 + words[i].length() > maxWidth){
				list.add(refineString(wordList, sentence.length(), maxWidth));
				wordList.clear();
				wordList.add(getStringBuilder(words[i]));
				sentence = new StringBuilder();
				sentence.append(words[i]);
			}
		}
		if (!sentence.isEmpty()) {
			if (sentence.length() < maxWidth) {
				addBlank(sentence, maxWidth - sentence.length());
			}
			list.add(sentence.toString());
		}
		return list;
	}

	private static StringBuilder getStringBuilder(String words) {
		return new StringBuilder(words);
	}

	private String refineString(List<StringBuilder> wordList, int stringBuilderLength, int maxWidth) {
		if (wordList.size() == 1) {
			return addBlank(wordList.get(0), maxWidth - wordList.get(0).length());
		}
		int divide = wordList.size() - 1;
		stringBuilderLength = stringBuilderLength - divide;
		int minimumBlankSize = (maxWidth - stringBuilderLength) / divide;
		for (int i = 0; i < wordList.size() - 1; i++) {
			StringBuilder word = wordList.get(i);
			int blankSize = 0;
			if ((minimumBlankSize * divide) == (maxWidth - stringBuilderLength)) {
				blankSize = minimumBlankSize;
			} else {
				blankSize = minimumBlankSize + 1;
				stringBuilderLength++;
			}
			addBlank(word, blankSize);
		}

		return String.join("", wordList);
	}

	private String addBlank(StringBuilder stringBuilder, int length) {
		for (int i = 0; i < length; i++) {
			stringBuilder.append(" ");
		}
		return stringBuilder.toString();
	}
}
```
