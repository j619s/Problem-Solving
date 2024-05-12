import java.util.ArrayDeque;

public class TrappingRainWater {
    //It can also be solved using stack.
    
    public static void main(String[] args) {
        int[] arr = {4,2,0,3,2,5};
        //int water = getWater(arr, arr.length);
        int water = trap(arr);
        System.out.println(water);
    }

    static int getWater(int[] height, int n){
        int quantity = 0;

        int[] leftMax = new int[n];
        leftMax[0] = height[0];

        int[] rightMax = new int[n];
        rightMax[n - 1] = height[n - 1];

        //storing the leftMax of every element in the array

        for(int i = 1; i < n; i++){
            leftMax[i] = Math.max(height[i], leftMax[i - 1]);
        }

        for(int i = n - 2; i >= 0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i + 1]);
        }
//        System.out.println(Arrays.toString(leftMax));
//        System.out.println(Arrays.toString(rightMax));
        // at every index it will store water -> leftWall - rightWall - current wall.

        for(int i = 0; i < n - 1; i++){
            quantity += Math.min(rightMax[i], leftMax[i]) - height[i];
        }

        return quantity;
    }

    // Approach 2: monotonic stack.

    public static int trap(int[] height){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int trapped = 0;

        for(int i = 0; i < height.length; i++){

            while(!stack.isEmpty() && height[stack.peek()] < height[i]){
                int top = height[stack.peek()];
                stack.pop();
                if(stack.isEmpty()) break;

                int width = i - stack.peek() - 1;
                int length = Math.min(height[i], height[stack.peek()]) - top;

                trapped += length * width;
            }

            stack.push(i);
        }

        return trapped;
    }
}
