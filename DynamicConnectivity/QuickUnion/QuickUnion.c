#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int *id;
    int *sz;
    int count;
} QuickUnion;

QuickUnion* QuickUnion_create(int n) {
    QuickUnion *uf = (QuickUnion *)malloc(sizeof(QuickUnion));
    uf->id = (int *)malloc(n * sizeof(int));
    uf->sz = (int *)malloc(n * sizeof(int));
    uf->count = n;

    for (int i = 0; i < n; i++) {
        uf->id[i] = i;
        uf->sz[i] = 1;
    }
    return uf;
}

int QuickUnion_root(QuickUnion *uf, int i) {
    while (i != uf->id[i]) {
        uf->id[i] = uf->id[uf->id[i]]; // path compression
        i = uf->id[i];
    }
    return i;
}

int QuickUnion_connected(QuickUnion *uf, int p, int q) {
    return QuickUnion_root(uf, p) == QuickUnion_root(uf, q);
}

void QuickUnion_union(QuickUnion *uf, int p, int q) {
    int rootP = QuickUnion_root(uf, p);
    int rootQ = QuickUnion_root(uf, q);

    if (rootP == rootQ) return;
        
    // Weighting: link root of smaller tree to root of larger tree
    if (uf->sz[rootP] < uf->sz[rootQ]) {
        uf->id[rootP] = rootQ;
        uf->sz[rootQ] += uf->sz[rootP];
        }
    else {
        uf->id[rootQ] = rootP;
        uf->sz[rootP] += uf->sz[rootQ];
        }
}

void QuickUnion_free(QuickUnion *uf) {
    free(uf->id);
    free(uf->sz);
    free(uf);
}