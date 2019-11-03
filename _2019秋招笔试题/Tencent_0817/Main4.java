package _2019秋招笔试题.Tencent_0817;

import javafx.scene.control.RadioMenuItem;

/**
 * @version 1.0
 * @created by bill
 * @on 2019-08-17 21:14
 **/
public class Main4 {
    public static void main(String[] args) {
        int n = 6;
        int[] arr = new int[]{5,3,8,3,2,5};

        for (int i = 0; i <arr.length ; i++) {
            System.out.println (new Main4 ().extend (arr,i) + 1);
        }


    }

    int extend(int[] arr, int i){
        int left = i-1;
        int right = i+1;
        int res = 0;
        int max = 0;
        while(left >= 0){
            if(arr[left] > max) {
                res++;
                max = arr[left];
            }
            left--;
        }
        max = 0;
        while(right <arr.length){
            if(arr[right] > max) {
                res++;
                max = arr[right];
            }
            right++;
        }
        return res;
    }
}
