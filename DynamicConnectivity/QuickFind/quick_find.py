class QuickFind:
    def __init__(self, N):
        # Initialize the id array where each element is its own root.
        # This means initially each element is in its own component.
        self.id = [i for i in range(N)]

    def connected(self, p, q):
        # Check if two elements are in the same component.
        # If they have the same id, they are connected.
        return self.id[p] == self.id[q]

    def union(self, p, q):
        # Connect two elements p and q.
        # To do this, change all entries with id[p] to id[q].
        pid = self.id[p]
        qid = self.id[q]
        for i in range(len(self.id)):
            if self.id[i] == pid:
                self.id[i] = qid

if __name__ == '__main__':

    # Create a QuickFind object with 10 elements.
    qf = QuickFind(10)

    # Connect elements 4 and 3.
    qf.union(4, 3)

    # Connect elements 3 and 8.
    qf.union(3, 8)

    # Connect elements 6 and 5.
    qf.union(6, 5)

    # Connect elements 9 and 4.
    qf.union(9, 4)

    print(qf.id)

    # Check if elements 8 and 9 are connected.
    print(qf.connected(8, 9))  # True

    # Check if elements 5 and 4 are connected.
    print(qf.connected(5, 4))  # False

    # Connect elements 5 and 0.
    qf.union(5, 0)

    # Connect elements 7 and 2.
    qf.union(7, 2)

    # Connect elements 6 and 1.
    qf.union(6, 1)

    # Check if elements 1 and 0 are connected.
    print(qf.connected(1, 0))  # False

    # Connect elements 7 and 3.
    qf.union(7, 3)

    # Check if elements 1 and 0 are connected.
    print(qf.connected(1, 0))  # True

    # Check if elements 2 and 7 are connected.
    print(qf.connected(2, 7))  # True

    # Check if elements 6 and 7 are connected.
    print(qf.connected(6, 7))  # True

    # Check if elements 8 and 4 are connected.
    print(qf.connected(8, 4))  # True

    # Check if elements 9 and 4 are connected.
    print(qf.connected(9, 4))  # True

    # Check if elements 5 and 4 are connected.
    print(qf.connected(5, 4))  # True