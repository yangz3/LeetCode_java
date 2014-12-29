public static void addParen(ArrayList<String> list, int leftRem, int rightRem, StringBuilder builder) {
    if (leftRem < 0 || rightRem < leftRem) return; // invalid state

    if (leftRem == 0 && rightRem == 0) { /* all out of left and right parentheses */
        String s = new String(builder.toString());
        list.add(s);
    } else {
        if (leftRem > 0) { // try a left paren, if there are some available
            builder.append('(');
            addParen(list, leftRem - 1, rightRem, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
        if (rightRem > leftRem) { // try a right paren, if there�s a matching left
            builder.append(')');
            addParen(list, leftRem, rightRem - 1, builder);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}

public static ArrayList<String> generateParens(int count) {
    StringBuilder builder = new StringBuilder();
    ArrayList<String> list = new ArrayList<String>();
    addParen(list, count, count, builder);
    return list;
}
