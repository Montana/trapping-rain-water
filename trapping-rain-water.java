public class Solution {
    public int trap(int[] A) {
        int res = 0;
        if (A.length < 2)
            return res;
        int[] leftMost = new int[A.length];
        int[] rightMost = new int[A.length];
        // init 
        leftMost[0] = 0;
        rightMost[A.length - 1] = 0;
        for (int i = 1; i < A.length - 1; i++) {
            leftMost[i] = Math.max(leftMost[i - 1], A[i - 1]);
        }
        for (int i = A.length - 2; i >= 0; i--) {
            rightMost[i] = Math.max(rightMost[i + 1], A[i + 1]);
        }
        for (int i = 0; i < A.length; i++) {
            if (Math.min(leftMost[i], rightMost[i]) - A[i] > 0) {
                res += Math.min(leftMost[i], rightMost[i]) - A[i];
            }
        }
        return res;
    }
}
