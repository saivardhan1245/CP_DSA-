package Arrays.Twopointers;

public class sortColors {
//https://leetcode.com/problems/sort-colors/description/
 void swap(int i ,int j , int[] arr){
        int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
    }
    public void sortColors(int[] nums) {
        int p1 = -1 , p2 = 0 , p3 = nums.length - 1;

        while(p2 <= p3){
            if(nums[p2] ==  1 ){
                p2++;
            }else if(nums[p2]==2){
                swap(p2,p3,nums);
                p3--;
            }else{
                swap(p1+1,p2,nums);
                p1++;
                p2++;
            }
        }
    }
}
