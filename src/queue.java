import java.util.*;
public class queue {
    public static void main(String[] args) {
        List<String> urls = new ArrayList<>();
        urls.add("google");
        urls.add("yahoo");
        urls.add("google");
        urls.add("yahoo");
        urls.add("coursera");
        System.out.println(getMinTime(2, 2, 3, urls));
    }
    public static List<Integer> getMinTime(int cache_size, int cache_time, int server_time, List<String> urls) {

        List<Integer> list = new ArrayList<>();
        Queue<String> q = new LinkedList<>();

        for(String url : urls){

            if (q.contains(url)) {
                list.add(cache_time);
                q.remove(url); // Remove the URL from the cache
            } else {
                list.add(server_time);
            }

            q.add(url); // Add the URL to the cache

            if (q.size() > cache_size) {
                q.remove(); // Remove the oldest URL if cache size is exceeded
            }

        }

        return list;

    }
}
