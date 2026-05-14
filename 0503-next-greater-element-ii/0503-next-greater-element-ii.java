class Solution {
    public int[] nextGreaterElements(int[] nums) {

        int n = nums.length;

        int[] ans = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Initialize all answers as -1
        Arrays.fill(ans, -1);

        // Traverse 2 times for circular array
        for (int i = 2 * n - 1; i >= 0; i--) {

            int index = i % n;

            // Remove smaller or equal elements
            while (!stack.isEmpty() && stack.peek() <= nums[index]) {
                stack.pop();
            }

            // Store answer only for first traversal
            if (i < n) {

                if (!stack.isEmpty()) {
                    ans[index] = stack.peek();
                }
            }

            // Push current element
            stack.push(nums[index]);
        }

        return ans;
    }
}