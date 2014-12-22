
public class digitLetterPartitionCount {
    public int PartitionCount(String input){
        if (input == null || input.length() == 0 ){
            return 0;
        }
        int[] states = new int[input.length() + 1];
        states[0] = 1;
        states[1] = 1;
        for(int i = 2; i <= input.length(); i++){
            if(checkValid(input.charAt(i-2), input.charAt(i-1))){
                states[i] = states[i - 1] + states[i - 2];
            }else{
                states[i] = states[i - 1];
            }
        }
        
        return states[input.length()];
    }
    
    private boolean checkValid(char a, char b){
        int value = 10 * (int)((a - 'a') + 1) + (int)(b - 'a');
        return value <= 26;
    }
}
