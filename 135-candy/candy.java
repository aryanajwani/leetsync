class Solution {
    public int candy(int[] ratings) {
        int total = 1;
        int prev = 1;

        int i = 1;
        while (i < ratings.length) {
            // increasing slope
            if (ratings[i - 1] < ratings[i]) {
                total += ++prev;
            }

            else if (ratings[i - 1] == ratings[i]) {
                total += 1;
                prev = 1;
            }

            // decreasing slope
            else {
                int peak = prev;

                int count = 1;
                while (i < ratings.length && ratings[i - 1] > ratings[i]) {
                    total += count;
                    count++;
                    i++;
                }

                if (count > peak)
                    total += (count - peak);
                prev = 1;
                continue;
            }

            i++;
        }

        return total;
    }
}