import java.util.*;

public class Solution
{
    public int[] nextGreaterElement(int[] nums1, int[] nums2)
    {
        // Store next greater element
        HashMap<Integer, Integer> map = new HashMap<>();

        // Manual stack using array
        int[] stack = new int[nums2.length];

        int top = -1;

        // Process nums2
        for(int num : nums2)
        {
            // Current number is greater
            // than stack top
            while(top >= 0 && num > stack[top])
            {
                map.put(stack[top], num);
                top--;
            }

            // Push current number
            stack[++top] = num;
        }

        // Remaining elements have no greater element
        while(top >= 0)
        {
            map.put(stack[top], -1);
            top--;
        }

        // Create answer array
        int[] result = new int[nums1.length];

        for(int i = 0; i < nums1.length; i++)
        {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }
}