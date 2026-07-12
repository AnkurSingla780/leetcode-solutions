class Solution {
    public int[] getOrder(int[][] tasks) {

        int n = tasks.length;

        // [enqueueTime, processingTime, originalIndex]
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = tasks[i][0];
            arr[i][1] = tasks[i][1];
            arr[i][2] = i;
        }

        // Sort by enqueue time
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Min Heap:
        // 1. Smaller processing time first
        // 2. If equal, smaller original index first
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);
            return Integer.compare(a[2], b[2]);
        });

        int[] ans = new int[n];

        int idx = 0;      // answer array pointer
        int i = 0;        // next task to insert
        long time = 0;    // current CPU time

        while (i < n || !pq.isEmpty()) {

            // If CPU is idle, jump to next task's enqueue time
            if (pq.isEmpty() && time < arr[i][0]) {
                time = arr[i][0];
            }

            // Add every task that has arrived
            while (i < n && arr[i][0] <= time) {
                pq.offer(arr[i]);
                i++;
            }

            // Execute shortest available task
            int[] curr = pq.poll();

            ans[idx++] = curr[2];

            time += curr[1];
        }

        return ans;
    }
}