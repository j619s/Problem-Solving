package LeetcodeDailyJuly2024;

import java.util.Arrays;
import java.util.Stack;

public class AsteroidCollision {
    public static void main(String[] args) {
        int[] asteroids = {-2,-2,1,-2};
        System.out.println(Arrays.toString(asteroidCollision(asteroids)));
    }

    public static int[] asteroidCollision(int[] asteroids) {
        int len = asteroids.length;
        Stack<Integer> stack = new Stack<>();

        for(int i = 0; i < len; i++){
            if(asteroids[i] > 0){
                stack.push(i);
            } else {
                while(!stack.isEmpty() && Math.abs(asteroids[i]) > 0){
                    int top = stack.pop();
                    if(asteroids[top] > -asteroids[i]){
                        asteroids[i] = 0;
                        stack.push(top);
                    } else if(asteroids[top] == -asteroids[i]){
                        asteroids[top] = 0;
                        asteroids[i] = 0;
                    } else {
                        asteroids[top] = 0;
                    }
                }

            }
        }
        int count = 0;
        for (int asteroid : asteroids) {
            if (asteroid != 0) {
                count++;
            }
        }
        int[] res = new int[count];
        int idx = 0;
        for (int asteroid : asteroids) {
            if (asteroid != 0) {
                res[idx++] = asteroid;
            }
        }
        return res;

    }
}
