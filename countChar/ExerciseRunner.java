public class ExerciseRunner {
    public static void main(String[] args) {
        // Basic usage
        System.out.println(CountChar.count("Hello World !", ' '));  // 2

        // Character not present
        System.out.println(CountChar.count("Hello", 'z'));           // 0

        // Character appears once
        System.out.println(CountChar.count("Hello", 'H'));           // 1

        // Character appears multiple times
        System.out.println(CountChar.count("Hello World", 'l'));     // 3

        // Empty string
        System.out.println(CountChar.count("", 'a'));                // 0

        // Single character string - match
        System.out.println(CountChar.count("a", 'a'));               // 1

        // Single character string - no match
        System.out.println(CountChar.count("a", 'b'));               // 0

        // All characters are the same and match
        System.out.println(CountChar.count("aaaa", 'a'));            // 4

        // Case sensitivity
        System.out.println(CountChar.count("Hello", 'h'));           // 0 (lowercase h)
        System.out.println(CountChar.count("Hello", 'H'));           // 1 (uppercase H)

        // Special characters
        System.out.println(CountChar.count("Hello World !", '!'));   // 1
        System.out.println(CountChar.count("a,b,c,d", ','));         // 3

        // Digits in string
        System.out.println(CountChar.count("abc123abc", '1'));       // 1
        System.out.println(CountChar.count("112233", '2'));          // 2

        // Whitespace variants
        System.out.println(CountChar.count("a\tb\tc", '\t'));        // 2
        System.out.println(CountChar.count("line1\nline2", '\n'));   // 1

        // Long string
        System.out.println(CountChar.count("aababababababababababab", 'b')); // 11
    }
}
// 2, 0, 1, 3, 0, 1, 0, 4, 0, 1, 1, 3, 1, 2, 2, 1, 10