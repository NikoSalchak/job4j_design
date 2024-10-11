package ru.job4j.algo;

import java.util.*;

class Interval implements Comparable<Interval> {
    int start;
    int end;

    Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Interval interval) {
        if (start < interval.start) {
            return -1;
        } else if (start == end) {
            return 0;
        } else {
            return 1;
        }
    }

    @Override
    public String toString() {
        return "Interval{"
                + "start=" + start
                + ", end=" + end
                + '}';
    }
}

class Event implements Comparable<Event> {
    int time;
    boolean isStart;

    Event(int time, boolean isStart) {
        this.time = time;
        this.isStart = isStart;
    }

    @Override
    public int compareTo(Event other) {
        if (this.time == other.time) {
            return this.isStart ? -1 : 1;
        }
        return Integer.compare(this.time, other.time);
    }

    @Override
    public String toString() {
        return "Event{"
                + "time=" + time
                + ", isStart=" + isStart
                + '}';
    }
}

public class IntervalMain {

    public static int[] findMaxOverlapInterval(List<Interval> intervals) {
        Set<Interval> overlappingIntervals = new LinkedHashSet<>();
        if (intervals.size() == 1) {
            return new int[]{intervals.get(0).start, intervals.get(0).end};
        }
        for (int i = 0; i < intervals.size() - 1; i++) {
            if (intervals.get(i).end > intervals.get(i + 1).start) {
                overlappingIntervals.add(intervals.get(i));
                overlappingIntervals.add(intervals.get(i + 1));
            }
        }
        List<Event> events = new ArrayList<>();
        for (Interval interval : overlappingIntervals) {
            events.add(new Event(interval.start, true));
            events.add(new Event(interval.end, false));
        }
        Collections.sort(events);
        int l = -1;
        int r = Integer.MAX_VALUE;
        for (int i = 0; i < events.size(); i++) {
            if (events.get(i).isStart) {
                l = Math.max(l, events.get(i).time);
            } else if (!events.get(i).isStart && events.get(i).time > l) {
                r = Math.min(r, events.get(i).time);
            }
        }
        return l != -1 ? new int[]{l, r} : new int[]{-1, -1};
    }

    public static void main(String[] args) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(new Interval(1, 4));
        intervals.add(new Interval(2, 6));
        intervals.add(new Interval(3, 5));
        intervals.add(new Interval(7, 8));
        int[] result = findMaxOverlapInterval(intervals);
        System.out.println("Interval that overlaps the maximum number of intervals: [" + result[0] + ", " + result[1] + "]");
    }
}
