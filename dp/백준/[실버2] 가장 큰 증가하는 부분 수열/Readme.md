## 괄호

> [문제 링크](https://www.acmicpc.net/problem/11055)

```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int n, answer;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(getBrLineToString(br));
		int[] A = getIntArr(br);
		getAnswer(A);
		System.out.println(answer);
	}

	private static void getAnswer(int[] A) {
		int[] dp = new int[n];
		dp[0] = A[0];
		answer = A[0];

		for (int i = 1; i < n; i++) {
			int num = A[i];
			dp[i] = num;
			for (int j = 0; j <= i; j++) {
				if (num > A[j] && dp[j] + num > dp[i]) {
					dp[i] = dp[j] + num;
					answer = Math.max(dp[i], answer);
				}
			}
		}
	}

	public static String getBrLineToString(BufferedReader br) {
		String string = "";
		try {
			string = br.readLine();
		} catch (Exception e) {
			new RuntimeException(e);
		}
		return string;
	}

	private static int[] getIntArr(BufferedReader br) {
		int[] arr = new int[n];
		StringTokenizer st = new StringTokenizer(getBrLineToString(br));
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		return arr;
	}
}
```
