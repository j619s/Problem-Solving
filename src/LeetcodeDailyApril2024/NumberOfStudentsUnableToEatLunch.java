package LeetcodeDailyApril2024;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfStudentsUnableToEatLunch {
    public static void main(String[] args) {
        int[] students = {1,1,1,0,0,1};
        int[] sandwiches = {1,0,0,0,1,1};
        System.out.println(countStudents(students, sandwiches));
        System.out.println(countStudentsII(students, sandwiches));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        int sanPtr = 0;
        for(int i = 0; i < students.length; i++){
            if(students[i] == sandwiches[sanPtr]){
                sanPtr++;
            } else {
                q.add(students[i]);
            }
        }
        int count = 0;
        while(!q.isEmpty()){
            int stu = q.remove();
            if(stu == sandwiches[sanPtr]){
                sanPtr++;
                count = 0;
            } else {
                q.add(stu);
                count++;
            }

            if(count == q.size()){
                return count;
            }
        }

        return 0;

    }

    //Approach2: Using Counter.

    public static int countStudentsII(int[] students, int[] sandwiches) {
        int circleStudentCount = 0;
        int squareStudentCount = 0;

        for(int stu : students){
            if(stu == 0){
                circleStudentCount++;
            } else {
                squareStudentCount++;
            }
        }

        for(int san : sandwiches){

            // No student wants the circle sandwich on top of the stack
            if(san == 0 && circleStudentCount == 0){
                return squareStudentCount;
            }
            // No student wants the square sandwich on top of the stack
            if(san == 1 && squareStudentCount == 0){
                return circleStudentCount;
            }

            // Decrement the count of the served sandwich type
            if(san == 0){
                circleStudentCount--;
            } else {
                squareStudentCount--;
            }
        }

        // Every student received a sandwich
        return 0;

    }

}
