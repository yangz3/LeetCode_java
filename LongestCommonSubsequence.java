
public class LongestCommonSubsequence {
	
	private static int LCSubsequence(String a, String b){
		int[][] LCSStates = new int[a.length() + 1][b.length() + 1];
		// init states
		LCSStates[0][0] = 0;
		for(int i = 1; i <= a.length(); i++ ){
			LCSStates[i][0] = 0;
		}
		for(int j = 1; j <= b.length(); j++ ){
			LCSStates[0][j] = 0;
		}
		
		// build up the states matrix
		for(int i = 1; i <= a.length(); i++){
			for(int j = 1; j <= b.length(); j++){
				if(a.charAt(i - 1) == b.charAt(j - 1)){
					LCSStates[i][j] = LCSStates[i - 1][j - 1] + 1;
				}else{
					LCSStates[i][j] = Math.max(LCSStates[i - 1][j], LCSStates[i][j - 1]);
				}
			}
		}
		
		// print out the states matrix
		for (int i = 0; i <= a.length(); i++) {
			for (int j = 0; j <= b.length(); j++) {
				System.out.print(LCSStates[i][j]);
			}
			System.out.println("");
		}
		
		return LCSStates[a.length()][b.length()] ;
	}

	public static void main(String[] args) {
		String a = "AGGTAB";
		String b = "GXTXAYB";
		System.out.println(LCSubsequence(a, b));
		

	}

}
