class Solution {
    public int[] arrayRankTransform(int[] arr) {
        int[] sorted = arr.clone();

        // Sort the copied array
        Arrays.sort(sorted);

        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 1;

        // Assign ranks to unique values
        for (int value : sorted) {

            if (!map.containsKey(value)) {
                map.put(value, rank);
                rank++;
            }
        }

        // Replace original values with their ranks
        for (int i = 0; i < arr.length; i++) {
            arr[i] = map.get(arr[i]);
        }

        return arr;
    }
}