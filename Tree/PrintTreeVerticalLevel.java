
public class Main {
    public int min = Integer.MAX_VALUE;
    public int max = Integer.MIN_VALUE;
    
    private void findMinMax(TreeNode node, int horizontalDistance){
        if(node == null){
            return;
        }
        if(horizontalDistance < min){
            min = horizontalDistance;
        }
        if(horizontalDistance > min){
            max = horizontalDistance;
        }
        findMinMax(node.left, horizontalDistance - 1);
        findMinMax(node.right, horizontalDistance + 1);
    }
    
    // preorder traversal is enough, no need to level order
    private void printVerticalLine(TreeNode node, int lineNo, int horizontalDistance){
        if(node == null){
            return;
        }
        
        if(horizontalDistance == lineNo){
            System.out.print(node.val);
        }
        printVerticalLine(node.left, lineNo, horizontalDistance-1);
        printVerticalLine(node.right, lineNo, horizontalDistance+1);
    }
    
    public void verticalOrder(TreeNode root)
    {
        // Find min and max distances with resepect to root
        
        findMinMax(root, 0);
        
        // Iterate through all possible vertical lines starting
        // from the leftmost line and print nodes line by line
        for (int lineNo = min; lineNo <= max; lineNo++)
        {
            printVerticalLine(root, lineNo, 0);
            System.out.println();
        }
    }
}