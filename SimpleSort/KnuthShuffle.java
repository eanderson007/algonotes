package SimpleSort;

public class KnuthShuffle {

    public static void shuffle(Object[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            int r = (int) (Math.random() * (i + 1));
            exch(a, i, r);
        }
    }

    private static void exch(Object[] a, int i, int j) {
        Object swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
}
