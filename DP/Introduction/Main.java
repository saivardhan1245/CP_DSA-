import java.util.*;
public class Main{
    public static int fib_memo(int n,int[] memo){
        if(n == 0   || n == 1){
            return memo[n]=n;
        }
        if(memo[n]!=0){
            return memo[n];
        }
        int ft = fib_memo(n-1,memo);
        int st = fib_memo(n-2,memo);
        return ft+st;
    }
    public static int fib_tab(int n){
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        for(int idx = 2; idx <= n ; idx++){
            dp[idx] = dp[idx-1] + dp[idx-2];
        }
        return dp[n];
    }
    public static int fib_tab_copyMemo(int N ){
        int[] dp = new int[N+1];
        for(int state = 0 ; state <= N; state++){
            if(state == 0 || state == 1){
                dp[state]=state;
                continue;
            }
            int lt = dp[state-1];
            int slt = dp[state-2];
            dp[state] = lt+slt;

        }
        return dp[N];
    }
    public static int findFibo(int n){
        int[] memo = new int[n+1];
        fib_memo(n,memo);
        return memo[n];
    }
    public static void main(String[] args){

        int n = 5;
        int fib_ans = findFibo(n);
    }
}