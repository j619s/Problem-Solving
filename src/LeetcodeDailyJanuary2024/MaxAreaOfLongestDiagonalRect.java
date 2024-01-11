package LeetcodeDailyJanuary2024;

public class MaxAreaOfLongestDiagonalRect {

    public static void main(String[] args) {
        int[][] arr = {{25,60},{39,52},{16,63},{33,56}};
        System.out.println(areaOfMaxDiagonal(arr));
    }

    public static int areaOfMaxDiagonal(int[][] dimensions){
        double maxDiag = -1.0;
        int area = -1;
        for(int i = 0; i < dimensions.length; i++){
            int len = dimensions[i][0];
            int br = dimensions[i][1];

            double diag = Math.sqrt((len * len)+(br * br));
            if(maxDiag < diag){
                maxDiag = diag;
                area = len * br;
            } else if(maxDiag == diag){
                area = Math.max(area, len * br);
            }

        }

        return area;

    }
}
