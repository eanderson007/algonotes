package SimpleSort;

public class Shell {
    /* Best Case: O(N log N)
     * Average Case: O(N^(3/2))
     * Worst Case: O(N^(3/2))
     * Explanation: The time complexity of Shell sort depends on 
     * the gap sequence used. Using the 3x+1 sequence (Knuth's 
     * sequence), the worst-case time complexity is O(N^(3/2)). 
     * The best case can be as good as O(N log N) for certain 
     * gap sequences.
     */
    public static void sort(Comparable[] a)
    {
        int N = a.length;

        int h = 1;
        while (h < N/3) h = 3*h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
        while (h >= 1)
        { // h-sort the array 
            for (int i = h; i < N; i++)
            {
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
                    exch(a, j, j-h);
            }
            h = h/3;
        }
    }

    private static boolean less(Comparable v, Comparable w)
    { return v.compareTo(w) < 0; }

    private static void exch(Comparable[] a, int i, int j)
    { Comparable t = a[i]; a[i] = a[j]; a[j] = t; }
    
}
