public class Strlen {
    public static int strlen(String s) {
        return s == null ? 0 : s.codePointCount(0, s.length());
    }
}