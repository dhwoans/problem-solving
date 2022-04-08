package Leetcode.medium;

public class Container_With_Most_Water {
    public int maxArea(int[] height) {
       int start =0;
       int result =0;
       int end =height.length-1;
       while (start<end){
           int len = Math.min(height[start],height[end]);
           int wid = end-start+1;
           result = Math.max(result,len*wid);
           if(height[start]<height[end]){
               start++;
           }else if(height[start]>height[end]){
               end--;
           }else{
               end--;
               start++;
           }
       }
        return result;
    }
}
