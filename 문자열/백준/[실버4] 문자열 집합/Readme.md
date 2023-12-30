## 문자열 집합

> [문제 링크](https://www.acmicpc.net/problem/14425)


```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	static int n, m, answer;
	static Set<String> targetSet = new HashSet<>();
	static List<String> stringList = new ArrayList<>();
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(getBrLine(br));
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());

		getTargetSet(br);
		getStringList(br);
		getAnswer();
		System.out.println(answer);
	}

	private static String getBrLine(BufferedReader br) {
		String string = "";
		try {
			string = br.readLine();
		} catch (Exception e) {
			new RuntimeException(e);
		}

		return string;
	}

	private static void getTargetSet(BufferedReader br) {
		for (int i = 0; i < n; i++) {
			targetSet.add(getBrLine(br));
		}
	}

	private static void getStringList(BufferedReader br) {
		for (int i = 0; i < m; i++) {
			stringList.add(getBrLine(br));
		}
	}

	private static void getAnswer() {
		answer = 0;
		for (String string : stringList) {
			if (targetSet.contains(string)) {
				answer++;
			}
		}
	}
}

```
