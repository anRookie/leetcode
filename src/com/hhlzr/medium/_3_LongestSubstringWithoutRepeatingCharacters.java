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
		//��ʱ���أ���Ϊ����LinkedHashMap
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
		//��������Ϊ����HashSet
		//ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(n)
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
		//discuss��  zahid2 �Ĵ𰸣�Kadane's algorithm
		/*no need for O(n) space. Here is an O(n) time O(1) space solution using Kadane's algorithm
		Idea is that, while we traverse form left to right if we see a character at position j is a
		duplicate of a character at a position i < j on the left then we know that we can't start 
		the substring from i anymore. So, we need to start a new substring from i+1 position. While 
		doing this we also need to update the length of current substring and start of current substring.
		Important part of this process is to make sure that we always keep the latest position of the 
		characters we have seen so far. Below is a simple O(n) implementation of this logic.*/
		//ʱ�临�Ӷ�O(n)���ռ临�Ӷ�O(1)
		//����һ������256�����飬�±����ַ���ASCII�룬���ݴ�Ÿ��ַ���ǰ����Чλ�ã���Чλ�þ���ָ�Ѿ������������и���ĸ�����ģ����һ��ֵ��
		//�ȽϹ���start���Ӵ���ʼ��λ�ã������ѯ�ַ���ֵС�����ֵ��˵����û�г��ֹ�������������������ֵ��˵������ַ���start�󡢵�ǰλ��ǰ���ֹ����ظ���
		//	������ڣ�˵������ַ���startλ�õ��ַ���ͬ���ظ���
		//�ظ��Ĵ����ظ���ȡ�ظ���λ�ã�start��Ϊ�ظ���һλ���������ظ�λ��-start+1�������ĸ��ֵ��Ϊ��ǰֵ��
        int lastIndices[] = new int[256];
        for(int i = 0; i<256; i++){
            lastIndices[i] = -1;
        }
        int maxLen = 0;
        int curLen = 0;
        int start = 0;
        int bestStart = 0;
        for(int i = 0; i<s.length(); i++){
            char cur = s.charAt(i);			//���ַ�������һ�飬û�л����ظ�����
            if(lastIndices[cur]  < start){   //�ַ�û���ظ�����ѯĳ���ַ�������ֵ�������ڵ���start����˵����������������
                lastIndices[cur] = i;		//�����±�����ĸ��asc�룩�����������ַ����ڵ�λ��
                curLen++;
            }
            else{	//�����ַ��ظ�
                int lastIndex = lastIndices[cur];	//�����±�����ĸ��asc�룩���ظ���ĸ��λ��
                start = lastIndex+1;		//�������1λ��ʼ
                curLen = i-start+1;
                lastIndices[cur] = i;	//���ø���ĸ����ֵΪ��ǰλ��
            }
            if(curLen > maxLen){
                maxLen = curLen;
                bestStart = start;
            }
        }

        return maxLen;
    }
}
