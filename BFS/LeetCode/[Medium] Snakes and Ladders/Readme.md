## Snakes and Ladders

> [문제 링크]([https://leetcode.com/problems/word-pattern/description/?envType=study-plan-v2&envId=top-interview-150](https://leetcode.com/problems/snakes-and-ladders/description/?envType=study-plan-v2&envId=top-interview-150))

``` java
import java.util.LinkedList;
import java.util.Queue;
class Solution {
	int n, answer;
	int [] newBoard;
	boolean [] visited;
	static int [] dice = new int [] {1,2,3,4,5,6};
	public int snakesAndLadders(int[][] board) {
		n = board.length;
		answer = Integer.MAX_VALUE;
		getNewBoard(board);

		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(1, 0));
		visited[1] = true;
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			int square = node.square;
			for (int i = 0; i < dice.length; i++) {
				int nextSquare = square + dice[i];
				if (nextSquare == n * n) {
					answer = Math.min(answer, node.count + 1);
				}

				if (nextSquare <= n * n && !visited[nextSquare]) {
					if (newBoard[nextSquare] != -1) {
						queue.add(new Node(newBoard[nextSquare], node.count + 1));
						if (newBoard[nextSquare] == n * n) {
							answer = Math.min(answer, node.count + 1);
						} else if( !visited[newBoard[nextSquare]]) {
							queue.add(new Node(newBoard[nextSquare], node.count + 1));
						}
					} else {
						queue.add(new Node(nextSquare, node.count + 1));
					}
					visited[nextSquare] = true;
				}
			}
		}

		return (answer == Integer.MAX_VALUE) ? -1 : answer;
	}

	private void getNewBoard(int[][] board) {
		newBoard = new int[n * n + 1];
		visited = new boolean[n * n + 1];
		for (int i = 0; i < n * n; i++) {
			int x = (n * n - i - 1) / n;
			int y = (i / n) % 2 == 0 ? i % n : n - 1 - (i % n);

			newBoard[i + 1] = board[x][y];
		}
	}
}

class Node {
	int square;
	int count;

	public Node(int square, int count) {
		this.square = square;
		this.count = count;
	}
}
```
