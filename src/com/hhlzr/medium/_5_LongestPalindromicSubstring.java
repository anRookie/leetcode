package com.hhlzr.medium;

public class _5_LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		_5_LongestPalindromicSubstring lps = new _5_LongestPalindromicSubstring();
		String input = "ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy";
		System.out.println(longestPalindrome3(input));
	}

	public String soulutions(String s) {
		// ��Ϊʹ��StringBuffer,�����ܹ��ܳ���ȷ�𰸣������ύ��OJʱ��ʾ��ʱ
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
		// ��Ϊʹ��StringBuffer,�����ܹ��ܳ���ȷ�𰸣������ύ��OJʱ��ʾ��ʱ
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
	/*ֻ��С�ڵ�������������ܲ���ʱͨ�����ԣ�����������ᳬʱ���÷���һ������ַ�������ÿ���ַ���Ϊ�Ӵ������һ���ַ����ڶ���������ٱȽ�����Ӵ��Ƿ��ǶԳ��Ӵ���
	˼�룺�����ǰ����Ϊ3���������ַ�a,��ôֻ��Ƚ���������Ƿ��ǶԳ��Ӵ� 1. XXXa,����ǣ��򳤶�+1��2. XXXXa,����ǣ��򳤶�+2.
	������������ñȽϣ���Ϊ  1.�������С��XXXa���Ӵ�����XXa������ǶԳ��Ӵ�������Ҳ������3��
	2.	 XXXXXa,����ǶԳ��Ӵ����򳤶�aǰ���ĸ�XXXXҲ�ǶԳƵ��Ӵ������Ե�ǰ������4������3��Ӧ�Գ���Ϊ4����������������.*/
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
	

	/*ֻ��С�ڵ�������������ܲ���ʱͨ�����ԣ�����������ᳬʱ���÷��������������δͨ�����ԡ�ǰ��������ַ�����ȡ��ÿ���Ӵ���
	 * ������������ٱȽ�����Ӵ��Ƿ��ǶԳ��Ӵ���*/
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

	/*ֻ��С�ڵ�������ѭ�����ܲ���ʱͨ�����ԣ�������ѭ���ᳬʱ���÷���һ������ַ���������������Ӵ�����Ϊ��������ÿ���ַ���Ϊ�Ӵ����м��ַ���
	 * �Ӵ�����Ϊż���������������ַ���Ϊ�Ӵ����м��ַ���
	 * �ڶ���ѭ������������չ�ж��Ƿ����ǶԳ��Ӵ���*/
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
