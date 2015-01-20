Class Result{
    boolean pure;
    int value;
    int count;

    public result(boolean p, int v, int c){
this.pure = p;
this.value = v;
this.count = c;
    }
}

public int countSubtree(TreeNode root){
    Result r = helper(root);
    return r.count;
}

Result helper(TreeNode node){
if(node.left == null && node.right == null){
return new Result(true, node.val, 1);
}

Result lr = helper(node.left);
Result rr = helper(node.right);

Result tr;
if(lr.pure == true && rr.pure == ture){
if(lr.value == rr.value){
tr.count =
}
}
}