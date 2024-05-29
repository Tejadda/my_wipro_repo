 /*Rabin karp substring search 
Implement the Rabin-Karp algorithm for substring search using a rolling hash Discuss the impact of hash collisions of the algorithm's performance and how to handle them in java*/
package com.DAY_17;
import java.util.*;

public class RabinKarp {
    private static final int d = 256; // Number of characters in the input alphabet
    private static final int q = 101; // A prime number

    public static List<Integer> search(String pattern, String text) {
        int M = pattern.length();
        int N = text.length();
        int i, j;
        int p = 0; // Hash value for pattern
        int t = 0; // Hash value for text
        int h = 1;
        List<Integer> result = new ArrayList<>();

        // The value of h would be "pow(d, M-1)%q"
        for (i = 0; i < M - 1; i++)
            h = (h * d) % q;

        // Calculate the hash value of pattern and first window of text
        for (i = 0; i < M; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        // Slide the pattern over text one by one
        for (i = 0; i <= N - M; i++) {

            // Check the hash values of current window of text and pattern.
            // If the hash values match then only check for characters one by one
            if (p == t) {
                /* Check for characters one by one */
                for (j = 0; j < M; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j))
                        break;
                }

                // if p == t and pattern[0...M-1] = text[i, i+1, ...i+M-1]
                if (j == M)
                    result.add(i);
            }

            // Calculate hash value for next window of text: Remove leading digit,
            // add trailing digit
            if (i < N - M) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + 1)) % q;

                // We might get negative value of t, converting it to positive
                if (t < 0)
                    t = (t + q);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String text = "GEEKS FOR GEEKS";
        String pattern = "GEEK";
        List<Integer> result = search(pattern, text);
        System.out.println("Pattern found at indices: " + result);
    }
}
