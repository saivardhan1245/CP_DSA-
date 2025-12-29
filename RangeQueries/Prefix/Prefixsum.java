package RangeQueries.Prefix;



import java.io.*;
/*
Pattern: Prefix Sum (1D)
Problem Type: Range Sum Queries
Key Idea:
- pref[i] stores sum of elements from 1 to i
- Range sum (l, r) = pref[r] - pref[l - 1]

Time Complexity:
- Preprocessing: O(n)
- Each query: O(1)

Space Complexity: O(n)
*/


public class Prefixsum{
    static FastScanner fs = new FastScanner();
    static StringBuilder out = new StringBuilder();

    public static void main(String[] args) throws Exception {
       
        // t = fs.nextInt();   // uncomment if multiple test cases
        
        // while (q-- > 0) {
            solve();
        // }
        System.out.print(out.toString());
    }

    static void solve() throws Exception {
        // write problem logic here
         int n = fs.nextInt();
        int q = fs.nextInt();
        long[] pref = new long[n + 1];
        //  sum(a,b) = prefix(b)-prefix(a-1)
        for(int i = 1 ; i <= n ;i++){
            pref[i] = pref[i-1]+fs.nextLong();
        }
        while(q-->0){
            int a = fs.nextInt();
            int b = fs.nextInt();
            long ans = pref[b]-pref[a-1];
            out.append(ans).append("\n");
        }


    }

    static class FastScanner {
        private final byte[] buffer = new byte[1 << 16];
        private int ptr = 0, len = 0;
        private final InputStream in = System.in;

        private int read() throws IOException {
            if (ptr >= len) {
                len = in.read(buffer);
                ptr = 0;
                if (len <= 0) return -1;
            }
            return buffer[ptr++];
        }

        int nextInt() throws IOException {
            int c, sign = 1, val = 0;
            do { c = read(); } while (c <= ' ');
            if (c == '-') { sign = -1; c = read(); }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        long nextLong() throws IOException {
            int c, sign = 1;
            long val = 0;
            do { c = read(); } while (c <= ' ');
            if (c == '-') { sign = -1; c = read(); }
            while (c > ' ') {
                val = val * 10 + (c - '0');
                c = read();
            }
            return val * sign;
        }

        String next() throws IOException {
            int c;
            StringBuilder sb = new StringBuilder();
            do { c = read(); } while (c <= ' ');
            while (c > ' ') {
                sb.append((char)c);
                c = read();
            }
            return sb.toString();
        }
    }
}

