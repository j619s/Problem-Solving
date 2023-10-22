import java.util.function.BiFunction;
import java.util.function.Function;

public class Demo {
    public static void main(String[] args) {
        String str1 = null;
        String str2 = "123";
        if(!str2.equals(str1)){
            str2 = null;
        }

        str1 = str2;
        str2 = str1;

        System.out.println(str2);

        BiFunction<Integer, Integer, Boolean> isDivisible = (x,y) -> x % y == 0;
        System.out.println(isDivisible.apply(2,9));
        // it returns the length of a string,
        Function<String, Integer> f = s -> s.length();
        System.out.println(f.apply("hello"));
    }
}
