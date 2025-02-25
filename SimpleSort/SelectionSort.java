public class SelectionSort 
/* Best Case: O(N^2)
*  Average Case: O(N^2)
*  Worst Case: O(N^2)
*  Explanation: Selection sort always performs N^2/2 comparisons 
*               and N exchanges, regardless of the initial order 
*               of the elements 
*/
{
    public static void sort(Comparable[] a)
    {
        int N = a.length;
        for (int i = 0; i < N; i++)
        {
            int min = i;
            for (int j = i+1; j < N; j++)
                if (less(a[j], a[min])) min = j;
            exch(a, i, min);
        }
    }

    private static boolean less(Comparable v, Comparable w)
    { return v.compareTo(w) < 0; }

    private static void exch(Comparable[] a, int i, int j)
    { Comparable t = a[i]; a[i] = a[j]; a[j] = t; }
    
}