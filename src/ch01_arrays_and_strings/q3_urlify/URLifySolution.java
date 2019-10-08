package ch01_arrays_and_strings.q3_urlify;

public class URLifySolution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(urlify("Mr John Smith    ".toCharArray(), 13));
	}

	//T = O(n)
	//S = O(n)	
	private static char[] urlify(char[] str, int trueLength) {
		int spaceCount = 0;
		
		for(int i=0; i<trueLength; i++) {
			if (str[i] == ' ') {
				spaceCount += 1;
			}
		}
		
		int index = trueLength + spaceCount * 2;
		
		if (trueLength < str.length) {
			str[trueLength] = '\0'; //String end character.
		}
		
		for(int i = trueLength-1; i >= 0; i--) {
			if (str[i] == ' ') {
				str[index-1] = '0';
				str[index-2] = '2';
				str[index-3] = '%';
				index = index - 3;
			}else {
				str[index-1] = str[i];
				index--;
			}
		}
		
		return str;
	}
}
