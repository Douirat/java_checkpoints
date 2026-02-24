public class ExerciseRunner {
    public static void main(String[] args) {

        // Basic usage
        System.out.println(Strlen.strlen("Hello World !"));   // 13

        // Empty string
        System.out.println(Strlen.strlen(""));                // 0

        // Single character
        System.out.println(Strlen.strlen("a"));               // 1

        // Spaces only
        System.out.println(Strlen.strlen("   "));             // 3

        // Digits
        System.out.println(Strlen.strlen("12345"));           // 5

        // Special characters
        System.out.println(Strlen.strlen("!@#$%"));           // 5

        // Newline and tab (each counts as 1 char)
        System.out.println(Strlen.strlen("\n\t"));            // 2

        // Null character
        System.out.println(Strlen.strlen("\0"));              // 1

        // Very long string
        System.out.println(Strlen.strlen("a".repeat(1000)));  // 1000

        // --- Edge / Invalid input ---

        // Null string — will throw NullPointerException if not handled
        // System.out.println(Strlen.strlen(null));           // depends on impl

        // Unicode accented characters (each is 1 char in Java)
        System.out.println(Strlen.strlen("café"));            // 4

        // Chinese characters
        System.out.println(Strlen.strlen("日本語"));           // 3

        // Emoji — surrogate pairs, Java counts them as 2 chars each
        System.out.println(Strlen.strlen("😀😂🔥"));          // 6 (not 3!)

        // Mixed ASCII + Unicode
        System.out.println(Strlen.strlen("Hello 日本!"));     // 8
    }
}


// **Expected output:**
// 13
// 0
// 1
// 3
// 5
// 5
// 2
// 1
// 1000
// 4
// 3
// 6
// 8