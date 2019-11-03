/**
 * @author
 * @create 2019-03-16 23:41
 **/

package ProblemSolving;

class KthLargestElement {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 2, 1, 5, 6, 4};
        int[] arr1 = new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6};
        int[] arr2 = new int[]{1};
//        int n = findKthLargest (arr1, 4);
        int n = findKthLargestQuickSelect (arr1, 4);
        System.out.println (n);

    }
    //k is always  1<= k <= nums.length


    /**
     Runtime: 1 ms, faster than 99.85% of Java online submissions for Kth Largest Element in an Array.
     Memory Usage: 38.6 MB, less than 73.71% of Java online submissions for Kth Largest Element in an Array.
     */
    public static int findKthLargestQuickSelect(int[] nums, int k) {
        //第k大也就是第length - k 小
        return quickSelect (nums, 0, nums.length-1, nums.length - k);
    }
    public static int quickSelect(int[] nums, int start, int end, int k) {
        int i = start - 1;
        //选择主元可以随机也可以选择中间位置
        //在元素几乎是排好序的情况下算法时间会表现依然很好。
        int mid = start + ((end - start) >>>1);
        int v = nums[mid];
        swap(nums, mid, end);
        for (int j = start; j < end; j++) {
            if (nums[j] <= v) {
                swap (nums, ++i, j);
            }
        }
        swap (nums, i + 1, end);
        //按照快排划分方式 进行一次划分
        //然后判断主元的位置是否为len - k
        //如果是就返回，如果k比主元索引大就在后半部分继续找，否则就在前面继续找

        if (i + 1 == k) {
            return nums[k];
        } else if (i + 1 > k) {
            return quickSelect (nums, start, i, k);
        } else {
            return quickSelect (nums, i + 2, end, k);
        }
    }



    /**
     * Kth Largest Element in an Array.
     * Runtime: 1 ms, faster than 99.85% of Java online submissions.
     * Memory Usage: 38.4 MB, less than 86.35% of Java online submissions.
     */
    public int findKthLargest(int[] nums, int k) {
        //开始调用函数创建小根堆
        buildHeap (nums, k);
        //便利数组剩余元素，没发现一个大于堆顶元素即将其赋值给堆顶元素
        //然后对其调用最小根性质化方法来维护堆性质
        for (int i = k; i < nums.length; i++) {
            if (nums[i] > nums[0]) {
                swap (nums, i, 0);
                minfyHeap (nums, 0, k);
            }
        }
        //最后 堆顶元素nums[0]就是第k大的数。
        return nums[0];
    }

    //建堆 如果堆原本就是以数组形式存储的话，只需要从非叶节点逆序便利依次调用维护堆性质即可
    public static void buildHeap(int[] arr, int size) {
        for (int i = size / 2 - 1; i >= 0; i--) {
            minfyHeap (arr, i, size);
        }
    }

    //维护小根堆性质
    public static void minfyHeap(int[] arr, int index, int size) {
        if (index < size) {
            int min = index;
            if (2 * (index + 1) - 1 < size) {
                min = arr[index] < arr[2 * (index + 1) - 1] ? index : 2 * (index + 1) - 1;
            }
            if (2 * (index + 1) < size) {
                min = arr[min] < arr[2 * (index + 1)] ? min : 2 * (index + 1);
            }
            if (min != index) {
                swap (arr, index, min);
                minfyHeap (arr, min, size);
            }
        }
    }

    //交换数组元素
    public static void swap(int[] nums, int n1, int n2) {
        int temp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = temp;
    }
    //链接：堆排序
    private static void HeapSort(int[] nums){
        //一、构建最大堆
        //二、逆序遍历数组，循环体内每次将nums[0]和nums[i]交换，
        //    然后堆的size减1再调用方法维护最大堆性质
        //三、循环结束排序完成
    }
}