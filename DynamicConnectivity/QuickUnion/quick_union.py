class QuickUnion:
    def __init__(self, n):
        self.id = [i for i in range(n)]
        self.sz = [1] * n # each group starts size 1 (only connected to self)

    def root(self, i):
        while i != self.id[i]:
            self.id[i] = self.id[self.id[i]]  # path compression
            i = self.id[i]
        return i
    
    def connected(self, p, q):
        return self.root(p) == self.root(q)
    
    def union(self, p, q):
        i = self.root(p)
        j = self.root(q)

        if i == j:
            return
        
        # Weighting: link root of smaller tree to root of larger tree
        if self.sz[i] < self.sz[j]:
            self.id[i] = j
            self.sz[j] += self.sz[i]
        else:
            self.id[j] = i
            self.sz[i] += self.sz[j]
