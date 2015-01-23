public class Solution {
    public ArrayList<String> generateParenthesis(int n) {
        ArrayList<String> rst = new ArrayList<String>();
        StringBuilder builder = new StringBuilder();
        helper(rst, builder, n, n);
        return rst;
    }
    
    private void helper(ArrayList<String> rst, StringBuilder builder, int leftRemain, int rightRemain){
        if(leftRemain == 0 && rightRemain == 0){
            rst.add(builder.toString());
        }
        
        if(leftRemain > 0){
            builder.append('(');
            helper(rst, builder, leftRemain - 1, rightRemain);
            builder.deleteCharAt(builder.length() - 1);
        }
        if(rightRemain > leftRemain){
            builder.append(')');
            helper(rst, builder, leftRemain, rightRemain - 1);
            builder.deleteCharAt(builder.length() - 1);
        }
        
    }
}