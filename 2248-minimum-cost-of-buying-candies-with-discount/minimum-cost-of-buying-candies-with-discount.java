import java.util.Arrays;

class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        int total = 0;
        int len = cost.length;

        for (int i = 0; i < len; i += 3) {
            total += cost[len - 1 - i];

            if (i + 1 < len) {
                total += cost[len - 1 - (i + 1)];
            }
        }

        return total;
    }
}