import java.util.*;

class Solution {
    public String largestNumber(int[] nums) {
        int length = nums.length;
        
        List<Num> numStrings = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            numStrings.add(new Num(String.valueOf(nums[i])));
        }

        Collections.sort(numStrings);
        String answer = "";
        for (int i = 0; i < length; i++) {
            answer += numStrings.get(i).num;
            if (answer.equals("0")) {
                break;
            }
        }
        return answer;
    }

    static class Num implements Comparable<Num> {
        String num;

        public Num (String num) {
            this.num = num;
        }

        public int compareTo(Num o) {
            return (o.num + this.num).compareTo(this.num + o.num);
        }
    }
}