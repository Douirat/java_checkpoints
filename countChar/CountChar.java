public class CountChar {
    public static int count(String s, char c) {
        int count = 0;
        for (char cr: s.toCharArray()){
            if (c == cr) {
                count += 1;
            }
        }
        return count;
    }
}