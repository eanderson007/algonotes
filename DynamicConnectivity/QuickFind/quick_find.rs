pub struct QuickFind {
    id: Vec<usize>,
}

impl QuickFind {
    pub fn new(n: usize) -> Self {
        QuickFind {
            id: (0..n).collect(),
        }
    }

    pub fn connected(&self, p: usize, q: usize) -> bool {
        self.id[p] == self.id[q]
    }

    pub fn union(&mut self, p: usize, q: usize) {
        let pid = self.id[p];
        let qid = self.id[q];

        for i in 0..self.id.len() {
            if self.id[i] == pid {
                self.id[i] = qid;
            }
        }
    }
}

fn main() {
    let mut qf = QuickFind::new(10);
    qf.union(4, 3);
    qf.union(3, 8);
    println!("4 and 8 connected: {}", qf.connected(4, 8)); // true
    println!("4 and 9 connected: {}", qf.connected(4, 9)); // false
}