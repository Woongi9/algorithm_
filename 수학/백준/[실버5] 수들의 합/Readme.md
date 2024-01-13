## 괄호

> [문제 링크](https://www.acmicpc.net/problem/1789) 

```java
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static long S;
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		getS(br);
		System.out.println(getAnswer());
	}

	private static void getS(BufferedReader br) {
		try {
			S = Long.valueOf(br.readLine());
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	private static int getAnswer() {
		int n = 1;
		double tunedS = getTuningS(n);
		while (IsNGreaterThanTunedS(n, tunedS)) {
			n++;
			tunedS = getTuningS(n);
		}
		return n - 1;
	}

	private static double getTuningS(int n) {
		return (S * 2) / n;
	}

	private static boolean IsNGreaterThanTunedS(int n, double tunedS) {
		return !((n - 1) <= tunedS && (double)n >= tunedS);
	}

}
```
