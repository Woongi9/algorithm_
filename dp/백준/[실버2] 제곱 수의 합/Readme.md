## 제곱 수의 합

> [문제 링크](https://www.acmicpc.net/problem/1699)


```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int n;
	private static int[] dp;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		getN(br);
		DP();

		System.out.println(dp[n]);
	}

	private static void DP() {
		dp = new int[n+1];
		for (int i = 0; i < n+1; i++) {
			dp[i] = i;
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j * j <= i; j++) {
				dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
			}
		}
	}

	private static void getN(BufferedReader br) {
		try {
			n = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}
```
