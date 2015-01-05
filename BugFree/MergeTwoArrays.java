public static void merge(int[] a, int[] b, int lastA, int lastB) {
    int indexMerged = lastB + lastA - 1; /* Index of last location of merged array */
    int indexA = lastA - 1; /* Index of last element in array b */
    int indexB = lastB - 1; /* Index of last element in array a */

    /* Merge a and b, starting from the last element in each */
    while (indexB >= 0) {
        if (indexA >= 0 && a[indexA] > b[indexB]) { /* end of a is bigger than end of b */
            a[indexMerged] = a[indexA]; // copy element
            indexA--;
        } else {
            a[indexMerged] = b[indexB]; // copy element
            indexB--;
        }
            indexMerged--; // move indices
    }
}