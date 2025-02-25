package SimpleSort;
public class DijkstraTwoStack {
    public static void main(String[] args) {
        DataStructures.Stack<String> ops = new DataStructures.Stack<String>();
        DataStructures.Stack<Double> vals = new DataStructures.Stack<Double>();

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();

            if (s.equals("(")) ;
            else if (s.equals("+")) ops.push(s);
            else if (s.equals("-")) ops.push(s);
            else if (s.equals("*")) ops.push(s);
            else if (s.equals("/")) ops.push(s);
            else if (s.equals("sqrt")) ops.push(s);

            else if (s.equals(")")) {
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) v = vals.pop() + v;
                else if (op.equals("-")) v = vals.pop() - v;
                else if (op.equals("*")) v = vals.pop() * v;
                else if (op.equals("/")) v = vals.pop() / v;
                else if (op.equals("sqrt")) v = Math.sqrt(v);
                vals.push(v);
            } 
            
            else vals.push(Double.parseDouble(s));
        }
        StdOut.println(vals.pop());
    }
}
