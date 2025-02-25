public class QuickUnionUF {
    private int[] id;

    public QuickUnionUF(int N)
    {
        id = new int[N];
        for (int i = 0; i < N; i++) id[i] = i;
    }

    private int root(int i)
    {
        while (i != id[i]) i = id[i];
        return i;
    }

    public boolean connected(int p, int q)
    {
        return root(p) == root(q);
    }

    public void union(int p, int q)
    {
        int i = root(p);
        int j = root(q);
        id[i] = j;
    }

    /* Another option to keep tree almost flat (improve performance). Union + connected 
    would then call this version of the function */
    private int root_path_compression(int i)
    {   
        while (i != id[i])
        {
            id[i] = id[id[i]]; // update el to point to grandparent. flatten tree while search root
            i = id[i];
        }
        return i;
    }
}