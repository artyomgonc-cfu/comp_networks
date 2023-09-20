import java.lang.Math;
import java.util.Scanner;

class Pair {
    public double x, y;
    public String msg;
}

class QEquation {
    private int a, b, c;
    public int a() {return a;}
    public int b() {return b;}
    public int c() {return c;}
    
    public QEquation (int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
    
    public QEquation (Scanner s) {
        this.a = s.nextInt();
        this.b = s.nextInt();
        this.c = s.nextInt();
    }
    
    private int d() {
        return b*b-4*a*c;
    }
    
    public Pair get_ans() {
        Pair p = new Pair();
        int discr = d();
        
        if (a == 0) {
            if (b == 0) p.msg = "no";
            else {
                p.x = -Double.valueOf(c)/b;
                p.msg = "single";
            }
            return p;
        }
        
        if (discr > 0) {
            p.x = (-b-Math.sqrt(discr))/2/a;
            p.y = (-b+Math.sqrt(discr))/2/a;
            p.msg = "double";
        }
        
        if (discr == 0) {
            p.x = p.y = -Double.valueOf(b)/2/a;
            p.msg = "single";
        }
        
        if (discr < 0) {
            p.msg = "no";
        }
        
        return p;
    }
}

class Solution {
    public static void main(String[] args) {
        process(new QEquation(5,4,-10));
        process(new QEquation(3,0,4));
        process(new QEquation(0,3,-4));
        process(new QEquation(0,0,-4));
        process(new QEquation(5,0,0));
        
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
            process(new QEquation(scan));
        }
        // 1 5 6
        // 2 1 -1
    }
    
    private static void process(QEquation qe) {
        System.out.printf("Solving equation ");
        if (qe.a() != 0) System.out.printf("%dx^2", qe.a());
        if (qe.b() > 0) System.out.printf("+%dx", qe.b());
        if (qe.b() < 0) System.out.printf("%dx", qe.b());
        if (qe.c() > 0) System.out.printf("+%d", qe.c());
        if (qe.c() < 0) System.out.printf("%d", qe.c());
        System.out.printf("=0 ...\n");
        
        Pair ans = qe.get_ans();
        if (ans.msg == "no") System.out.println("There is no answer (((");
        if (ans.msg == "single") System.out.printf("Answer: x=%f\n", ans.x);
        if (ans.msg == "double") System.out.printf("Answer: x1=%f, x2=%f\n", ans.x, ans.y);
        
        System.out.println();
    }
}
