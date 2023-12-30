## 괄호

> [문제 링크](https://www.acmicpc.net/problem/9012)

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Main {
	static int n;
	static List<String> answerList = new ArrayList<>();
	static final char LEFT = '(';
	static final char RIGHT = ')';
	static final String NO = "NO";
	static final String YES = "YES";
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(getString(br));
		List<String> stringList = getStringList(br);
		getAnswerList(stringList);

		for (String answer : answerList) {
			System.out.println(answer);
		}

	}

	private static String getString(BufferedReader br) {
		String readLine;
		try {
			readLine = br.readLine();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return readLine;
	}

	private static List<String> getStringList(BufferedReader br) {
		List<String> stringList = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			stringList.add(getString(br));
		}
		return stringList;
	}

	private static void getAnswerList(List<String> stringList) {
		for (int i = 0; i < n; i++) {
			Stack<Character> stack = new Stack<>();
			for (char character : stringList.get(i).toCharArray()) {
				if (character == LEFT) {
					stack.push(character);
				} else if (character == RIGHT) {
					if (stack.isEmpty()) {
						stack.push(character);
						break;
					}
					Character latestCharacter = stack.pop();
					if (latestCharacter == RIGHT) {
						stack.push(character);
						break;
					}
				}
			}

			if (stack.isEmpty()) {
				answerList.add(YES);
			} else {
				answerList.add(NO);
			}
		}
	}

}
```
