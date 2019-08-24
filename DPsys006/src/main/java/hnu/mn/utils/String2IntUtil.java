package hnu.mn.utils;

public  class String2IntUtil {
	public static Boolean Str2Int(String string) {
		//字符串转为整数是否可以的判断。
		int n=string.length();
		
		int start=0;
		for (int i = 0; i < string.length(); i++) {
			char c = string.charAt(i);
			if (c=='0'||c=='1'||c=='2'||c=='3'||c=='4'||
				c=='5'||c=='6'||c=='7'||c=='8'||c=='9') {
				start++;
			}
		}
		
		return n==start;
		
	}
}
