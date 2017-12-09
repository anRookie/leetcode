package com.hhlzr.hard;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import common.Interval;

public class _57_Insert_Interval {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Interval> intervals = new ArrayList<Interval>();
		Interval newInterval1 = new Interval(1,5);
		Interval newInterval2 = new Interval(3,5);
		Interval newInterval3 = new Interval(6,7);
		Interval newInterval4 = new Interval(8,10);
		Interval newInterval5 = new Interval(12,16);

		Interval newInterval = new Interval(2,3);
		intervals.add(newInterval1);
//		intervals.add(newInterval2);
//		intervals.add(newInterval3);
//		intervals.add(newInterval4);
//		intervals.add(newInterval5);
		
		insert(intervals,newInterval);
	}
	
	public List<Interval> insert2(List<Interval> intervals, Interval newInterval) {
	    List<Interval> result = new LinkedList<>();
	    int i = 0;
	    // add all the intervals ending before newInterval starts
	    while (i < intervals.size() && intervals.get(i).end < newInterval.start)
	        result.add(intervals.get(i++));
	    // merge all overlapping intervals to one considering newInterval
	    while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
	        newInterval = new Interval( // we could mutate newInterval here also
	                Math.min(newInterval.start, intervals.get(i).start),
	                Math.max(newInterval.end, intervals.get(i).end));
	        i++;
	    }
	    result.add(newInterval); // add the union of intervals we got
	    // add all the rest
	    while (i < intervals.size()) result.add(intervals.get(i++)); 
	    return result;
	}
	
	public List<Interval> insert3(List<Interval> intervals, Interval newInterval) {
	    List<Interval> result = new ArrayList<Interval>();
	    for (Interval i : intervals) {
	        if (newInterval == null || i.end < newInterval.start)
	            result.add(i);
	        else if (i.start > newInterval.end) {
	            result.add(newInterval);
	            result.add(i);
	            newInterval = null;
	        } else {
	            newInterval.start = Math.min(newInterval.start, i.start);
	            newInterval.end = Math.max(newInterval.end, i.end);
	        }
	    }
	    if (newInterval != null)
	        result.add(newInterval);
	    return result;
	}
	
	public static List<Interval> insert4(List<Interval> intervals, Interval newInterval) {
		List<Interval> ret = new LinkedList<Interval>();
		for(Interval i : intervals){
			if(newInterval == null || i.end<newInterval.start){
				ret.add(i);
			}else if(i.start>newInterval.end){
				ret.add(newInterval);
				ret.add(i);
				newInterval = null;
			}else{
				newInterval.start = Math.min(i.start,newInterval.start);
				newInterval.end = Math.max(i.end,newInterval.end);
			}
		}
		if(newInterval!=null)
			ret.add(newInterval);
		return ret;
	}
	
	public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		Interval int1 = null;
		Interval int2 = null;
		int locFlag1 = -1; //locFlag 0 means front of interval including the start,1 is in interval 
		int locFlag2 = -1;
		int start = newInterval.start;
		int end = newInterval.end;
		for(int i=0;i<intervals.size();i++){
			Interval temp = intervals.get(i);
			int tStart = temp.start;
			int tEnd = temp.end;
			if(locFlag1 == -1){
				if(start<tStart){
					locFlag1 = 0;
				}else if(start <= tEnd){
					locFlag1 = 1;
				}
				int1 = temp;
			}
			if(locFlag1 > -1){
				if(locFlag2 == -1){
					if(end<tStart){
						locFlag2 = 0;
					}else if(end <= tEnd){
						locFlag2 = 1;
					}
				}
			}
			if(locFlag2 > -1){
				int2 = temp;
			}
		}
		if(int1==null && int2==null){
			intervals.add(0, newInterval);
			return intervals;
		}
		System.out.print(locFlag1+"/t"+locFlag2+"/t");//+int1.start+"/t"+int1.end+"/t"+int2.start+"/t"+int2.end
		for(int i=0;i<intervals.size();i++){
			Interval temp = intervals.get(i);
			int tStart = temp.start;
			int tEnd = temp.end;
			if(locFlag1==0 && locFlag2==0){
				if(int1.start==tStart && int1.end==tEnd){
					int j = i;
					while (tStart<end && j<intervals.size()-1) {
						intervals.remove(j);
						tStart = intervals.get(j).start;
					}
					intervals.add(i, new Interval(start,end));
				}
			}else if(locFlag1==0 && locFlag2==1){
				if(int1.start==tStart && int1.end==tEnd){
					int j = i;
					while (tStart<end && j<intervals.size()-1) {
						intervals.remove(j);
						tStart = intervals.get(j).start;
						tEnd = intervals.get(j).end;
					}
					int tEnd2 = intervals.get(j-2).end;
					intervals.add(i, new Interval(start,tEnd2));
					intervals.add(i+1, new Interval(tStart,tEnd));
				}
			}else if(locFlag1==1 && locFlag2==0){
				if(int1.start==tStart && int1.end==tEnd){
					int j = i;
					int tStart2 = tStart;
					while (tStart2<end && j<intervals.size()-1) {
						intervals.remove(j);
						tStart2 = intervals.get(j).start;
						tEnd = intervals.get(j).end;
					}
					intervals.add(i, new Interval(tStart,end));
				}
			}else if(locFlag1==1 && locFlag2==1){
				if(int1.start==tStart && int1.end==tEnd){
					int j = i;
					int tStart2 = tStart;
					while (tStart2<end && j<intervals.size()-1) {
						intervals.remove(j);
						tStart2 = intervals.get(j).start;
						tEnd = intervals.get(j).end;
					}
					intervals.add(i, new Interval(tStart,tEnd));
					break;
				}
			}
		}
		
		return intervals;
    }
}
