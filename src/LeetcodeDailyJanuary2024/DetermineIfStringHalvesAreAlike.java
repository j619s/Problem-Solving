package LeetcodeDailyJanuary2024;

public class DetermineIfStringHalvesAreAlike {
    public static void main(String[] args) {
        System.out.println(halvesAreAlike("Uaec"));
    }

    static boolean halvesAreAlike(String s){
        int i = 0;
        int j = s.length() - 1;
        int vowels = 0;
        while(i < s.length() / 2 && j >= s.length() / 2){
            char ch = s.charAt(i);
            if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u'
                    ||ch =='A' || ch == 'E' || ch =='I' || ch == 'O' || ch == 'U'){
                vowels++;
            }
            i++;

            char ch2 = s.charAt(j);
            if(ch2 == 'a' || ch2 == 'e' || ch2 == 'i' || ch2 == 'o' || ch2 == 'u'
                    ||ch2 =='A' || ch2 == 'E' || ch2 =='I' || ch2 == 'O' || ch2 == 'U'){
                vowels--;
            }
            j--;
        }

        return vowels == 0 ? true : false;
    }
}
