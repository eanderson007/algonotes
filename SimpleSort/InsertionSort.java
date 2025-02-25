package SimpleSort;

public class InsertionSort {
    /* Best Case: O(N)
     * Average Case: O(N^2)
     * Worst Case: O(N^2)
     * Explanation: Insertion sort performs well on nearly sorted data. 
     * In the best case (already sorted array), it performs N-1 comparisons 
     * and 0 exchanges. In the average and worst cases, 
     * it performs N^2/4 comparisons and N^2/4 exchanges.
     */
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for (int i = 1; i < N; i++)
        {
            for (int j = i; j > 0; j--)
            if (less(a[j], a[j-1]))
                exch(a, j, j-1);
            else
                break;
        }
    }

    private static boolean less(Comparable v, Comparable w)
    { return v.compareTo(w) < 0; }

    private static void exch(Comparable[] a, int i, int j)
    { Comparable t = a[i]; a[i] = a[j]; a[j] = t; }

}
