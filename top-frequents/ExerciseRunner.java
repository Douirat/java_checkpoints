import java.util.*;

public class ExerciseRunner {
    static int passed = 0;
    static int failed = 0;

    public static void main(String[] args) {
        TopFrequents tf = new TopFrequents();

        // ── 1. Standard cases from spec ──────────────────────────────────────
        test("1  - [1,1,1,2,2,3]          k=2  → [1,2]",        List.of(1,2),       tf.findTopKFrequent(new int[]{1,1,1,2,2,3}, 2));
        test("2  - [1]                    k=1  → [1]",           List.of(1),         tf.findTopKFrequent(new int[]{1}, 1));
        test("3  - [4,1,-1,2,-1,2,3,3]   k=2  → [-1,2]",        List.of(-1,2),      tf.findTopKFrequent(new int[]{4,1,-1,2,-1,2,3,3}, 2));
        test("4  - [4,1,-1,2,-1,2,3]     k=10 → [-1,2,4,1,3]",  List.of(-1,2,4,1,3),tf.findTopKFrequent(new int[]{4,1,-1,2,-1,2,3}, 10));

        // ── 2. k=1 (only the single most frequent) ───────────────────────────
        test("5  - [3,3,1,1,1,2]          k=1  → [1]",           List.of(1),         tf.findTopKFrequent(new int[]{3,3,1,1,1,2}, 1));

        // ── 3. k equals number of distinct elements ───────────────────────────
        test("6  - [1,2,3]                k=3  → [1,2,3]",       List.of(1,2,3),     tf.findTopKFrequent(new int[]{1,2,3}, 3));

        // ── 4. All elements identical ─────────────────────────────────────────
        test("7  - [5,5,5,5]              k=1  → [5]",            List.of(5),         tf.findTopKFrequent(new int[]{5,5,5,5}, 1));

        // ── 5. Tie-breaking by first appearance ───────────────────────────────
        // 2 appears first, 7 appears second — both freq=2, so 2 before 7
        test("8  - [2,2,7,7,9]            k=2  → [2,7]",          List.of(2,7),       tf.findTopKFrequent(new int[]{2,2,7,7,9}, 2));
        // 7 appears first here
        test("9  - [7,7,2,2,9]            k=2  → [7,2]",          List.of(7,2),       tf.findTopKFrequent(new int[]{7,7,2,2,9}, 2));

        // ── 6. Negative numbers ───────────────────────────────────────────────
        test("10 - [-1,-1,-2,-2,-3]       k=1  → [-1]",           List.of(-1),        tf.findTopKFrequent(new int[]{-1,-1,-2,-2,-3}, 1));

        // ── 7. Mix of negative and positive ──────────────────────────────────
        test("11 - [-1,1,-1,1,-1]         k=1  → [-1]",           List.of(-1),        tf.findTopKFrequent(new int[]{-1,1,-1,1,-1}, 1));
        test("12 - [-1,1,-1,1,-1]         k=2  → [-1,1]",         List.of(-1,1),      tf.findTopKFrequent(new int[]{-1,1,-1,1,-1}, 2));

        // ── 8. k > distinct count (return all) ───────────────────────────────
        test("13 - [1,2]                  k=5  → [1,2]",           List.of(1,2),       tf.findTopKFrequent(new int[]{1,2}, 5));

        // ── 9. Large frequency gap ────────────────────────────────────────────
        test("14 - [1,1,1,1,1,2,2,3]      k=2  → [1,2]",          List.of(1,2),       tf.findTopKFrequent(new int[]{1,1,1,1,1,2,2,3}, 2));

        // ── 10. Three-way tie, order by first seen ────────────────────────────
        // a=3, b=5, c=9 all appear once — first seen order: 3,5,9
        test("15 - [3,5,9]                k=3  → [3,5,9]",         List.of(3,5,9),     tf.findTopKFrequent(new int[]{3,5,9}, 3));

        // ── 11. Zero in array ─────────────────────────────────────────────────
        test("16 - [0,0,1,1,1]            k=1  → [1]",             List.of(1),         tf.findTopKFrequent(new int[]{0,0,1,1,1}, 1));
        test("17 - [0,0,1,1,1]            k=2  → [1,0]",           List.of(1,0),       tf.findTopKFrequent(new int[]{0,0,1,1,1}, 2));

        // ── 12. Single element, k=1 ───────────────────────────────────────────
        test("18 - [42]                   k=1  → [42]",             List.of(42),        tf.findTopKFrequent(new int[]{42}, 1));

        // ── 13. Frequency ordering over value ordering ────────────────────────
        // 9 appears 3x, 1 appears 2x, 5 appears 1x — should NOT sort by value
        test("19 - [9,9,9,1,1,5]          k=2  → [9,1]",            List.of(9,1),       tf.findTopKFrequent(new int[]{9,9,9,1,1,5}, 2));

        // ── 14. Longer tie-break chain ────────────────────────────────────────
        // 10,20,30,40 all freq=1; first-seen order must be preserved
        test("20 - [10,20,30,40]          k=3  → [10,20,30]",       List.of(10,20,30),  tf.findTopKFrequent(new int[]{10,20,30,40}, 3));

        // ── Summary ───────────────────────────────────────────────────────────
        System.out.println("\n──────────────────────────────────────");
        System.out.println("Results: " + passed + " passed, " + failed + " failed out of " + (passed + failed) + " tests.");
        System.out.println("\nTime complexity: O(n log n) — O(n) build map, O(n log n) heapify, O(k log n) poll");
    }

    static void test(String name, List<Integer> expected, List<Integer> actual) {
        boolean ok = expected.equals(actual);
        if (ok) passed++; else failed++;
        System.out.printf("[%s] Test %-55s | expected=%-15s got=%s%n",
            ok ? "PASS" : "FAIL", name, expected, actual);
    }
}