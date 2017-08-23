package com.hhlzr.medium;

public class _4_MedianOfArrays {
	public static void main(String args[]){
		int[] input1 = {1,2};
		int[] input2 = {3,4};
		_4_MedianOfArrays moa = new _4_MedianOfArrays();
		System.out.println(moa.solutions(input1,input2));
	}
	
	public double solutions(int[] nums1,int[] nums2){
		int length = nums1.length + nums2.length;
		int[] nums3 = new int[length];
		int tempbignum = 0;
		int biggerflag = 0;
		int i,j;
		if(nums1.length==0 && nums2.length>0){
			if(nums2.length%2 == 0)
				return ((double)nums2[(nums2.length-2)/2]+(double)nums2[nums2.length/2])/2;
			else
				return nums2[nums2.length/2];
		}else if(nums2.length==0 && nums1.length>0){
			if(nums1.length%2 == 0)
				return ((double)nums1[(nums1.length-2)/2]+(double)nums1[nums1.length/2])/2;
			else
				return nums1[nums1.length/2];
		}else if(nums1.length==0 && nums2.length==0)
			return 0;
		if(nums1[0]>nums2[0]){
			biggerflag = 0;
			tempbignum = nums1[0];
			nums3[0] = nums2[0];
			i = 0;
			j = 1;
		}else{
			biggerflag = 1;
			tempbignum = nums2[0];
			nums3[0] = nums1[0];
			i = 1;
			j = 0;
		}
		for(;i<nums1.length && j<nums2.length;){
			if(biggerflag==0){
				if(tempbignum>nums2[j]){
					nums3[i+j] = nums2[j];
					j++;
				}else{
					nums3[i+j] = tempbignum;
					tempbignum = nums2[j];
					i++;
					biggerflag = 1;
				}
			}else{
				if(tempbignum>nums1[i]){
					nums3[i+j] = nums1[i];
					i++;
				}else{
					nums3[i+j] = tempbignum;
					tempbignum = nums1[i];
					j++;
					biggerflag = 0;
				}
			}
		}
		if(i==nums1.length)
			while(j<nums2.length){
				nums3[i+j] = nums2[j];
				j++;
			}
		else
			while(i<nums1.length){
				nums3[i+j] = nums1[i];
				i++;
			}
		if(length%2 == 0)
			return ((double)nums3[(length-2)/2]+(double)nums3[length/2])/2;
		else
			return nums3[length/2];
	}
}

