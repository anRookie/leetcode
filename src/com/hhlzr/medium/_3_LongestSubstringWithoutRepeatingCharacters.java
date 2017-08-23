package com.hhlzr.medium;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class _3_LongestSubstringWithoutRepeatingCharacters {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_3_LongestSubstringWithoutRepeatingCharacters lswrc = new _3_LongestSubstringWithoutRepeatingCharacters();
		String s = "abcabcaa";
		System.out.println(lswrc.lengthOfLongestSubstring3(s));
	}

	public int lengthOfLongestSubstring(String s) {
		//超时严重，因为用了LinkedHashMap
		int length = 0;
		int maxLength = 0;
		int beginIndex = 0;
		int endIndex = 1;
		int interator = 0;
		int equalLocate = 0;
		Map<Character,Integer> map = new LinkedHashMap<>();
		char ch;
		while(interator!=s.length()){
//			System.out.println("\ns.substring:"+s.substring(beginIndex));
			ch = s.charAt(beginIndex);
//			System.out.println("length:"+length);
//			System.out.println("beginIndex:"+beginIndex+", endIndex:"+endIndex);
//			System.out.println("interator:"+interator);
//			System.out.println("ch:"+ch);
//			System.out.println("map.values:"+map.values());
			if (map.containsKey(ch)){
				equalLocate = map.get(ch);
//				System.out.println("equalLocate:"+equalLocate);
				interator = equalLocate;
				beginIndex = equalLocate + 1;
				endIndex = beginIndex + 1;
				if (length>maxLength)
					maxLength = length;
				length = 0;
				map.clear();
			}else{
				map.put(ch,interator);
				beginIndex++;
				endIndex++;
				length++;
			}
			interator++;
		}
		return maxLength>length?maxLength:length;
	}
	
	public int lengthOfLongestSubstring2(String s) {
		//较慢，因为用了HashSet
		//时间复杂度O(n)，空间复杂度O(n)
		int length = 0;
		int maxLength = 0;
		int interator = 0;
		Set<Character> set = new HashSet<>();
		char ch;
		while(interator!=s.length()){
			System.out.println("\ns.substring:"+s.substring(interator));
			ch = s.charAt(interator);
			System.out.println("length:"+length);
			System.out.println("interator:"+interator);
			System.out.println("ch:"+ch);
			System.out.println("set.values:"+set.stream());
			if (set.contains(ch)){
				interator = interator-length+1;
				if (length>maxLength)
					maxLength = length;
				length = 0;
				set.clear();
			}else{
				set.add(ch);
				length++;
				interator++;
			}
		}
		return maxLength>length?maxLength:length;
	}
	
	public int lengthOfLongestSubstring3(String s) {
		//discuss中  zahid2 的答案，Kadane's algorithm
		/*no need for O(n) space. Here is an O(n) time O(1) space solution using Kadane's algorithm
		Idea is that, while we traverse form left to right if we see a character at position j is a
		duplicate of a character at a position i < j on the left then we know that we can't start 
		the substring from i anymore. So, we need to start a new substring from i+1 position. While 
		doing this we also need to update the length of current substring and start of current substring.
		Important part of this process is to make sure that we always keep the latest position of the 
		characters we have seen so far. Below is a simple O(n) implementation of this logic.*/
		//时间复杂度O(n)，空间复杂度O(1)
		//设置一个长度256的数组，下标是字符的ASCII码，内容存放该字符当前的有效位置，有效位置就是指已经遍历过的所有该字母的最靠后的（最大）一个值。
		//比较规则。start是子串开始的位置，如果查询字符的值小于这个值，说明还没有出现过，继续；如果大于这个值，说明这个字符在start后、当前位置前出现过，重复；
		//	如果等于，说明这个字符是start位置的字符相同，重复。
		//重复的处理。重复后，取重复的位置，start设为重复后一位，长度是重复位置-start+1，这个字母的值设为当前值。
        int lastIndices[] = new int[256];
        for(int i = 0; i<256; i++){
            lastIndices[i] = -1;
        }
        int maxLen = 0;
        int curLen = 0;
        int start = 0;
        int bestStart = 0;
        for(int i = 0; i<s.length(); i++){
            char cur = s.charAt(i);			//对字符串遍历一遍，没有回退重复遍历
            if(lastIndices[cur]  < start){   //字符没有重复，查询某个字符的内容值，若大于等于start，则说明存入了子序列中
                lastIndices[cur] = i;		//数组下标是字母（asc码），内容是在字符串内的位置
                curLen++;
            }
            else{	//出现字符重复
                int lastIndex = lastIndices[cur];	//数组下标是字母（asc码），重复字母的位置
                start = lastIndex+1;		//从其后面1位开始
                curLen = i-start+1;
                lastIndices[cur] = i;	//设置该字母内容值为当前位置
            }
            if(curLen > maxLen){
                maxLen = curLen;
                bestStart = start;
            }
        }

        return maxLen;
    }
}
