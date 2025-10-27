import java.io.*;
import java.util.*;

// https://codeforces.com/contest/600/problem/B
public class B_Queries_about_less_or_equal_elements {
    static FastReader in = new FastReader();
    static PrintWriter out = new PrintWriter(System.out);

    public static void main(String[] args) {
        out.println(solve());
        out.close();
    }

    private static String solve() {
        StringBuilder sb = new StringBuilder();
        // Add problem-specific solution logic here
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nums1 = new int[n];
        for(int i=0; i<n; i++) {
            nums1[i] = in.nextInt();
        }
        Arrays.sort(nums1);
        for(int i=0; i<m; i++) {
            int x = in.nextInt();
            int count = upperBound(nums1, x);
            sb.append(count).append(" ");
        }

        return sb.toString().trim();
    }

    private static int upperBound(int[] arr, int x) {
        int left = 0, right = arr.length;
        while(left < right) {
            int mid = left + (right-left) / 2;
            if(arr[mid] <= x) left = mid + 1;
            else right = mid;
        }
        return left;
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