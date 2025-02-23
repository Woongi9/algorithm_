## Surrounded Regions

[문제 링크](https://leetcode.com/problems/surrounded-regions/?envType=study-plan-v2&envId=top-interview-150)

```java

class Solution {
	static List<int[]> moveList = List.of(new int[] {1, 0}, new int[] {-1, 0}, new int[] {0, 1}, new int[] {0, -1});
	static int n, m;
	static boolean[][] visited;
	public void solve(char[][] board) {
		n = board.length;
		m = board[0].length;
		visited = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (board[i][j] == 'O' && !visited[i][j]) {
					searchSurround(board, i, j);
				}
			}
		}
	}

	public void searchSurround(char[][] board, int i, int j) {
		Queue<int []> queue = new LinkedList<>();
		queue.add(new int[]{i, j});
		visited[i][j] = true;

		boolean surroundCheck = true;
		List<int[]> surroundList = new ArrayList<>();
		surroundCheck = addSurroundAndCheck(i, j, surroundCheck, surroundList);
		while (!queue.isEmpty()) {
			int[] dot = queue.remove();
			int x = dot[0], y = dot[1];
			for (int[] moveArray : moveList) {
				int newX = x + moveArray[0];
				int newY = y + moveArray[1];

				if (newX >= 0 && newX < n && newY >= 0 && newY < m) {
					if (board[newX][newY] == 'O' && !visited[newX][newY]) {
						surroundCheck = addSurroundAndCheck(newX, newY, surroundCheck, surroundList);
						queue.add(new int[]{newX, newY});
						visited[newX][newY] = true;
					}
				}
			}
		}

		if (surroundCheck) {
			for (int[] dot : surroundList) {
				int x = dot[0];
				int y = dot[1];

				board[x][y] = 'X';
			}
		}
	}

	private static boolean addSurroundAndCheck(int newX, int newY, boolean surroundCheck, List<int[]> surroundList) {
		if (newX == 0 || newX == n - 1 || newY == 0 || newY == m - 1) {
			surroundCheck = false;
		}
		surroundList.add(new int[]{newX, newY});
		return surroundCheck;
	}
}
```
