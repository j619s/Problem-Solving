public class TrappingRainWater {
    //It can also be solved using stack.
    
    public static void main(String[] args) {
        int[] arr = {4,2,0,3,2,5};
        int water = getWater(arr, arr.length);
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
}
