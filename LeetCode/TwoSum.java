/**
 * @author
 * @create 2018-07-25 11:13
 **/

package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        reverse("youareadouchebag");
        reverse("guoshuai");
    }

    public static void reverse(String s){
        StringBuilder sb=new StringBuilder();
        char[] chars=s.toCharArray();
        int i=0,j=chars.length-1;
        while (i<j){
            char temp=chars[j];
            chars[j--]=chars[i];
            chars[i++]=temp;
        }
        for (char c :
                chars) {
            sb.append(c);
        }
        System.out.println(sb.toString());
    }


    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int i;
        for( i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                break;
            }
            map.put(nums[i],i);
        }// end for
        return new int[]{i,map.get(target-nums[i])};
    }
    public static int[] twoSum1(int[] n, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n.length; i++) {
            int x = n[i];
            if (map.containsKey(target - x)) {
                return new int[]{map.get(target - x) + 1, i + 1};
            }
            map.put(x, i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
