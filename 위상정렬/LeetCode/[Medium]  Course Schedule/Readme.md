## Course Schedule


> [문제 링크](https://leetcode.com/problems/course-schedule/description/)

``` java
class Solution {
	int [] degrees;
	boolean [] visited;
	List<Integer>[] preCourseList;
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		degrees = new int [numCourses];
		visited = new boolean [numCourses];
		preCourseList = new ArrayList[numCourses];
		for (int i = 0; i < numCourses; i++) {
			preCourseList[i] = new ArrayList<>();
		}

		for (int i = 0; i < prerequisites.length; i++) {
			preCourseList[prerequisites[i][1]].add(prerequisites[i][0]);
			degrees[prerequisites[i][0]]++;
		}

		Queue<Integer> queue = new LinkedList<>();
		for (int i = 0; i < numCourses; i++) {
			if (degrees[i] == 0) {
				queue.add(i);
			}
		}

		while (!queue.isEmpty()) {
			Integer preCourse = queue.remove();
			visited[preCourse] = true;
			List<Integer> courseList = preCourseList[preCourse];
			for (Integer course : courseList) {
				degrees[course]--;
				if (degrees[course] == 0) {
					queue.add(course);
				}
			}
		}

		for (int i = 0; i < numCourses; i++) {
			if (!visited[i]) {
				return false;
			}
		}
		return true;
	}
}
```
