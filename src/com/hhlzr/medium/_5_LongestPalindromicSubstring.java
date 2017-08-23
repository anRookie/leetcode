package com.hhlzr.medium;

public class _5_LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_5_LongestPalindromicSubstring lps = new _5_LongestPalindromicSubstring();
		String input = "ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy";
		System.out.println(longestPalindrome3(input));
	}

	public String soulutions(String s) {
		// 因为使用StringBuffer,本地能够跑出正确答案，但是提交到OJ时提示超时
		int beginIndex = 0;
		int endIndex = 0;
		int length = 0;
		StringBuffer reverse_s = new StringBuffer();
		for (int i = 0; i < s.length(); i++)
			for (int j = i + 1; j <= s.length(); j++) {

				reverse_s = reverse_s.append(s.substring(i, j)).reverse();
				// System.out.println("i:"+i+"j:"+j);
				// System.out.println("s.substring(i,j):"+s.substring(i,j));
				// System.out.println("reverse_s:"+reverse_s);
				if (s.substring(i, j).equals(reverse_s.toString())) {
					if (s.substring(i, j).length() > length) {
						length = s.substring(i, j).length();
						beginIndex = i;
						endIndex = j;
						// System.out.println("equals--i:"+i+"j:"+j);
					}
				}
				reverse_s.delete(0, j - i);
			}
		// System.out.println("beginIndex:"+beginIndex+",endIndex:"+endIndex);
		return s.substring(beginIndex, endIndex);
	}

	public String soulutions1(String s) {
		// 因为使用StringBuffer,本地能够跑出正确答案，但是提交到OJ时提示超时
		int beginIndex = 0;
		int endIndex = 0;
		int length = 0;
		for (int i = 0; i < s.length(); i++)
			for (int j = i + 1; j <= s.length(); j++) {
				// System.out.println("i:"+i+"j:"+j);
				// System.out.println("s.substring(i,j):"+s.substring(i,j));
				// System.out.println("reverse_s:"+reverse_s);
				if (isPalindrome(s, i, j)) {
					if (s.substring(i, j).length() > length) {
						length = s.substring(i, j).length();
						beginIndex = i;
						endIndex = j;
						// System.out.println("equals--i:"+i+"j:"+j);
					}
				}
			}
		// System.out.println("beginIndex:"+beginIndex+",endIndex:"+endIndex);
		return s.substring(beginIndex, endIndex);
	}

	public boolean isPalindrome(String s, int begin, int end) {
		if (begin < 0)
			return false;
		while (begin < end) {
			if (s.charAt(begin++) != s.charAt(end--))
				return false;
		}
		return true;
	}

	// (AC) relatively short and very clear Java solution
	/*
	 * For friends who are confused about the key idea to check only new
	 * palindrome with length = current length +2 or +1, I add some more
	 * explanation here.
	 * 
	 * Example: "xxxbcbxxxxxa", (x is random character, not all x are equal) now
	 * we are dealing with the last character 'a'. The current longest
	 * palindrome is "bcb" with length 3. 1. check "xxxxa" so if it is
	 * palindrome we could get a new palindrome of length 5. 2. check "xxxa" so
	 * if it is palindrome we could get a new palindrome of length 4. 3. do NOT
	 * check "xxa" or any shorter string since the length of the new string is
	 * no bigger than current longest length. 4. do NOT check "xxxxxa" or any
	 * longer string because if "xxxxxa" is palindrome then "xxxx" got from
	 * cutting off the head and tail is also palindrom. It has length > 3 which
	 * is impossible.'
	 */
	/*只有小于等于两层遍历才能不超时通过测试，用三层遍历会超时。该法第一层遍历字符串，以每个字符作为子串的最后一个字符。第二层遍历，再比较这个子串是否是对称子串。
	思想：如果当前长度为3，遍历到字符a,那么只需比较两种情况是否是对称子串 1. XXXa,如果是，则长度+1；2. XXXXa,如果是，则长度+2.
	其他情况都不用比较，因为  1.如果长度小于XXXa的子串，如XXa，如过是对称子串，长度也不超过3；
	2.	 XXXXXa,如果是对称子串，则长度a前的四个XXXX也是对称的子串，所以当前长度是4而不是3，应以长度为4考虑上面的两种情况.*/
	/*public class Solution2 {
		public String longestPalindrome(String s) {
			String res = "";
			int currLength = 0;
			for (int i = 0; i < s.length(); i++) {
				if (isPalindrome(s, i - currLength - 1, i)) {
					res = s.substring(i - currLength - 1, i + 1);
					currLength = currLength + 2;
				} else if (isPalindrome(s, i - currLength, i)) {
					res = s.substring(i - currLength, i + 1);
					currLength = currLength + 1;
				}
			}
			return res;
		}

		public boolean isPalindrome(String s, int begin, int end) {
			if (begin < 0)
				return false;
			while (begin < end) {
				if (s.charAt(begin++) != s.charAt(end--))
					return false;
			}
			return true;
		}
	}*/
	

	/*只有小于等于两层遍历才能不超时通过测试，用三层遍历会超时。该法用了三层遍历，未通过测试。前两层遍历字符串，取出每个子串。
	 * 第三层遍历，再比较这个子串是否是对称子串。*/
	static public String longestPalindrome3(String s) {
		if (s.length() < 2)
			return s;
		int currLength=0;
		int maxLength = 1;
		int indexstart=0;
		int indexend=0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + maxLength; j < s.length(); j++) {
//				System.out.println(" i:" + i + " j:" + j);
//				System.out.println("s.substring("+i+","+j+")" + s.substring(i, j+1).length());
				if (isPalindrome(s.substring(i, j+1))) {
					currLength = s.substring(i, j+1).length();
//					System.out.println("currLength:" + currLength);
					if (currLength > maxLength) {
						maxLength = currLength;
						indexstart = i;
						indexend = j;
//						System.out.println("maxLength:" + maxLength + " i:" + i + " j:" + j);
					}
				}
			}
		}
		return s.substring(indexstart, indexend+1);
	}

	static public boolean isPalindrome(String s) {
//		System.out.println("s.length()  "+s.length());
//		System.out.println("s.length() / 2  "+s.length() / 2);
		for (int i = 0; i < s.length() / 2; i++){
//			System.out.println("s.charAt("+i+")"+s.charAt(i));
//			System.out.println("s.charAt("+(s.length() - 1 - i)+")"+s.charAt(s.length() - 1 - i));
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}

	/*只有小于等于两层循环才能不超时通过测试，用三层循环会超时。该法第一层遍历字符串，两种情况，子串长度为奇数，以每个字符作为子串的中间字符；
	 * 子串长度为偶数，以相邻两个字符作为子串的中间字符。
	 * 第二层循环，向两边扩展判断是否仍是对称子串。*/
	public class Solution2 {
		//
		private int lo, maxLen;

		public String longestPalindrome(String s) {
			int len = s.length();
			if (len < 2)
				return s;
			
		    for (int i = 0; i < len-1; i++) {
		     	extendPalindrome(s, i, i);  //assume odd length, try to extend Palindrome as possible
		     	extendPalindrome(s, i, i+1); //assume even length.
		    }
		    return s.substring(lo, lo + maxLen);
		}

		private void extendPalindrome(String s, int j, int k) {
			while (j >= 0 && k < s.length() && s.charAt(j) == s.charAt(k)) {
				j--;
				k++;
			}
			if (maxLen < k - j - 1) {
				lo = j + 1;
				maxLen = k - j - 1;
			}
		}}
}
