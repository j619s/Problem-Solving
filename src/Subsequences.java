public class Subsequences {
    //write a program to print all the subsequences of a string using recursion
    public static void printSubsequences(String input, String outputSoFar) {

        if (input.length() == 0) {
            if(outputSoFar.equalsIgnoreCase("")){
                System.out.println("{}");
            } else {
                System.out.println(outputSoFar);
            }

            return;
        }
        printSubsequences(input.substring(1), outputSoFar);
        printSubsequences(input.substring(1), outputSoFar + input.charAt(0));

    }


    public static void main(String[] args) {
        String input = "abc";
        printSubsequences(input, "");

    }
}
