import java.util.*;

class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {

        int gasSum = 0;
        int costSum = 0;
        for(int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
            costSum += cost[i];
        }

        if (gasSum < costSum) {
            return -1;
        }

        PriorityQueue<Station> pq = new PriorityQueue<>();
        for (int i = 0; i < cost.length; i++) {
            pq.add(new Station(i, gas[i], cost[i]));
        }

        int answer = -1;
        while (!pq.isEmpty()) {
            Station s = pq.poll();

            int index = s.index;
            int fuel = 0;
            int count = 0;
            while (count < gas.length && fuel >= 0) {
                fuel += gas[index];
                fuel -= cost[index];
                count++;
                
                index++;
                if(index == gas.length) {
                    index = 0;
                }
            }

            if (count == gas.length) {
                answer = s.index;
                break;
            }
        }

        return answer;
    }

    public static class Station implements Comparable<Station> {
        int index;
        int gas;
        int cost;

        public Station(int index, int gas, int cose) {
            this.index = index;
            this.gas = gas;
            this.cost = cost;
        }

        @Override
        public int compareTo(Station station) {
            return (station.gas - station.cost) - (this.gas - this.cost);
        }
    }
}