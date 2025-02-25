#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int *id;
    int count;
} QuickFindUF;

QuickFindUF* QuickFindUF_create(int n) {
    QuickFindUF *uf = (QuickFindUF *)malloc(sizeof(QuickFindUF));
    uf->id = (int *)malloc(n * sizeof(int));
    uf->count = n;
    for (int i = 0; i < n; i++) {
        uf->id[i] = i;
    }
    return uf;
}

void QuickFindUF_union(QuickFindUF *uf, int p, int q) {
    int pid = uf->id[p];
    int qid = uf->id[q];
    if (pid == qid) return;

    for (int i = 0; i < uf->count; i++) {
        if (uf->id[i] == pid) {
            uf->id[i] = qid;
        }
    }
}

int QuickFindUF_connected(QuickFindUF *uf, int p, int q) {
    return uf->id[p] == uf->id[q];
}

void QuickFindUF_free(QuickFindUF *uf) {
    free(uf->id);
    free(uf);
}

int main() {
    int n = 10;
    QuickFindUF *uf = QuickFindUF_create(n);

    QuickFindUF_union(uf, 4, 3);
    QuickFindUF_union(uf, 3, 8);
    QuickFindUF_union(uf, 6, 5);
    QuickFindUF_union(uf, 9, 4);
    QuickFindUF_union(uf, 2, 1);

    printf("Connected(8, 9): %d\n", QuickFindUF_connected(uf, 8, 9));
    printf("Connected(5, 4): %d\n", QuickFindUF_connected(uf, 5, 4));

    QuickFindUF_free(uf);
    return 0;
}