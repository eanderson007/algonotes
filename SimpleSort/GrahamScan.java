package SimpleSort;

import java.awt.Point;
import java.util.Arrays;

public class Point2D {
    private final double x;
    private final double y;

    public Point(double x, double y)
    {
        this.x = x;
        this.y = y;
    }
    
    public static int ccw(Point a, Point b, Point c)
    {
        int area2 = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x); // danger of floating point round off error
        if (area2 < 0) return -1;  // clockwise
        else if (area2 > 0) return 1; // counter-clockwise
        else return 0; // collinear
    }
}

public class GrahamScan {
    public static void sort(Point2D[] a) {
        DataStructures.Stack<Point2D> hull = new DataStructures.Stack<Point2D>();
        int N = a.length;
        
        Arrays.sort(a, Point2D.Y_ORDER);
        Arrays.sort(a, a[0].BY_POLAR_ORDER);

        
        hull.push(a[0]);
        hull.push(a[1]);

        for (int i = 2; i < N; i++) {
            Point2D top = hull.pop();
            while (Point2D.ccw(hull.peek(), top, a[i]) <= 0) {
                top = hull.pop();
            }
            hull.push(top);
            hull.push(a[i]);
        }
    }
}
