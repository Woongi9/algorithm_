## Number of Islands

[문제 링크](https://leetcode.com/problems/number-of-islands/description/?envType=study-plan-v2&envId=top-interview-150)

```java
import java.util.LinkedList;
import java.util.Queue;

class Solution {
	static int n, m;
	static boolean [][] visited;
	static int count;
	public int numIslands(char[][] grid) {
		n = grid.length;
		m = grid[0].length;
		count = 0;
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					searchIsland(grid, i, j);
				}
			}
		}
		return count;
	}

	public void searchIsland(char[][] grid, int i, int j) {
		int [][] move = new int[4][2];
		move[0] = new int[] {1, 0};
		move[1] = new int[] {-1, 0};
		move[2] = new int[] {0, 1};
		move[3] = new int[] {0, -1};
		count++;

		Queue<int []> queue = new LinkedList<>();
		queue.add(new int [] {i, j});
		while (!queue.isEmpty()) {
			int[] remove = queue.remove();
			int x = remove[0], y = remove[1];

			for (int k = 0; k < 4; k++) {
				int nx = x + move[k][0], ny = y + move[k][1];
				if (nx >= 0 && nx < n && ny >= 0 && ny < m
					&& grid[nx][ny] == '1'
					&& !visited[nx][ny]) {
					visited[nx][ny] = true;
					queue.add(new int[] {nx, ny});
				}
			}
		}
	}
}

```
