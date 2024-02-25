## Word Pattern

> [문제 링크](https://leetcode.com/problems/word-pattern/description/?envType=study-plan-v2&envId=top-interview-150)

``` java
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

class Solution {
  static int length;
  static char [] patternCharArray;
  public boolean wordPattern(String pattern, String s) {
    StringTokenizer st = new StringTokenizer(s);
    patternCharArray = pattern.toCharArray();
    length = patternCharArray.length;
    if (length != st.countTokens()) {
      return false;
    }

    Map<Character, String> map = new HashMap<>();
    for (int i = 0; i < length; i++) {
      String word = st.nextToken();
      char alphabet = patternCharArray[i];
      if (map.containsKey(alphabet)) {
        String mapValue = map.get(alphabet);
        if (!mapValue.equals(word)) {
          return false;
        }
      } else {
        if (map.containsValue(word)) {
          return false;
        }
        map.put(alphabet, word);
      }
    }
    return true;
  }
}
```
