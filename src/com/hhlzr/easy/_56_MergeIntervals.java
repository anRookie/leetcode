package com.hhlzr.easy;

import java.util.LinkedList;
import java.util.List;

class Interval {
	 int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class _56_MergeIntervals {
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	public List<Interval> merge(List<Interval> intervals) {
//用时较长
		if(intervals.size()==0)
            return intervals;
		for(int i=0;i<intervals.size()-1;i++){
			int tStart1 = intervals.get(i).start;
			for(int j=i+1;j<intervals.size();j++){
				int tStart2 = intervals.get(j).start;
				if(tStart1>tStart2){
					Interval temp = new Interval();
					temp = intervals.get(j);
					intervals.get(j).start = intervals.get(i).start;
					intervals.get(j).end = intervals.get(i).end;
					intervals.get(i).start = temp.start;
					intervals.get(i).end = temp.end;
				}
			}
		}
        int th = intervals.get(0).end;
        int tIndex = 0;
        for(int i=1;i<intervals.size();i++){
        	Interval interval = intervals.get(i);
        	if(interval.start<=th && interval.end>=th){
        		intervals.get(i).start = intervals.get(tIndex).start;
        		intervals.remove(tIndex);
        		th = interval.end;
        		tIndex = i;
        	}else
        		tIndex = i;
        }
        return intervals;
    }
	
	public static List<Interval> solution1(List<Interval> intervals) {
/*A simple Java solution
	The idea is to sort the intervals by their starting points. 
	Then, we take the first interval and compare its end with the next intervals starts. 
	As long as they overlap, we update the end to be the max end of the overlapping intervals. 
	Once we find a non overlapping interval, we can add the previous "extended" interval and start over.
	Sorting takes O(n log(n)) and merging the intervals takes O(n). So, the resulting algorithm takes O(n log(n)).
	I used an a lambda comparator (Java 8) and a for-each loop to try to keep the code clean and simple.*/
		if (intervals.size() <= 1)
	        return intervals;
	    
	    // Sort by ascending starting point using an anonymous Comparator
	    intervals.sort((i1, i2) -> Integer.compare(i1.start, i2.start));
	    
	    List<Interval> result = new LinkedList<Interval>();
	    int start = intervals.get(0).start;
	    int end = intervals.get(0).end;
	    
	    for (Interval interval : intervals) {
	        if (interval.start <= end) // Overlapping intervals, move the end if needed
	            end = Math.max(end, interval.end);
	        else {                     // Disjoint intervals, add the previous one and reset bounds
	        	result.add(new Interval(start, end));
	            start = interval.start;
	            end = interval.end;
	        }
	    }
	    
	    // Add the last interval
	    result.add(new Interval(start, end));
	    return result;
	}
}
