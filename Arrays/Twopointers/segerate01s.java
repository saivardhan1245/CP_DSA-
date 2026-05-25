//https://www.geeksforgeeks.org/problems/segregate-0s-and-1s5106/1
class Solution {
    void swap(int i ,int j , int[] arr){
        int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
    }
    void segregate0and1(int[] arr) {
        // code here
        int i = -1, j = arr.length - 1;
        while(i<j){
            if(arr[i+1] == 0 ){
                i++;
            }else{
                swap(i+1,j,arr);
                j--;
            }
        }
    }
}
