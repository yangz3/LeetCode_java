private int maxArea(int[] height){
    if (height == null || height.length == 0) {
        return 0;
    }

    Stack<Integer> stack = new Stack<Integer>();
    int max = 0;
    for (int i = 0; i <= height.length; i++) {
        int curt = (i == height.length) ? -1 : height[i];

        // maintain the stack at the same time compute the max area
        // the elements in the stack are in ascending order therefore the
        while (!stack.isEmpty() && curt <= height[stack.peek()]) {
            int h = height[stack.pop()];
            int w = stack.isEmpty() ? i : i - stack.peek() - 1;
            max = Math.max(max, h * w);
        }
        stack.push(i);
    }

    return max;
}