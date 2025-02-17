## Minimum Genetic Mutation


> [문제 링크](https://leetcode.com/problems/minimum-genetic-mutation/description/?envType=study-plan-v2&envId=top-interview-150)

``` java
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

class Solution {
	public int minMutation(String startGene, String endGene, String[] bankArray) {
		Set<String> bankSet = Arrays.stream(bankArray).collect(Collectors.toSet());

		Queue<Gene> queue = new LinkedList<>();
		queue.add(new Gene(startGene, 0));
		while(!queue.isEmpty()) {
			Gene gene = queue.poll();
			if(gene.gene.equals(endGene)) {
				return gene.count;
			}

			int sameCount = 0;
			char[] geneCharArray = gene.gene.toCharArray();
			for (String bank : bankArray) {
				sameCount = 0;
				for (int i = 0; i < bank.length(); i++) {
					sameCount = (geneCharArray[i] == bank.charAt(i)) ? sameCount + 1 : sameCount;
				}
				if (sameCount == 7 && bankSet.contains(bank)) {
					queue.add(new Gene(bank, gene.count + 1));
					bankSet.remove(bank);
				}
			}
		}
		return -1;
	}
}

class Gene{
	String gene;
	int count;

	public Gene(String gene, int count) {
		this.gene = gene;
		this.count = count;
	}
}
```
