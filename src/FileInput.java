import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileInput {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\jatin\\Downloads\\test_input.txt"))) {
            String[] i1 = br.readLine().split(" ");
            String[] i2 = br.readLine().split(" ");
            String[] i3 = br.readLine().split(" ");

            int n = Integer.parseInt(i1[0]);
            int m = Integer.parseInt(i1[1]);
            int k = Integer.parseInt(i1[2]);

            ArrayList<Integer> client = new ArrayList<>();
            for(int i = 0; i < n; i++){
                client.add(Integer.parseInt(i2[i]));
            }

            ArrayList<Integer> apartmentSize = new ArrayList<>();
            for(int i = 0; i < m; i++){
                apartmentSize.add(Integer.parseInt(i3[i]));
            }

            Collections.sort(client);
            Collections.sort(apartmentSize);
            int i = 0, j = 0, answer = 0;
            while (i < n && j < m) {
                int clientSize = client.get(i);
                int apartment = apartmentSize.get(j);

                if (Math.abs(clientSize - apartment) <= k) {
                    answer++;
                    i++;
                    j++;
                } else if (clientSize < apartment) {
                    i++;
                } else {
                    j++;
                }
            }

            System.out.println(answer);


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
