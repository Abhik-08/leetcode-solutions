public class Solution
{
    public int[] asteroidCollision(int[] asteroids)
    {
        int n = asteroids.length;

        // Using normal array as stack
        int[] stack = new int[n];

        int top = -1;

        for(int asteroid : asteroids)
        {
            boolean destroyed = false;

            // Collision condition
            while(top >= 0 && stack[top] > 0 && asteroid < 0)
            {
                // Top asteroid smaller
                if(stack[top] < -asteroid)
                {
                    top--;
                    continue;
                }

                // Both equal
                else if(stack[top] == -asteroid)
                {
                    top--;
                }

                // Current asteroid destroyed
                destroyed = true;
                break;
            }

            // If survives, push into stack
            if(!destroyed)
            {
                stack[++top] = asteroid;
            }
        }

        // Create answer array
        int[] result = new int[top + 1];

        for(int i = 0; i <= top; i++)
        {
            result[i] = stack[i];
        }

        return result;
    }
}