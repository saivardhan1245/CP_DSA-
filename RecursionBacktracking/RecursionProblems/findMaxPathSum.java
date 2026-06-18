package RecursionBacktracking.RecursionProblems;

public class findMaxPathSum {
    public static int MaxPathSum(int[][] mat,int r,int c){

        if(r>=mat.length || c>=mat[0].length){
            return Integer.MIN_VALUE;
        }
        if(r==mat.length-1 && c==mat[0].length-1){
            return mat[r][c];
        }
        int rightSum = MaxPathSum(mat,r,c+1);
        int downSum = MaxPathSum(mat,r+1,c);
        int maxSum = mat[r][c] + Math.max(rightSum,downSum);
        return maxSum;
    }
    
     public static void main(String[] args){   
        int[][] mat = new int[2][3]; 
        int maxSum = MaxPathSum( mat,0,0);
        System.out.println(maxSum);
     }   
}
