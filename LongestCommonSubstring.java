
public class LongestCommonSubstring {

	
	private static int LCSubString (String a, String b){
		int ret = 0;
		int[][] LCSStates = new int[a.length() + 1][b.length() + 1];
		
		// init states
		LCSStates[0][0] = 0;
        
		for(int i = 1; i < a.length(); i++){
			LCSStates[i][0] = 0;
		}
		
		for(int j = 1; j < b.length(); j++){
			LCSStates[0][j] = 0;
		}
		
		// following steps build LCSStates[][] in bottom up fashion
		for(int i = 1; i <= a.length(); i++ ){
			for(int j = 1; j <= b.length(); j++){
				if(a.charAt(i-1) == b.charAt(j-1)){
					LCSStates[i][j] = LCSStates[i-1][j-1] + 1;
					ret = Math.max(ret, LCSStates[i][j]);
				}else{
					LCSStates[i][j] = 0;
				}
			}
		}
		
		// print out the states matrix
		for(int i = 1; i <= a.length(); i++ ){
			for(int j = 1; j <= b.length(); j++){
				System.out.print(LCSStates[i][j]);
			}
			System.out.println("");
		}
		
		return ret;
	}
	

	public static void main(String[] args) {
		String a = "GeeksforGeeks";
		String b = "GeeksQuiz";
		System.out.println(LCSubString(a , b));
		

	}

}
