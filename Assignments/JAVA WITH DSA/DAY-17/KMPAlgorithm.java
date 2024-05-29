/*Implementing the KMP algorithm in code  the KMP algorithm in java for pattern searching which pre-processes the pattern to reduce the number of comparisions explain  how this processing improves the search time compare to the naive approach

The Knuth-Morris-Pratt (KMP) algorithm improves the efficiency of pattern searching by preprocessing the pattern to create a Longest Prefix Suffix (LPS) array. This preprocessing step allows the KMP algorithm to reduce the number of comparisons during the search phase, significantly improving search time compared to the naive approach.

Comparison with Naive Approach
In the naive approach, for each position in the text, we compare the pattern with the substring of the text starting at that position. If there is a mismatch, we shift the pattern one position to the right and start the comparison again. This can lead to many unnecessary comparisons, especially when the pattern contains repeated sub-patterns.

The KMP algorithm addresses this inefficiency by using the LPS array. The LPS array stores the lengths of the longest proper prefix of the pattern that is also a suffix. This information is used to skip unnecessary comparisons by aligning the pattern with the text in a more informed manner.

How KMP Improves Search Time
Preprocessing Step:

The LPS array is computed in O(M) time, where M is the length of the pattern.
This array helps to avoid re-evaluating characters of the text that have already been matched with parts of the pattern.
Search Step:

During the search, if a mismatch occurs, the LPS array tells us the next positions to match without re-examining characters that are known to match.
This results in the search phase also running in O(N) time, where N is the length of the text.
Overall, the KMP algorithm ensures that the total time complexity for searching is O(N + M), which is much more efficient than the worst-case O(N * M) time complexity of the naive approach.

Java Implementation
Here is the complete Java implementation of the KMP algorithm with explanations:*/


public class KMPAlgorithm {

    // Function to create the LPS array
    private static int[] computeLPSArray(String pattern) {
        int M = pattern.length();
        int[] lps = new int[M];
        int length = 0;  // length of the previous longest prefix suffix
        int i = 1;

        lps[0] = 0;  // lps[0] is always 0

        // Loop calculates lps[i] for i = 1 to M-1
        while (i < M) {
            if (pattern.charAt(i) == pattern.charAt(length)) {
                length++;
                lps[i] = length;
                i++;
            } else {  // (pattern[i] != pattern[length])
                if (length != 0) {
                    length = lps[length - 1];
                } else {  // if (length == 0)
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // Function to perform KMP search
    public static void KMPSearch(String text, String pattern) {
        int N = text.length();
        int M = pattern.length();

        // Create LPS array
        int[] lps = computeLPSArray(pattern);

        int i = 0;  // index for text
        int j = 0;  // index for pattern

        while (i < N) {
            if (pattern.charAt(j) == text.charAt(i)) {
                i++;
                j++;
            }

            if (j == M) {
                System.out.println("Found pattern at index " + (i - j));
                j = lps[j - 1];
            } else if (i < N && pattern.charAt(j) != text.charAt(i)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        String text = "ABABDABACDABABCABAB";
        String pattern = "ABABCABAB";

        KMPSearch(text, pattern);
    }
}
/*
Explanation of the Code
computeLPSArray:

This method creates the LPS array for the given pattern.
It initializes the length to 0 and starts from the second character of the pattern.
It iterates through the pattern and updates the lps array based on the longest proper prefix which is also a suffix.
KMPSearch:

This method searches for the pattern in the text using the precomputed LPS array.
It iterates through the text and pattern characters.
When a mismatch occurs, it uses the LPS array to skip unnecessary comparisons and continues the search.
How KMP Reduces Comparisons
Naive Approach: After every mismatch, the pattern is shifted by one position, leading to potentially re-evaluating characters multiple times.
KMP Algorithm: After a mismatch, the pattern is shifted based on the information in the LPS array, which ensures that already matched characters are not re-evaluated.
By skipping unnecessary comparisons and leveraging the precomputed LPS array, the KMP algorithm achieves linear time complexity, making it significantly more efficient than the naive approach for pattern searching in strings.
*/







