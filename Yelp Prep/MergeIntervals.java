// Time Complexity: O(n log n) - because of sorting. Otherwise, just iterate through the list which is linear time
// Space Complexity: O(1) or O(n): If we can sort intervals in place, we do not need more than constant additional space.
// Otherwise, we must allocate linear space to store a copy of intervals and sort that.

import java.util.*;

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }
    
    Interval(int s, int e) {
        start = s;
        end = e;
    }

    public String toString() {
        return "[" + start + ", " + end + "]";
    }
}

class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval a, Interval b) {
        return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
    }
}

public class MergeIntervals {

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());
        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            } else {
                // otherwise, there is overlap, so we merge the current and previous
                // intervals.
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<Interval>();
        intervals.add(new Interval(8, 10));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(15, 18));
        intervals.add(new Interval(1, 3));
        System.out.println(MergeIntervals.merge(intervals));
    }
}