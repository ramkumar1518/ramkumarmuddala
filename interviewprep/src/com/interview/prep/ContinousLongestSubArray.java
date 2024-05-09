package com.interview.prep;

public class ContinousLongestSubArray {


    public int findLength(int[] nums1, int[] nums2) {

        int[][] cls = new int[nums1.length+1][nums2.length+1];
        int max = 0;

        for(int i =1 ;nums1.length>=1;i++){
            for(int j =1 ;nums2.length>=1;j++ ){
                if(nums1[i]==nums2[j]){
                    cls[i][j]= cls[i-1][j-1]+1;
                    max = Math.max(max, cls[i][j]);
                }
            }
        }

        return max;
    }
}
