import java.util.*;
import java.io.*;
import java.lang.Math;

class Solution{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for (int num = 0; num < n; num++) {
                int ans = a;
                int pow2 = 1;
                for (int iter = 0; iter <= num; iter++) {
                    ans += b*pow2;
                    pow2 *= 2;
                }
                System.out.printf("%d ", ans);
            }
            System.out.printf("\n");
        }
        in.close();
    }
}
