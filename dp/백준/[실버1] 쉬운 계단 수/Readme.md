## 쉬운 계단 수

> [문제 링크](https://www.acmicpc.net/problem/10844)


```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	private static int n;
	private static long [][] dp;
	private static final long DIVIDER = 1000000000;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		getN(br);
		getDP();
		printSum();
	}

	private static void getN(BufferedReader br) {
		try {
			n = Integer.parseInt(br.readLine());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static void getDP() {
		initDP();
		makeDP();
	}

	private static void initDP() {
		dp = new long[n + 1][10];
		Arrays.fill(dp[1], 1L);
		dp[1][0] = 0L;
	}

	private static void makeDP() {
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < 10; j++) {
				long count = dp[i][j];
				if (j >= 1) {
					count += dp[i - 1][j - 1];
				}
				if (j < 9) {
					count += dp[i - 1][j + 1];
				}
				dp[i][j] = count % DIVIDER;
			}
		}
	}

	private static void printSum() {
		long sum = 0L;
		for (int i = 0; i <= 9; i++) {
			sum += dp[n][i];
		}
		System.out.println(sum % DIVIDER);
	}
}
```
