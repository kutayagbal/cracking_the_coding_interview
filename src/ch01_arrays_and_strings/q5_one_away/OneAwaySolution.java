package ch01_arrays_and_strings.q5_one_away;

public class OneAwaySolution {

	public static void main(String[] args) {
		System.out.println(checkOneAway("pale","bae"));
	}
	
	private static boolean checkOneAway(String s1, String s2) {
		if (Math.abs(s1.length() - s2.length()) > 1){
			return false;
		}
		
		String strLong = s1.length() > s2.length() ? s1 : s2;
		String strSmall = s1.length() < s2.length() ? s1 :s2;
		
		boolean found = false;
		int indexLong = 0;
		int indexSmall = 0;
		while(indexLong < strLong.length() && indexSmall < strSmall.length()) {
			if (strLong.charAt(indexLong) != strSmall.charAt(indexSmall)) {
				if (found) {
					return false;
				}
				
				found = true;
				
				if(strLong.length() == strSmall.length()) {
					indexSmall++;
				}
			}else {
				indexSmall++;
			}
			
			indexLong++;
		}
		
		return true;
	}

}
