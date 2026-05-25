import java.util.*;

public class MathsUtils {

    // ================= GCD =================

    static int gcd(int a,int b){

        while(b!=0){

            int t = a%b;

            a = b;

            b = t;
        }

        return a;
    }


    // ================= LCM =================

    static int lcm(int a,int b){

        return (a/gcd(a,b))*b;
    }


    // ================= FAST POWER =================

    static long pow(long a,long b){

        long ans = 1;

        while(b>0){

            if((b&1)==1){
                ans *= a;
            }

            a *= a;

            b >>= 1;
        }

        return ans;
    }


    // ================= MODULAR POWER =================

    static long modPow(long a,long b,long mod){

        long ans = 1;

        a %= mod;

        while(b>0){

            if((b&1)==1){
                ans = (ans*a)%mod;
            }

            a = (a*a)%mod;

            b >>= 1;
        }

        return ans;
    }


    // ================= PRIME CHECK =================

    static boolean isPrime(int n){

        if(n<2) return false;

        for(int i=2;i*i<=n;i++){

            if(n%i==0){
                return false;
            }
        }

        return true;
    }


    // ================= SIEVE =================

    static boolean[] sieve(int n){

        boolean[] prime = new boolean[n+1];

        Arrays.fill(prime,true);

        prime[0] = false;
        prime[1] = false;

        for(int i=2;i*i<=n;i++){

            if(prime[i]){

                for(int j=i*i;j<=n;j+=i){

                    prime[j] = false;
                }
            }
        }

        return prime;
    }


    // ================= PREFIX SUM =================

    static int[] prefixSum(int[] arr){

        int n = arr.length;

        int[] pre = new int[n+1];

        for(int i=0;i<n;i++){

            pre[i+1] = pre[i] + arr[i];
        }

        return pre;
    }


    // ================= SUFFIX SUM =================

    static int[] suffixSum(int[] arr){

        int n = arr.length;

        int[] suf = new int[n+1];

        for(int i=n-1;i>=0;i--){

            suf[i] = suf[i+1] + arr[i];
        }

        return suf;
    }


    // ================= LOWER BOUND =================

    static int lowerBound(int[] arr,int x){

        int l = 0;
        int r = arr.length;

        while(l<r){

            int mid = l + (r-l)/2;

            if(arr[mid] < x){
                l = mid + 1;
            }
            else{
                r = mid;
            }
        }

        return l;
    }


    // ================= UPPER BOUND =================

    static int upperBound(int[] arr,int x){

        int l = 0;
        int r = arr.length;

        while(l<r){

            int mid = l + (r-l)/2;

            if(arr[mid] <= x){
                l = mid + 1;
            }
            else{
                r = mid;
            }
        }

        return l;
    }


    // ================= FACTORIAL PRECOMPUTE =================

    static long[] factorial(int n){

        long[] fact = new long[n+1];

        fact[0] = 1;

        for(int i=1;i<=n;i++){

            fact[i] = fact[i-1]*i;
        }

        return fact;
    }


    // ================= SPF =================

    static int[] spf(int n){

        int[] spf = new int[n+1];

        for(int i=0;i<=n;i++){
            spf[i] = i;
        }

        for(int i=2;i*i<=n;i++){

            if(spf[i]==i){

                for(int j=i*i;j<=n;j+=i){

                    if(spf[j]==j){
                        spf[j] = i;
                    }
                }
            }
        }

        return spf;
    }


    // ================= COUNT BITS =================

    static int countBits(int x){

        return Integer.bitCount(x);
    }


    // ================= POWER OF 2 =================

    static boolean isPowerOfTwo(int x){

        return x>0 && (x&(x-1))==0;
    }


    // ================= GET ITH BIT =================

    static int getBit(int x,int i){

        return (x>>i)&1;
    }


    // ================= SET ITH BIT =================

    static int setBit(int x,int i){

        return x | (1<<i);
    }


    // ================= REMOVE LAST SET BIT =================

    static int removeLastSetBit(int x){

        return x & (x-1);
    }
}