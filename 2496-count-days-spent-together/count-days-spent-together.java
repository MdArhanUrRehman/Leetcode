
class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice,
                                 String arriveBob, String leaveBob) {

        int[][] dates = new int[4][2];

        String[] arr = {arriveAlice, leaveAlice, arriveBob, leaveBob};

        for (int i = 0; i < 4; i++) {
            dates[i][0] = Integer.parseInt(arr[i].substring(0, 2));
            dates[i][1] = Integer.parseInt(arr[i].substring(3, 5));
        }

        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Convert dates to day numbers
        int[] day = new int[4];

        for (int i = 0; i < 4; i++) {
            for (int m = 1; m < dates[i][0]; m++) {
                day[i] += months[m];
            }
            day[i] += dates[i][1];
        }

        int start = Math.max(day[0], day[2]);
        int end = Math.min(day[1], day[3]);

        return Math.max(0, end - start + 1);
    }
}
