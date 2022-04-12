package Leetcode.easy;


public class FirstBadVersion {
    public int firstBadVersion(int n) {
        int start = 0;
        int end = n;
        while (start <= end) {
            int mid = start + end >>> 1;
            if (!isBadVersion(mid)) {
                if (isBadVersion(mid + 1)) return mid;
                start = mid + 1;
            } else {
                if (isBadVersion(mid - 1)) return mid - 1;
                end = mid - 1;
            }
        }
        return 0;
    }
    public boolean isBadVersion(int mid){
        //생략
        return false;
    }

}
