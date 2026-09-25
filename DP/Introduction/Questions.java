// import java.util.*;
public class Questions{
     public int countFriends(int[] dp,int n){
        if(n == 0 || n==1){
            return dp[n] = 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int s = countFriends(dp,n-1);
        int p = (n-1)*countFriends(dp,n-2);
        return s+p;
    }
    public int countFriends_tab(int n ){
        int[] dp = new int[n+1];
        for(int i = 0 ; i <= n; i++){
            if(i == 0 || i == 1){
                dp[i] = 1;
                continue;
            }
            int s = dp[i-1];
            int p = (n-1)*dp[i-2];

            dp[i] = s+p;
        }
        return dp[n];
    }
    public int countFriendsPairings(int n) {
        
        // code here
        int[] dp = new int[n+1];
        return countFriends(dp,n);
        
    }
    // leetcode 70 ==========================================================================================================
    public int climbStairs_memo(int n, int[] dp) {
        if (n == 0 || n == 1) {
            return dp[n] = 1;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        int step1 = climbStairs_memo(n - 1, dp);
        int step2 = climbStairs_memo(n - 2, dp);
        return step1 + step2;
    }

    public int climbStairs_tab(int n) {
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if (i == 0 || i == 1) {
                dp[i] = 1;
                continue;
            }
            
            int step1 = dp[i - 1]; 
            int step2 = dp[i - 2];
            
            dp[i] = step1 + step2;
        }
        return dp[n];
    }
    public static int totalMazePaths_rec(int r,int c,int n,int m){
        if(r>n || c>m){
            return 0;
        }
        if(r == n && c == m){
            return 1;
        }
        int tw = 0;
        tw += totalMazePaths_rec(r,c+1,n,m);
        tw += totalMazePaths_rec(r+1,c+1,n,m);
        tw += totalMazePaths_rec(r+1,c,n,m);
        return tw;
    }
    public static int totalMazePaths_memo(int r,int c,int n,int m,int[][] dp){
        if(r == n && c == m){
            return dp[r][c] = 1;
        }
        if(dp[r][c]!=0){
            return dp[r][c];
        }
        int tw = 0;
        tw += totalMazePaths_memo(r,c+1,n,m,dp);
        tw += totalMazePaths_memo(r+1,c+1,n,m,dp);
        tw += totalMazePaths_memo(r+1,c,n,m,dp);
        return dp[r][c] = tw;
    }
    public static int totalMazePaths(int n,int m){
        //return totalMazePaths_rec(0,0,n,m);
        int[][] dp = new int[n+1][m+1];
        // return totalMazePaths_memo(0,0,n,m,dp);
        for(int r = 0 ; r <=n ; r++){
            for(int c = 0 ; c<= m ; c++){
                        if(r == n && c == m){
                    return dp[r][c] = 1;
                }
                if(dp[r][c]!=0){
                    return dp[r][c];
                }
                int tw = 0;
                tw += totalMazePaths_memo(r,c+1,n,m,dp);
                tw += totalMazePaths_memo(r+1,c+1,n,m,dp);
                tw += totalMazePaths_memo(r+1,c,n,m,dp);
                return dp[r][c] = tw;
            }
        }
    }
}
