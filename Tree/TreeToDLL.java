/*
 helper function -- given two list nodes, join them
 together so the second immediately follow the first.
 Sets the .next of the first and the .previous of the second.
 */
public static void join(Node a, Node b) {
    a.right = b;
    b.left = a;
}


/*
 helper function -- given two circular doubly linked
 lists, append them and return the new list.
 */
public static Node append(Node a, Node b) {
    // if either is null, return the other
    if (a==null) return(b);
    if (b==null) return(a);

    // find the last node in each using the .previous pointer
    Node aLast = a.left;
    Node bLast = b.left;

    // join the two together to make it connected and circular
    join(aLast, b);
    join(bLast, a);

    return(a);
}


/*
 --Recursion--
 Given an ordered binary tree, recursively change it into
 a circular doubly linked list which is returned.
 */
public static Node treeToList(Node root) {
    // base case: empty tree -> empty list
    if (root==null) return(null);

    // Recursively do the subtrees (leap of faith!)
    Node aList = treeToList(root.left);
    Node bList = treeToList(root.right);

    // Make the single root node into a list length-1
    // in preparation for the appending
    root.left = root;
    root.right = root;

    // At this point we have three lists, and it's
    // just a matter of appending them together
    // in the right order (aList, root, bList)
    aList = append(aList, root);
    aList = append(aList, bList);

    return(aList);
}




