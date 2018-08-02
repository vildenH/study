package src.alg.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

//给定一些 points 和一个 origin，从 points 中找到 k 个离 origin 最近的点。
// 按照距离由小到大返回。如果两个点有相同距离，则按照x值来排序；若x值也相同，就再按照y值排序。
public class KClosest {
    /*
 * @param points: a list of points
 * @param origin: a point
 * @param k: An integer
 * @return: the k closest points
 */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here

        if (points == null) {
            return null;
        }
        if (k <= 0) {
            return null;
        }
        int[] num = new int[points.length];
        PriorityQueue<Point> priorityQueue = new PriorityQueue<Point>(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int aLength = (origin.x - o1.x) * (origin.x - o1.x) + (origin.y - o1.y) * (origin.y - o1.y);
                int bLength = (origin.x - o2.x) * (origin.x - o2.x) + (origin.y - o2.y) * (origin.y - o2.y);

                if (aLength == bLength) {
                    return 0;
                } else if (aLength > bLength) {
                    return -1;
                } else {
                    return 1;
                }
            }


        });
        for (int i = 0; i < points.length; i++) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(points[i]);
            } else {
                priorityQueue.add(points[i]);
                priorityQueue.poll();

            }
        }
        Point[] ans = new Point[k];
        for (int i = 0; i < k; i++) {
            ans[k - i - 1] = priorityQueue.poll();
        }
        return ans;
    }
}

class Point {

    int x;
    int y;

    Point() {
        x = 0;
        y = 0;
    }

    Point(int a, int b) {
        x = a;
        y = b;
    }
}
