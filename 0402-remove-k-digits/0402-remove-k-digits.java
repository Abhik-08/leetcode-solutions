class Solution {
    public String removeKdigits(String num, int k) {

        Stack<Character> stack = new Stack<>();

        for (char digit : num.toCharArray()) {

            while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
                stack.pop();
                k--;
            }

            stack.push(digit);
        }

        // If k still remains, remove from end
        while (k > 0) {
            stack.pop();
            k--;
        }

        // Build result
        StringBuilder sb = new StringBuilder();

        for (char c : stack) {
            sb.append(c);
        }

        // Remove leading zeros
        while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }

        // If empty return 0
        return sb.length() == 0 ? "0" : sb.toString();
    }
}