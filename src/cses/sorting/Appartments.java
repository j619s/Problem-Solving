package cses.sorting;

import java.util.Arrays;
import java.util.Scanner;

/*
* There are n applicants and m free apartments. Your task is to distribute the apartments so that as many applicants as possible will get an apartment.

Each applicant has a desired apartment size, and they will accept any apartment whose size is close enough to the desired size.

Input

The first input line has three integers n, m, and k: the number of applicants, the number of apartments, and the maximum allowed difference.

The next line contains n integers a1,a2,…,an: the desired apartment size of each applicant. If the desired size of an applicant is x, he or she will accept any apartment whose size is between x−k and x+k.

The last line contains m integers b1,b2,…,bm: the size of each apartment.

Output

Print one integer: the number of applicants who will get an apartment.

Constraints

    1≤n,m≤2⋅105


0≤k≤109

1≤ai,bi≤109


Example

Input:
4 3 5
60 45 80 60
30 60 75

Output:
2
*
* */
public class Appartments {
    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);

        //applicants

        int n = sc.nextInt();

        //apartments

        int m = sc.nextInt();
        // maximum allowed difference

        int k = sc.nextInt();
        int[] desiredApartmentSize = new int[n];

        for(int i = 0; i < n; i++){
            desiredApartmentSize[i] = sc.nextInt();
        }

        int[] apartmentSize = new int[m];

        for(int i = 0; i < m; i++){
            apartmentSize[i] = sc.nextInt();
        }

        Arrays.sort(desiredApartmentSize);
        Arrays.sort(apartmentSize);

        //int j = 0, answer = 0;
//        for(int i = 0; i < n; i++){
//            int apartment = desiredApartmentSize[i];
//            while(j < m){
//                if(apartmentSize[j] + k < apartment){
//                    j++;
//                } else if(apartmentSize[j] - k > apartment){
//                    break;
//                } else {
//                    j++;
//                    answer++;
//                    break;
//
//                }
//            }
//        }

        int i = 0, j = 0, answer = 0;

        while(i < n && j < m){
            int clientSize = desiredApartmentSize[i];
            int apartment = apartmentSize[j];

            if(Math.abs(clientSize - apartment) <= k){
                answer++;
                i++;
                j++;
            } else if(clientSize < apartment){
                i++;
            } else {
                j++;
            }
        }



        System.out.println(answer);


    }
/*
*  45 60 60 80
*  30 60 75
*
*
* */

}
