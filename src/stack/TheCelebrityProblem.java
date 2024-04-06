package stack;

import java.util.ArrayDeque;

public class TheCelebrityProblem {
    public static void main(String[] args) {
        //int[][] M = {{0,1,0}, {0,0,0}, {0,1,0}};
        //int n = 3;
        int[][] M = {{0,1}, {1,0}};
        int n = 2;
        System.out.println(celebrity(M, n));
    }

    public static int celebrity(int[][] M, int n){
        int possibleCelebrity = -1;
        boolean possibleCeleb = true;
        for(int i = 0; i < n; i++){
            possibleCeleb = true;
            for(int j = 0; j < n; j++){
                if(i != j && M[i][j] != 0){
                    possibleCeleb = false;
                    break;
                }
            }
            if(possibleCeleb){
                possibleCelebrity = i;
            }
        }

        if(possibleCelebrity == -1){
            return possibleCelebrity;
        } else {
            for(int i = 0; i < n; i++){
                if (i != possibleCelebrity && M[i][possibleCelebrity] != 1) {
                    possibleCelebrity = -1;
                    break;
                }
            }

            return possibleCelebrity;
        }

    }

    public static int celebrityII(int[][] M, int n){
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        // put all the persons in stack
        for(int i = 0; i < M.length; i++){
            stack.push(i);
        }
        // Now check which of them is a potential celebrity

        while(stack.size() >= 2) {
            int person1 = stack.pop();
            int person2 = stack.pop();

            if(M[person1][person2] == 1){
                // person1 knows person2 -> person1 is not a celebrity

                stack.push(person2);
            } else {
                // person1 does not know person2 -> person1 is a celebrity
                stack.push(person1);
            }
        }

        // Now we will take a potential celebrity and check if that person is really celebrity
        int celeb = stack.pop();

        for(int i = 0; i < M.length; i++){
            if(i != celeb) {
                if(M[i][celeb] == 0 || M[celeb][i] == 1){
                    return -1;
                }
            }
        }

        return celeb;
    }

    public static int celebrityIII(int[][] M, int n){
        // We can use two pointers here.
        //The idea is to use two pointers, one from start and one from the end.
        // Assume the start person is A, and the end person is B.
        // If A knows B, then A must not be the celebrity.
        // Else, B must not be the celebrity. At the end of the loop, only one index will be left as a celebrity.
        // Go through each person again and check whether this is the celebrity.

        // The Two Pointer approach can be used where two pointers can be assigned,
        // one at the start and the other at the end,
        // and the elements can be compared and the search space can be reduced.

        int personA = 0;
        int pernonB = n - 1;

        while(personA < pernonB){
            if(M[personA][pernonB] == 1){
                personA++;
            } else {
                pernonB--;
            }
        }
        int possibleCelebrity = personA;
        for(int i = 0; i < n; i++){
            // to check is the possible celebrity knows the i-th person then it is not a celebrity.
            // also, if i-th person doesn't know the possible celebrity . Then, also it is not a celebrity.
            if(i != possibleCelebrity && (M[possibleCelebrity][i] == 1 || M[i][possibleCelebrity] == 0)){
                possibleCelebrity = -1;
            }
        }

        return possibleCelebrity;
    }
}
