import java.io.*;
import java.util.*;

// https://codeforces.com/contest/466/problem/C
public class C_Number_of_Ways {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        out.println(solve());
        out.close();
    }

    private static String solve() {
        // Add problem-specific solution logic here
        int n = in.nextInt(); // Read the size of the array
        if (n <= 3)
            return "0";
        int[] nums = new int[n]; // Initialize the array
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt(); // Read each element of the array
        }
        long total = 0;
        for(int x: nums) total += x;
        if(total%3 != 0) return "0";

        long part = total/3;
        long twoPart = 2 * part;

        long prefix = 0;
        long countPart = 0;
        long ways = 0;

        for(int i=0; i<n-1; i++) {
            prefix += nums[i];

            if(prefix == twoPart) {
                ways += countPart;
            }

            if(prefix == part) {
                countPart++;
            }
        }

        return String.valueOf(ways);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }
    }
}