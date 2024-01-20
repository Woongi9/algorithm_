## 쉬운 계단 수

> [문제 링크](https://www.acmicpc.net/problem/13305)


```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
	static int n;
	static List<Long> priceList;
	static List<Long> distanceList;
	static List<Long> distanceSumList = new ArrayList<>();
	public static void main(String[] args) {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(getString(br));
		distanceList = getLongList(br);
		priceList = getLongList(br);
		getDistanceSumList();
		List<Tuple> tupleList = getTupleList();
		System.out.println(getAnswer(tupleList));
	}

	private static void getDistanceSumList() {
		long distanceSum = distanceList.stream()
			.mapToLong(Long::longValue)
			.sum();
		distanceSumList.add(distanceSum);
		for (int i = 1; i < distanceList.size(); i++) {
			distanceSum -= distanceList.get(i - 1);
			distanceSumList.add(distanceSum);
		}
		distanceSumList.add(0L);
	}

	public static String getString(BufferedReader bufferedReader) {
		String str;
		try {
			str = bufferedReader.readLine();
		} catch (Exception e) {
			throw new IllegalArgumentException("String Input Error!!!");
		}
		return str;
	}

	private static List<Long> getLongList(BufferedReader br) {
		StringTokenizer st = new StringTokenizer(getString(br));
		List<Long> list = new ArrayList<>();
		while (st.hasMoreTokens()) {
			list.add(Long.parseLong(st.nextToken()));
		}
		return list;
	}

	private static List<Tuple> getTupleList() {
		List<Tuple> list = new ArrayList<>();
		for (int i = 0; i < priceList.size(); i++) {
			Long distanceSum = distanceSumList.get(i);
			list.add(new Tuple(priceList.get(i), distanceSum));
		}
		return list.stream()
			.sorted(Comparator.comparing(Tuple::getPrice))
			.collect(Collectors.toList());
	}

	private static long getAnswer(List<Tuple> tupleList) {
		long answer = 0L;
		long nowDistanceSum = 0L;
		for (Tuple tuple : tupleList) {
			long price = tuple.price;
			long distanceSum = tuple.distanceSum;
			if (distanceSum < nowDistanceSum) {
				continue;
			}

			answer += price * (distanceSum - nowDistanceSum);
			nowDistanceSum = distanceSum;
		}
		return answer;
	}
	static class Tuple {

		long price;
		long distanceSum;

		public Tuple(long price, long distanceSum) {
			this.distanceSum = distanceSum;
			this.price = price;
		}

		public long getPrice() {
			return price;
		}
	}
}
```
