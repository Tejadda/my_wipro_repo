/*use the boyer-moore algorithm to write a function that finds the last occurence of a substring in a given string and returns its index explain y this algorithm can outperform others in certain scenarios in java without exceptions
*/
package com.DAY_17;
public class BoyerMoore {
    private final int R;  // Radix
    private int[] right;  // the bad-character skip array
    private String pat;   // the pattern string

    public BoyerMoore(String pat) {
        this.R = 256;  // Assuming ASCII character set
        this.pat = pat;
        
        // position of rightmost occurrence of c in the pattern
        right = new int[R];
        for (int c = 0; c < R; c++) {
            right[c] = -1;  // -1 for characters not in pattern
        }
        for (int j = 0; j < pat.length(); j++) {
            right[pat.charAt(j)] = j;
        }
    }

    public int search(String txt) {
        int M = pat.length();
        int N = txt.length();
        int skip;

        // Start searching from the end of the text
        for (int i = N - M; i >= 0; i -= skip) {
            skip = 0;
            for (int j = M - 1; j >= 0; j--) {
                if (pat.charAt(j) != txt.charAt(i + j)) {
                    skip = Math.max(1, j - right[txt.charAt(i + j)]);
                    break;
                }
            }
            if (skip == 0) return i;  // found
        }
        return -1;  // not found
    }

    public static void main(String[] args) {
        BoyerMoore bm = new BoyerMoore("pattern");
        String text = "text where the pattern appears last";
        int index = bm.search(text);
        System.out.println("Last occurrence index: " + index);
    }
}

/*Explanation of Boyer-Moore Algorithm
The Boyer-Moore algorithm uses two main heuristics to improve the efficiency of the search:

Bad Character Heuristic: When a mismatch occurs, this heuristic determines how far the pattern can be shifted based on the character in the text that caused the mismatch.
Good Suffix Heuristic: This heuristic is not used in the provided code but can be implemented to further improve performance. It shifts the pattern to align with the last occurrence of a suffix that matches a suffix in the pattern.
Why Boyer-Moore Can Outperform Other Algorithms
Skipping Sections of Text: Boyer-Moore can skip large sections of text rather than checking every character. This is particularly useful for long patterns or texts.
Efficient in Practice: While the worst-case complexity is O(M.N), whereM is the length of the pattern and N is the length of the text, its average-case performance is often sub-linear, making it very efficient for typical use cases.
Character Comparisons from Right to Left: By starting comparisons from the end of the pattern, mismatches are often found earlier, reducing the number of comparisons needed.
In conclusion, the Boyer-Moore algorithm can significantly outperform other string search algorithms in many scenarios, especially when dealing with large texts and patterns. The given Java implementation searches for the last occurrence of a pattern in a text using this efficient approach*/