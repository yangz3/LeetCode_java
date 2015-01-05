public static void makeChange(int amountLeft, int[] denoms, int pos) {
    if(amountLeft == 0){
        counter++;
        return;
    }
    for(int i = pos; i < denoms.length; i++){
        if(amountLeft >= denoms[i]){
            makeChange3(amountLeft - denoms[i], denoms, i);
        }
    }
}


public static int makeChange1(int n) {
    int[] denoms = {25, 10, 5, 1};
    return makeChange(n, denoms, 0);
}

